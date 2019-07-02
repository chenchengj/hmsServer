package serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import IService.ILoginService;
import constant.GeneralConstant;
import constant.LoginConstant;
import dao.User;
import dao.UserExample;
import dao.UserExample.Criteria;
import dao.UserManager;
import dao.UserStudent;
import dao.UserTeacher;
import mapper.UserManagerMapper;
import mapper.UserMapper;
import mapper.UserStudentMapper;
import mapper.UserTeacherMapper;
import net.sf.json.JSONObject;
import response.GeneralResponse;
@Service
public class LoginServiceImpl implements ILoginService{
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserManagerMapper userManagerMapper;
	
	@Resource
	private UserTeacherMapper userTeacherMapper;
	
	@Resource
	private UserStudentMapper userStudentMapper;
	
	/**
	 * 	登录
	 */
	public String login(String username,String password) {
		//通过username获取相应用户记录
		List<User> users= selectByUsername(username);
		
		//封装返回值
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		//若有该用户则比对密码是否一致
		if(users.size()>0) {
			User user = users.get(0);
			if (password.equals(user.getPassword())) { //密码正确
				map.put("roleid", user.getRoleId());
				response.setData(map);
				response.setMsg(LoginConstant.LOGIN_SUCCESS);
				response.setCode(GeneralConstant.SUCCESS);
				
				return JSONObject.fromObject(response).toString();
			} else { //密码错误
				response.setCode(GeneralConstant.PARAM_ERROR);
				response.setMsg(LoginConstant.PARAM_ERROR);
				
				return JSONObject.fromObject(response).toString();
			}
		} else{ //用户不存在
			response.setCode(GeneralConstant.PARAM_ERROR);
			response.setMsg(LoginConstant.USER_NOT_EXIST);
			
			return JSONObject.fromObject(response).toString();
		}
	}

	/**
	 * 	找回密码
	 */
	public String findPwd(String username,String idNum) {
		List<User> users= selectByUsername(username);
		if(users.size()>0) {
			User user = users.get(0);
			String roleid = user.getRoleId();
			String id_num = null;
			if("0".equals(roleid)) {
				UserManager userManager = userManagerMapper.selectByPrimaryKey(username);
				id_num = userManager.getIdNum();
				return checkIdNum(idNum, id_num, user);
			}
			
			if("1".equals(roleid)){
				UserTeacher userTeacher = userTeacherMapper.selectByPrimaryKey(Long.parseLong(username));
				id_num = userTeacher.getIdNum();
				
				return checkIdNum(idNum, id_num, user);
				
			}
			
			if("2".equals(roleid)) {
				UserStudent userStudent = userStudentMapper.selectByPrimaryKey(Long.parseLong(username));
				id_num = userStudent.getIdNumber();
				return checkIdNum(idNum, id_num, user);
			}
		}
		GeneralResponse response = new GeneralResponse();

		response.setCode(GeneralConstant.PARAM_ERROR);
		response.setMsg(LoginConstant.USER_NOT_EXIST);
			
		return JSONObject.fromObject(response).toString();
	}
	
	
	/**
	 * 根据用户名获取用户信息
	 * @param username
	 * @return
	 */
	private List<User> selectByUsername(String username){
		UserExample example = new UserExample();
		Criteria criteria= example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> users= userMapper.selectByExample(example);
		return users;
	}
	
	/**
	 * 	校验身份证号是否正确
	 * @param put
	 * @param idNum
	 * @param user
	 * @return
	 */
	private static String checkIdNum(String put,String idNum,User user) {
		Map<String,Object> map = new HashMap<String, Object>();
		GeneralResponse response = new GeneralResponse();
		if (put.equals(idNum)) {
			map.put("password", user.getPassword());
			response.setCode(GeneralConstant.SUCCESS);
			response.setMsg(LoginConstant.FINDPWD_SUCCESS);
			response.setData(map);
			
			return JSONObject.fromObject(response).toString();
		} else {
			response.setCode(GeneralConstant.PARAM_ERROR);
			response.setMsg(LoginConstant.IDNUM_ERROR);
				
			return JSONObject.fromObject(response).toString();
		}
	}

	public String updatePwd(String username, String oldPassword, String newPassword) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(oldPassword);
		List<User> users = userMapper.selectByExample(example);
		if (users.size()>0) {
			User user = users.get(0);
			user.setPassword(newPassword);
			UserExample userExample = new UserExample();
			userExample.createCriteria().andPasswordEqualTo(newPassword);
			userMapper.updateByExampleSelective(user, userExample);
			
			return "200";
		}
		
		return "203";
	}

	public String register(String username, String name, String password, String idNumber, String roleId) {
		User user = new User();
		user.setUserid(System.currentTimeMillis());
		user.setUsername(username);
		user.setPassword(password);
		
		if ("1".equals(roleId)) {
			user.setRoleId(roleId);
			
			UserTeacher userTeacher = new UserTeacher();
			userTeacher.setTeacherId(Long.valueOf(username));
			userTeacher.setTeacherName(name);
			userTeacher.setIdNum(idNumber);
			
			userTeacherMapper.insertSelective(userTeacher);
		} else if ("2".equals(roleId)) {
			user.setRoleId(roleId);
			UserStudent userStudent = new UserStudent();
			userStudent.setStudentId(Long.valueOf(username));
			userStudent.setStudentName(name);
			userStudent.setIdNumber(idNumber);
			
			userStudentMapper.insertSelective(userStudent);
		}
		userMapper.insertSelective(user);
		return "200";
	}

	
}
