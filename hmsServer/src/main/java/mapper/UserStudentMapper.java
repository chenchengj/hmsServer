package mapper;

import dao.UserStudent;
import dao.UserStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserStudentMapper {
    int countByExample(UserStudentExample example);

    int deleteByExample(UserStudentExample example);

    int deleteByPrimaryKey(Long studentId);

    int insert(UserStudent record);

    int insertSelective(UserStudent record);

    List<UserStudent> selectByExample(UserStudentExample example);

    UserStudent selectByPrimaryKey(Long studentId);

    int updateByExampleSelective(@Param("record") UserStudent record, @Param("example") UserStudentExample example);

    int updateByExample(@Param("record") UserStudent record, @Param("example") UserStudentExample example);

    int updateByPrimaryKeySelective(UserStudent record);

    int updateByPrimaryKey(UserStudent record);
}