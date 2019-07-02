package mapper;

import dao.UserManager;
import dao.UserManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserManagerMapper {
    int countByExample(UserManagerExample example);

    int deleteByExample(UserManagerExample example);

    int deleteByPrimaryKey(String name);

    int insert(UserManager record);

    int insertSelective(UserManager record);

    List<UserManager> selectByExample(UserManagerExample example);

    UserManager selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") UserManager record, @Param("example") UserManagerExample example);

    int updateByExample(@Param("record") UserManager record, @Param("example") UserManagerExample example);

    int updateByPrimaryKeySelective(UserManager record);

    int updateByPrimaryKey(UserManager record);
}