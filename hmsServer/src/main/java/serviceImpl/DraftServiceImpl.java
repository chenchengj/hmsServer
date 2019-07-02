package serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import IService.IDraftService;
import constant.GeneralConstant;
import constant.TeacherConstant;
import dao.Attach;
import dao.AttachExample;
import dao.ClassCourse;
import dao.ClassCourseExample;
import dao.Course;
import dao.CourseExample;
import dao.HomeworkPublish;
import dao.HomeworkPublishExample;
import dao.TableClass;
import dto.HomeworkPublishDTO;
import mapper.AttachMapper;
import mapper.ClassCourseMapper;
import mapper.CourseMapper;
import mapper.HomeworkPublishMapper;
import mapper.TableClassMapper;
import mapper.UserTeacherMapper;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import response.GeneralResponse;
import util.JsonDateValueProcessor;

@Service
public class DraftServiceImpl implements IDraftService{

	@Resource
	private UserTeacherMapper userTeacherMapper;
	
	@Resource
	private CourseMapper courseMapper;
	
	@Resource
	private TableClassMapper classMapper;
	
	@Resource
	private ClassCourseMapper classCourseMapper;
	
	@Resource
	private HomeworkPublishMapper homeworkPublishMapper;
	
	@Resource
	private AttachMapper attachMapper;

	/**
	 *	 查询未发布作业
	 */
	public String queryDraft(Long teacherId) {
		
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		
		//查询条件
		HomeworkPublishExample example = new HomeworkPublishExample();
		dao.HomeworkPublishExample.Criteria hCriteria = example.createCriteria();
		hCriteria.andTeacherIdEqualTo(teacherId);
		hCriteria.andStatusEqualTo(GeneralConstant.STATUS_DRAFT);
		List<HomeworkPublish> homeworks = homeworkPublishMapper.selectByExample(example);
		List<HomeworkPublishDTO> homeworkPublishList = new ArrayList<HomeworkPublishDTO>();
		if (homeworks.size()>0) { //有作业
			
			homeworkPublishList = tranferToDTO(homeworks);
			map.put("homeworks", homeworkPublishList);
			response.setData(map);
			response.setCode(GeneralConstant.SUCCESS);			
			response.setMsg(TeacherConstant.SUCCESS);
			
			return JSONObject.fromObject(response,jsonConfig).toString();		
		}
		//无作业
		response.setCode(GeneralConstant.PARAM_ERROR);
		response.setMsg(TeacherConstant.HOMEWORK_NULL);
		
		return JSONObject.fromObject(response).toString();
		
		
		
	}

	/**
	 * 	保存/修改/发布作业
	 */
	public String saveOrUpdateOrPublish(HomeworkPublish homeworkPublish, String operate,String h_id) {
		
		GeneralResponse response = new GeneralResponse();
		
		if ("save".equals(operate)) {
			homeworkPublish.setStatus(GeneralConstant.STATUS_DRAFT);
		} else if ("publish".equals(operate)) {
			homeworkPublish.setStatus(GeneralConstant.STATUS_PUBLISHED);
		}
		int count = -1;
		Long hId = 0L;
		if (!StringUtils.isBlank(h_id)) {
			hId = Long.parseLong(h_id);
			HomeworkPublishExample example = new HomeworkPublishExample();
			example.createCriteria().andHIdEqualTo(hId);
			
			count = homeworkPublishMapper.updateByExampleSelective(homeworkPublish, example);
		} else {
			HomeworkPublishExample titleExample = new HomeworkPublishExample();
			titleExample.createCriteria().andHTitleEqualTo(homeworkPublish.gethTitle());
			List<HomeworkPublish> homeworkPublishs = homeworkPublishMapper.selectByExample(titleExample);
			if (homeworkPublishs.size()>0) {
				response.setCode(GeneralConstant.PARAM_ERROR);
				response.setMsg(TeacherConstant.HOMEWORK_EXIST);
				
				return JSONObject.fromObject(response).toString();
			}
			hId = System.currentTimeMillis();
			homeworkPublish.sethId(hId);
			count = homeworkPublishMapper.insert(homeworkPublish);
		}
		
		String publishUrl = homeworkPublish.gethPulishUrl();
		
		if (StringUtils.isNotBlank(publishUrl)) {
			AttachExample attachExample = new AttachExample();
			attachExample.createCriteria().andAttachUrlEqualTo(homeworkPublish.gethPulishUrl());
			List<Attach> attachs = attachMapper.selectByExample(attachExample);
			Attach attach = attachs.get(0);
			attach.sethId(homeworkPublish.gethId());
			
			attach.setAttachUrl(homeworkPublish.gethPulishUrl());
			
			attachMapper.updateByPrimaryKeySelective(attach);
		}
		
		
		if (count > 0) {
			response.setCode(GeneralConstant.SUCCESS);
			response.setMsg(TeacherConstant.SUCCESS);
		}
		
		return JSONObject.fromObject(response).toString();
		
	}

	/**
	 * 获取课程
	 */
	public String queryCourse(Long teacherId) {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		
		CourseExample example = new CourseExample();
		example.createCriteria().andTeacherIdEqualTo(teacherId);
		List<Course> courses = courseMapper.selectByExample(example);
		if (courses.size()>0) {
			map.put("course", courses);
			response.setCode(GeneralConstant.SUCCESS);
			response.setMsg(TeacherConstant.SUCCESS);
			response.setData(map);
			
			return JSONObject.fromObject(response).toString();
		}
		
		response.setCode(GeneralConstant.PARAM_ERROR);
		response.setMsg(TeacherConstant.COURSE_NULL);
		
		return JSONObject.fromObject(response).toString();

	}

	/**
	 * 	根据课程id获取班级
	 */
	public String queryClass(String courseId) {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		
		ClassCourseExample example = new ClassCourseExample();
		example.createCriteria().andCourseIdEqualTo(courseId);
		
		List<ClassCourse> classCourses = classCourseMapper.selectByExample(example);
		if (classCourses.size()>0) {
			List<String> classNameList = new ArrayList<String>();
			for(ClassCourse classCourse : classCourses) {
				Long classId = classCourse.getClassId();
				TableClass tableClass = classMapper.selectByPrimaryKey(classId); 
				String className = classId+" "+tableClass.getClassName();
				classNameList.add(className);
			}
			map.put("classNameList", classNameList);
			response.setCode(GeneralConstant.SUCCESS);
			response.setMsg(TeacherConstant.SUCCESS);
			response.setData(map);
			
			return JSONObject.fromObject(response).toString();
			
		}
		response.setCode(GeneralConstant.PARAM_ERROR);
		response.setMsg(TeacherConstant.COURSE_NULL);
		
		return JSONObject.fromObject(response).toString();
	}

	public List<HomeworkPublishDTO> tranferToDTO(List<HomeworkPublish> homeworks) {
		List<HomeworkPublishDTO> homeworkPublishList = new ArrayList<HomeworkPublishDTO>();
		for (int i = 0; i < homeworks.size(); i++) {
			HomeworkPublish homeworkPublish = homeworks.get(i);
			
			HomeworkPublishDTO homeworkPublishDTO = new HomeworkPublishDTO();
			
			homeworkPublishDTO.sethId(homeworkPublish.gethId());
			homeworkPublishDTO.sethTitle(homeworkPublish.gethTitle());
			homeworkPublishDTO.setTeacherId(homeworkPublish.getTeacherId());
			
			Course course = courseMapper.selectByPrimaryKey(homeworkPublish.getCourseId());
			homeworkPublishDTO.setCourseSpinner(course.getCourseId()+" "+course.getCourseName());
			
			TableClass tableClass = classMapper.selectByPrimaryKey(homeworkPublish.getClassId());
			homeworkPublishDTO.setClassSpinner(tableClass.getClassId()+" "+tableClass.getClassName());
			homeworkPublishDTO.setEndDate(homeworkPublish.getEndDate());
			homeworkPublishDTO.sethPulishUrl(homeworkPublish.gethPulishUrl());
			
			homeworkPublishList.add(homeworkPublishDTO);
		}
		
		return homeworkPublishList;
		
	}
}
