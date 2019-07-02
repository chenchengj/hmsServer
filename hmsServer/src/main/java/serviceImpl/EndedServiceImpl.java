package serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IService.IDraftService;
import IService.IEndedService;
import constant.GeneralConstant;
import constant.TeacherConstant;
import dao.HomeworkPublish;
import dao.HomeworkPublishExample;
import dto.HomeworkPublishDTO;
import mapper.HomeworkPublishMapper;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import response.GeneralResponse;
import util.JsonDateValueProcessor;

@Service
public class EndedServiceImpl implements IEndedService {

	@Autowired
	private HomeworkPublishMapper homeworkPublishMapper;
	
	@Autowired
	private IDraftService draftService;
	
	public String queryEnded(Long teacherId) {
		GeneralResponse response = new GeneralResponse();
		Map<String,Object> map = new HashMap<String, Object>();
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		
		//查询条件
		HomeworkPublishExample example = new HomeworkPublishExample();
		dao.HomeworkPublishExample.Criteria hCriteria = example.createCriteria();
		hCriteria.andTeacherIdEqualTo(teacherId);
		hCriteria.andStatusEqualTo(GeneralConstant.STATUS_ENDED);
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

}
