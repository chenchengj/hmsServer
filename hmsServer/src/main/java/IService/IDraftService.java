package IService;

import java.util.List;

import dao.HomeworkPublish;
import dto.HomeworkPublishDTO;

public interface IDraftService {
	/**
	 * 	查询未发布作业接口
	 * @param teacherId
	 * @return
	 */
	String queryDraft(Long teacherId);
	
	/**
	 * 保存/修改/发布作业
	 * @param homeworkPublish
	 * @param operate
	 * @param h_id
	 * @return
	 */
	String saveOrUpdateOrPublish(HomeworkPublish homeworkPublish, String operate, String h_id);

	/**
	 * 获取课程
	 * @param teacherId
	 * @return
	 */
	String queryCourse(Long teacherId);

	/**
	 * 获取班级
	 * @param courseId
	 * @return
	 */
	String queryClass(String courseId);
	
	/**
	 * 包装返回
	 * @param homeworks
	 * @return
	 */
	List<HomeworkPublishDTO> tranferToDTO(List<HomeworkPublish> homeworks);
}
