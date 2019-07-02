package IService;

import dao.HomeworkSubmit;

public interface IPublishedService {

	/**
	 * 	查询已发布作业接口
	 * @param teacherId
	 * @return
	 */
	String queryPublished(Long teacherId);

	/**
	 * 统计作业提交人数
	 * @param h_id
	 * @return
	 */
	String countSubmitNumByHId(Long h_id);

	/**
	 * 获取已提交作业
	 * @param hId
	 * @return
	 */
	String querySubmit(Long hId);

	/**
	 * 获取学生需要提交的作业
	 * @param studentId
	 * @return
	 */
	String queryNeedSubmit(Long studentId);

	/**
	 * 学生提交作业
	 * @param homeworkSubmit
	 * @return
	 */
	String homeworkSubmit(HomeworkSubmit homeworkSubmit);

	/**
	 * 获取学生已提交的作业
	 * @param studentId
	 * @return
	 */
	String querySubmited(Long studentId);

	/**
	 * 教师评价作业
	 * @param studentId
	 * @return
	 */
	String rateSubmit(HomeworkSubmit homeworkSubmit);
}
