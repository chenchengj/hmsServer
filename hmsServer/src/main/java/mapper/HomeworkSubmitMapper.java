package mapper;

import dao.HomeworkSubmit;
import dao.HomeworkSubmitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeworkSubmitMapper {
    int countByExample(HomeworkSubmitExample example);

    int deleteByExample(HomeworkSubmitExample example);

    int deleteByPrimaryKey(Long hSubmitId);

    int insert(HomeworkSubmit record);

    int insertSelective(HomeworkSubmit record);

    List<HomeworkSubmit> selectByExample(HomeworkSubmitExample example);

    HomeworkSubmit selectByPrimaryKey(Long hSubmitId);

    int updateByExampleSelective(@Param("record") HomeworkSubmit record, @Param("example") HomeworkSubmitExample example);

    int updateByExample(@Param("record") HomeworkSubmit record, @Param("example") HomeworkSubmitExample example);

    int updateByPrimaryKeySelective(HomeworkSubmit record);

    int updateByPrimaryKey(HomeworkSubmit record);
}