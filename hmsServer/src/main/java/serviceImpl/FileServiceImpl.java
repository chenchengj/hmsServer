package serviceImpl;

import java.io.DataInputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import IService.IFileService;
import constant.TeacherConstant;
import dao.Attach;
import mapper.AttachMapper;
import util.FileUtil;

@Service
public class FileServiceImpl implements IFileService {
	
	@Resource
	private AttachMapper attachMapper;

	public String upload(DataInputStream dis, String fileName, String fileType) {
		//1代表发布的作业，2代表学生上传的作业
		String content = null;
		if ("1".equals(fileType)) {
			content = TeacherConstant.PUBLISHED_URL;
		} else {
			content = TeacherConstant.SUBMIT_URL;
		}
		
		String filePath = content+"/"+fileName;
		FileUtil.saveFile(dis,filePath);
		
		
		
		Attach attach = new Attach();
		attach.setAttachId(System.currentTimeMillis());
		attach.setAttachName(fileName);
		attach.setAttachUrl(filePath);
		attach.sethType(fileType);
		
		attachMapper.insert(attach);
		
		return filePath;
	}

}
