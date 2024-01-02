package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.UserSizes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserSizeRowMapper implements RowMapper<UserSizes> {
    @Override
    public UserSizes mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserSizes userSizes = new UserSizes();
        userSizes.setId(rs.getLong("id"));
        userSizes.setPelvisWidth(rs.getInt("pelvisWidth"));
        userSizes.setThighLength(rs.getInt("thighLength"));
        userSizes.setBackHeight(rs.getInt("backHeight"));
        userSizes.setShinLength(rs.getInt("shinLength"));
        return userSizes;
    }
}
