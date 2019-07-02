package controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import IService.ILoginService;


@Controller
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private ILoginService iLoginService;
	
	/**
	 * 	登录接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		return iLoginService.login(username,password);
	}
	
	/**
	 *	找回密码接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findPwd.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findPwd(HttpServletRequest request) {
		String username = request.getParameter("username");
		//身份证号
		String idNum = request.getParameter("idNum");
		
		return iLoginService.findPwd(username, idNum);
		
	}
	
	/**
	 *	找回密码接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updatePwd.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String updatePwd(HttpServletRequest request) {
		String username = request.getParameter("username");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		
		return iLoginService.updatePwd(username, oldPassword,newPassword);
		
	}
	
	/**
	 *	找回密码接口
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/register.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String register(HttpServletRequest request) throws UnsupportedEncodingException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//身份证号
		String idNumber = request.getParameter("idNumber");
		String roleId = request.getParameter("roleId");
		String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"utf-8");
		
		return iLoginService.register(username,name, password,idNumber,roleId);
		
	}
	
	
}
