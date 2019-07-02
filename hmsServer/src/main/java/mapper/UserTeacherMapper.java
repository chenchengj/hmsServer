package mapper;

import dao.UserTeacher;
import dao.UserTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTeacherMapper {
    int countByExample(UserTeacherExample example);

    int deleteByExample(UserTeacherExample example);

    int deleteByPrimaryKey(Long teacherId);

    int insert(UserTeacher record);

    int insertSelective(UserTeacher record);

    List<UserTeacher> selectByExample(UserTeacherExample example);

    UserTeacher selectByPrimaryKey(Long teacherId);

    int updateByExampleSelective(@Param("record") UserTeacher record, @Param("example") UserTeacherExample example);

    int updateByExample(@Param("record") UserTeacher record, @Param("example") UserTeacherExample example);

    int updateByPrimaryKeySelective(UserTeacher record);

    int updateByPrimaryKey(UserTeacher record);
}