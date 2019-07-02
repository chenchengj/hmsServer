package controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import IService.IPublishedService;
import dao.HomeworkSubmit;

@Controller
@RequestMapping(value="/published")
public class PublishedController {
	
	@Autowired
	private IPublishedService iPublishedService;

	/**
	 * 	查询已发布作业接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryPublished.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryPublished(HttpServletRequest request) {
		//用户名即教工id
		Long teacherId = Long.parseLong(request.getParameter("username"));
		
		return iPublishedService.queryPublished(teacherId);
	}
	
	/**
	 * 统计作业提交人数
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/countSubmitNum.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String countSubmitNum(HttpServletRequest request) {
		String h_id = request.getParameter("hId");
		
		Long hId = Long.valueOf(h_id);
		
		return iPublishedService.countSubmitNumByHId(hId);
	}
	
	/**
	 * 获取已提交作业
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/querySubmit.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String querySubmit(HttpServletRequest request) {
		
		String hId = request.getParameter("hId");
		
		return iPublishedService.querySubmit(Long.valueOf(hId));
	}
	
	/**
	 * 获取学生需要提交的作业
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryNeedSubmit.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryNeedSubmit(HttpServletRequest request) {
		
		String studentId = request.getParameter("username");
		
		return iPublishedService.queryNeedSubmit(Long.valueOf(studentId));
	}
	
	/**
	 * 获取学生已提交的作业
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/querySubmited.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String querySubmited(HttpServletRequest request) {
		
		String studentId = request.getParameter("username");
		
		return iPublishedService.querySubmited(Long.valueOf(studentId));
	}
	
	/**
	 * 学生提交作业
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/homeworkSubmit.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String homeworkSubmit(HttpServletRequest request) {
		
		String studentId = request.getParameter("studentId");
		String submitUrl = null;
		try {
			submitUrl = new String(request.getParameter("submitUrl").getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String h_id = request.getParameter("h_id");
		
		HomeworkSubmit homeworkSubmit = new HomeworkSubmit();
		homeworkSubmit.sethSubmitId(System.currentTimeMillis());
		homeworkSubmit.setCreateDate(new Date());
		homeworkSubmit.sethId(Long.valueOf(h_id));
		homeworkSubmit.sethSubmitUrl(submitUrl);
		homeworkSubmit.setStudentId(Long.valueOf(studentId));
		
		
		return iPublishedService.homeworkSubmit(homeworkSubmit);
	}
	
	/**
	 * 教师评价作业
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/rateSubmit.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String rateSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
		String submitId = request.getParameter("submitId");
		String rateLevel = new String(request.getParameter("rateLevel").getBytes("ISO8859-1"),"utf-8");
		String remark = new String(request.getParameter("remark").getBytes("ISO8859-1"),"utf-8");
		
		HomeworkSubmit homeworkSubmit = new HomeworkSubmit();
		homeworkSubmit.sethSubmitId(Long.valueOf(submitId));
		homeworkSubmit.setRateLevel(rateLevel);
		homeworkSubmit.setRemark(remark);
		
		return iPublishedService.rateSubmit(homeworkSubmit);
	}
}
