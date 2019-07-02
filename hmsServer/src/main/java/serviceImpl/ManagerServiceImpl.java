package serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IService.IManagerService;
import constant.GeneralConstant;
import constant.TeacherConstant;
import dao.Dept;
import dao.DeptExample;
import dao.TableClass;
import dao.TableClassExample;
import dao.UserStudent;
import dao.UserStudentExample;
import dao.UserTeacher;
import dao.UserTeacherExample;
import dto.UserStudentDTO;
import mapper.DeptMapper;
import mapper.TableClassMapper;
import mapper.UserStudentMapper;
import mapper.UserTeacherMapper;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import response.GeneralResponse;
import util.JsonDateValueProcessor;
@Service
public class ManagerServiceImpl implements IManagerService{

	@Autowired
	private UserTeacherMapper userTeacherMapper;
	
	@Autowired
	private UserStudentMapper userStudentMapper;
	
	@Autowired
	private TableClassMapper tableClassMapper;
	
	@Autowired
	private DeptMapper deptMapper;
	
	public String queryAllTeacher() {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		List<UserTeacher> userTeachers = userTeacherMapper.selectByExample(new UserTeacherExample());
		map.put("userTeachers", userTeachers);
		response.setData(map);
		response.setCode(GeneralConstant.SUCCESS);			
		response.setMsg(TeacherConstant.SUCCESS);
		return JSONObject.fromObject(response).toString();
	}

	public String queryAllStudent() {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		List<UserStudent> userStudents = userStudentMapper.selectByExample(new UserStudentExample());
		List<UserStudentDTO> userStudentDTOs = new ArrayList<UserStudentDTO>();
		for (UserStudent userStudent:userStudents) {
			UserStudentDTO userStudentDTO = new UserStudentDTO();
			userStudentDTO.setStudentId(userStudent.getStudentId());
			userStudentDTO.setName(userStudent.getStudentName());
			userStudentDTO.setClassId(userStudent.getClassId());
			
			userStudentDTOs.add(userStudentDTO);
		}
		map.put("userStudents", userStudentDTOs);
		response.setData(map);
		response.setCode(GeneralConstant.SUCCESS);			
		response.setMsg(TeacherConstant.SUCCESS);
		return JSONObject.fromObject(response,jsonConfig).toString();
	}

	public String queryAddDept() {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Dept> depts = deptMapper.selectByExample(new DeptExample());
		map.put("depts", depts);
		response.setData(map);
		response.setCode(GeneralConstant.SUCCESS);			
		response.setMsg(TeacherConstant.SUCCESS);
		return JSONObject.fromObject(response).toString();
	}

	public String addTeacher(UserTeacher userTeacher) {
		userTeacherMapper.insert(userTeacher);
		return "200";
	}

	public String queryAddClass() {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		List<TableClass> tableClasses = tableClassMapper.selectByExample(new TableClassExample());
		map.put("tableClasses", tableClasses);
		response.setData(map);
		response.setCode(GeneralConstant.SUCCESS);			
		response.setMsg(TeacherConstant.SUCCESS);
		return JSONObject.fromObject(response).toString();
	}

	public String addStudent(UserStudent userStudent) {
		userStudentMapper.insert(userStudent);
		return "200";
	}

}
