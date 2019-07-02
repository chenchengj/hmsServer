package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import IService.IFileService;
import util.FileUtil;

@Controller
@RequestMapping(value="/file")
public class FileController {
	
	private static String fileName;
	private static String fileType;
	
	@Resource
	private IFileService fileService;
	
	@RequestMapping(value = "/getFileName.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getFileName(HttpServletRequest request, HttpServletResponse response) throws Exception{
		fileName = new String(request.getParameter("fileName").getBytes("ISO8859-1"),"utf-8");
		fileType = new String(request.getParameter("fileType").getBytes("ISO8859-1"),"utf-8");
		
		return "success";
	}

	@RequestMapping(value = "/uploadFile.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream iStream = request.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);
		
		String filePath= fileService.upload(dis,fileName,fileType);
		
        
//        File file = new File("F:/homework/publish/111.docx");
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        FileOutputStream fps = null;
//        try {
//            fps = new FileOutputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        int bufferSize = 1024;
//        byte[] buffer = new byte[bufferSize];
//        int length = -1;
//
//        try {
//            while ((length = dis.read(buffer)) != -1) {
//                fps.write(buffer, 0, length);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            fps.flush();
//            fps.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    	
		request.getSession().invalidate();
        response.setContentType("text/html;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String result = "success";
        out.write(filePath.getBytes("utf-8"));
        out.flush();
        out.close();
        dis.close();
        iStream.close();
		
		return result;
		
		
	}
	
	@RequestMapping(value = "/downloadFile.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String publishUrl = new String(request.getParameter("publishUrl").getBytes(),"utf-8");
//		try {
//			publishUrl = new String(publishUrl.getBytes("ISO8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		request.getSession().invalidate();
        response.setContentType("application/msword;charset=UTF-8");
        DataOutputStream ds = new DataOutputStream(response.getOutputStream());
		
//		String fileInfo = FileUtil.stream2string(publishUrl);
		
		File file = new File(publishUrl);
        // 取得文件的FileInputStream
        FileInputStream fStream = new FileInputStream(file);
        // 设置每次写入1024bytes
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int length = -1;
        // 从文件读取数据至缓冲区
        while ((length = fStream.read(buffer)) != -1) {
            // 将资料写入DataOutputStream中
            ds.write(buffer, 0, length);
        }
        ds.flush();
        ds.close();
        fStream.close();
		
		return "success";
	}
	
}
