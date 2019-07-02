package serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IService.IDraftService;
import IService.IPublishedService;
import constant.GeneralConstant;
import constant.TeacherConstant;
import dao.HomeworkPublish;
import dao.HomeworkPublishExample;
import dao.HomeworkSubmit;
import dao.HomeworkSubmitExample;
import dao.UserStudent;
import dto.HomeworkPublishDTO;
import dto.NeedPublishedDTO;
import mapper.HomeworkPublishMapper;
import mapper.HomeworkSubmitMapper;
import mapper.UserStudentMapper;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import response.GeneralResponse;
import util.JsonDateValueProcessor;

@Service
public class PublishedServiceImpl implements IPublishedService {

	@Autowired
	private HomeworkPublishMapper homeworkPublishMapper;
	
	@Autowired
	private IDraftService draftService;
	
	@Autowired
	private HomeworkSubmitMapper homeworkSubmitMapper;
	
	@Autowired
	private UserStudentMapper userStudentMapper;
	
	public String queryPublished(Long teacherId) {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		
		//查询条件
		HomeworkPublishExample example = new HomeworkPublishExample();
		dao.HomeworkPublishExample.Criteria hCriteria = example.createCriteria();
		hCriteria.andTeacherIdEqualTo(teacherId);
		hCriteria.andStatusEqualTo(GeneralConstant.STATUS_PUBLISHED);
		List<HomeworkPublish> homeworks = homeworkPublishMapper.selectByExample(example);
		List<HomeworkPublishDTO> homeworkPublishList = new ArrayList<HomeworkPublishDTO>();
		if (homeworks.size()>0) { //有作业
			homeworkPublishList = draftService.tranferToDTO(homeworks);
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

	public String countSubmitNumByHId(Long h_id) {
		
		HomeworkSubmitExample hExample = new HomeworkSubmitExample();
		hExample.createCriteria().andHIdEqualTo(h_id);
		
		List<HomeworkSubmit> submitList = homeworkSubmitMapper.selectByExample(hExample);
		if (submitList.size()>0) {
			
			return String.valueOf(submitList.size());
		}
		
		
		return "0";
	}

	/**
	    *    获取已提交作业
	 * @param hId
	 * @return
	 */
	public String querySubmit(Long hId) {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		
		HomeworkSubmitExample hExample = new HomeworkSubmitExample();
		hExample.createCriteria().andHIdEqualTo(hId);
		
		List<HomeworkSubmit> submitList = homeworkSubmitMapper.selectByExample(hExample);
		map.put("submitList", submitList);
		response.setData(map);
		response.setCode(GeneralConstant.SUCCESS);			
		response.setMsg(TeacherConstant.SUCCESS);
		
		return JSONObject.fromObject(response,jsonConfig).toString();
	}

	/**
	 * 获取学生需要提交的作业
	 * @param studentId
	 * @return
	 */
	public String queryNeedSubmit(Long studentId) {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		UserStudent userStudent = userStudentMapper.selectByPrimaryKey(studentId);
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		
		Long classId = Long.valueOf(userStudent.getClassId());
		
		List<NeedPublishedDTO> needPublishedList = homeworkPublishMapper.selectPublishByClassId(classId,GeneralConstant.STATUS_PUBLISHED,studentId);
		List<NeedPublishedDTO> needPublishedsDtos = new ArrayList<NeedPublishedDTO>();
		for(int i=0;i<needPublishedList.size();i++) {
			NeedPublishedDTO needPublishedDTO = needPublishedList.get(i);
			Long hId = needPublishedDTO.getH_id();
			
			HomeworkSubmitExample example = new HomeworkSubmitExample();
			example.createCriteria().andHIdEqualTo(hId).andStudentIdEqualTo(studentId);
			
			if (homeworkSubmitMapper.selectByExample(example).size()==0) {
				needPublishedsDtos.add(needPublishedDTO);
			}
			
		}
		map.put("needPublishedList", needPublishedsDtos);
		response.setData(map);
		response.setCode(GeneralConstant.SUCCESS);			
		response.setMsg(TeacherConstant.SUCCESS);
		
		
		
		return JSONObject.fromObject(response,jsonConfig).toString();
	}

	public String homeworkSubmit(HomeworkSubmit homeworkSubmit) {
		homeworkSubmitMapper.insert(homeworkSubmit);
		return "200";
	}

	public String querySubmited(Long studentId) {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		UserStudent userStudent = userStudentMapper.selectByPrimaryKey(studentId);
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		
		Long classId = Long.valueOf(userStudent.getClassId());
		
		List<NeedPublishedDTO> needPublishedList = homeworkPublishMapper.selectPublishByClassId(classId,GeneralConstant.STATUS_PUBLISHED,studentId);
		List<NeedPublishedDTO> needPublishedsDtos = new ArrayList<NeedPublishedDTO>();
		for(int i=0;i<needPublishedList.size();i++) {
			NeedPublishedDTO needPublishedDTO = needPublishedList.get(i);
			Long hId = needPublishedDTO.getH_id();
			
			HomeworkSubmitExample example = new HomeworkSubmitExample();
			example.createCriteria().andHIdEqualTo(hId).andStudentIdEqualTo(studentId);
			List<HomeworkSubmit> homeworkSubmits = homeworkSubmitMapper.selectByExample(example);
			if (homeworkSubmits.size()>0) {
				HomeworkSubmit homeworkSubmit = homeworkSubmits.get(0);
				needPublishedDTO.setSubmitUrl(homeworkSubmit.gethSubmitUrl());
				needPublishedDTO.setRateLevel(homeworkSubmit.getRateLevel());
				needPublishedDTO.setRemark(homeworkSubmit.getRemark());
				needPublishedsDtos.add(needPublishedDTO);
			}
			
		}
		map.put("needPublishedList", needPublishedsDtos);
		response.setData(map);
		response.setCode(GeneralConstant.SUCCESS);			
		response.setMsg(TeacherConstant.SUCCESS);
		
		
		
		return JSONObject.fromObject(response,jsonConfig).toString();
	}

	public String rateSubmit(HomeworkSubmit homeworkSubmit) {
		homeworkSubmitMapper.updateByPrimaryKeySelective(homeworkSubmit);
		return "200";
	}

}
