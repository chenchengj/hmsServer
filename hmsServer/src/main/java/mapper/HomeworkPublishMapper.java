package mapper;

import dao.HomeworkPublish;
import dao.HomeworkPublishExample;
import dto.NeedPublishedDTO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeworkPublishMapper {
    int countByExample(HomeworkPublishExample example);

    int deleteByExample(HomeworkPublishExample example);

    int deleteByPrimaryKey(Long hId);

    int insert(HomeworkPublish record);

    int insertSelective(HomeworkPublish record);

    List<HomeworkPublish> selectByExample(HomeworkPublishExample example);

    HomeworkPublish selectByPrimaryKey(Long hId);

    int updateByExampleSelective(@Param("record") HomeworkPublish record, @Param("example") HomeworkPublishExample example);

    int updateByExample(@Param("record") HomeworkPublish record, @Param("example") HomeworkPublishExample example);

    int updateByPrimaryKeySelective(HomeworkPublish record);

    int updateByPrimaryKey(HomeworkPublish record);

	List<NeedPublishedDTO> selectPublishByClassId(@Param("classId")Long classId,@Param("status") String statusPublished,@Param("studentId") Long studentId);
}