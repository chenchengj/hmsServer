package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import IService.IDraftService;
import dao.HomeworkPublish;

@Controller
@RequestMapping(value="/draft")
public class DraftController {
	
	@Autowired
	private IDraftService iDraftService;
	
	/**
	 * 	查询未发布作业接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryDraft.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryDraft(HttpServletRequest request) {
		//用户名即教工id
		Long teacherId = Long.parseLong(request.getParameter("username"));
		
		return iDraftService.queryDraft(teacherId);
	}
	
	/**
	 * 	保存/修改/发布作业
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/saveOrUpdateOrPublish.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String saveOrUpdateOrPublish(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String h_title = new String(request.getParameter("h_title").getBytes("ISO8859-1"),"utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String endTimeStr = request.getParameter("endTime");
		Date endTime = null;
		try {
			endTime = sdf.parse(endTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String courseId = request.getParameter("courseId");
		String classId = request.getParameter("classId");
		String operate = request.getParameter("operate");
		String teacherId = request.getParameter("teacherId");
		String fileName = new String(request.getParameter("fileName").getBytes("ISO8859-1"),"utf-8");
		String h_id = request.getParameter("h_id");
		String fileStr = request.getParameter("fileStr");
		HomeworkPublish homeworkPublish = new HomeworkPublish();
		if (StringUtils.isNotBlank(fileStr)) {
			String fileUrl = new String(fileStr.getBytes("ISO8859-1"),"utf-8");
			homeworkPublish.sethPulishUrl(fileUrl);
		}
		
		homeworkPublish.sethTitle(h_title);
		homeworkPublish.setEndDate(endTime);
		homeworkPublish.setCreateDate(new Date());
		homeworkPublish.setClassId(Long.parseLong(classId));
		homeworkPublish.setCourseId(courseId);
		homeworkPublish.setTeacherId(Long.parseLong(teacherId));
		
		return iDraftService.saveOrUpdateOrPublish(homeworkPublish,operate,h_id);
		
		
	}
	
	/**
	 *  获取课程接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryCourse.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryCourse(HttpServletRequest request) {
		Long teacherId = Long.parseLong(request.getParameter("teacherId"));
		
		return iDraftService.queryCourse(teacherId);
		
	}
	
	/**
	 * 获取班级接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryClass.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryClass(HttpServletRequest request) {
		String courseId = request.getParameter("courseId");
		
		return iDraftService.queryClass(courseId);
	}

}
