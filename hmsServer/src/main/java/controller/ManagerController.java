package controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import IService.IManagerService;
import dao.UserStudent;
import dao.UserTeacher;

@Controller
@RequestMapping(value="/manage")
public class ManagerController {

	@Autowired
	private IManagerService iManagerService;
	
	/**
	 * 	获取所有教师信息接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryTeacher.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryTeacher(HttpServletRequest request) {
		
		return iManagerService.queryAllTeacher();
	}
	
	/**
	 * 	获取所有学生信息接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryStudent.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryStudent(HttpServletRequest request) {
		
		return iManagerService.queryAllStudent();
	}
	
	/**
	 * 	初始化学院选项
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deptInitialize.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String deptInitialize(HttpServletRequest request) {
		
		return iManagerService.queryAddDept();
	}
	
	/**
	 * 	添加教师信息
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/addTeacher.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String addTeacher(HttpServletRequest request) throws UnsupportedEncodingException {
		
		Long teacherId = Long.valueOf(request.getParameter("id"));
		String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"utf-8");
		Long deptId = Long.valueOf(request.getParameter("deptId"));
		
		UserTeacher userTeacher = new UserTeacher();
		userTeacher.setTeacherId(teacherId);
		userTeacher.setTeacherName(name);
		userTeacher.setDeptId(deptId);
		
		return iManagerService.addTeacher(userTeacher);
	}
	
	/**
	 * 	添加教师信息
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/addStudent.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String addStudent(HttpServletRequest request) throws UnsupportedEncodingException {
		
		Long studentId = Long.valueOf(request.getParameter("id"));
		String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"utf-8");
		String classId = request.getParameter("classId");
		
		UserStudent userStudent = new UserStudent();
		userStudent.setStudentId(studentId);
		userStudent.setStudentName(name);
		userStudent.setClassId(classId);
		
		return iManagerService.addStudent(userStudent);
	}
	
	/**
	 * 	初始化学院选项
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/classInitialize.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String classInitialize(HttpServletRequest request) {
		
		return iManagerService.queryAddClass();
	}
}
