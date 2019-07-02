package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import IService.IEndedService;

@Controller
@RequestMapping(value="/ended")
public class EndedController {
	
	@Autowired
	private IEndedService iEndedService;
	
	/**
	 * 	查询已结束作业接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryEnded.do",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryEnded(HttpServletRequest request) {
		//用户名即教工id
		Long teacherId = Long.parseLong(request.getParameter("username"));
		
		return iEndedService.queryEnded(teacherId);
	}

}
