package mapper;

import dao.TableClass;
import dao.TableClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableClassMapper {
    int countByExample(TableClassExample example);

    int deleteByExample(TableClassExample example);

    int deleteByPrimaryKey(Long classId);

    int insert(TableClass record);

    int insertSelective(TableClass record);

    List<TableClass> selectByExample(TableClassExample example);

    TableClass selectByPrimaryKey(Long classId);

    int updateByExampleSelective(@Param("record") TableClass record, @Param("example") TableClassExample example);

    int updateByExample(@Param("record") TableClass record, @Param("example") TableClassExample example);

    int updateByPrimaryKeySelective(TableClass record);

    int updateByPrimaryKey(TableClass record);
}