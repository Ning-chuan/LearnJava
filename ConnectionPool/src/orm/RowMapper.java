package orm;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 这个类是为了第二种方法
 */
public interface RowMapper {
    public Object mapperRow(ResultSet rs) throws SQLException;
}