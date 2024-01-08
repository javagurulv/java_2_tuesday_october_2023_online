package avangardteen.java2app.data.RowMapper;

import avangardteen.java2app.domen.Client;
import avangardteen.java2app.domen.UserSizes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AntropologRowMapper implements RowMapper<UserSizes> {
        public UserSizes mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserSizes userSizes =  new UserSizes();
            userSizes.setBackHeight(rs.getInt("backHeight"));
            userSizes.setShinLength(rs.getInt("shinLength"));
            userSizes.setThighLength(rs.getInt("thighLength"));
            userSizes.setPelvisWidth(rs.getInt("pelvisWidth"));
            return userSizes;
        }

    }
