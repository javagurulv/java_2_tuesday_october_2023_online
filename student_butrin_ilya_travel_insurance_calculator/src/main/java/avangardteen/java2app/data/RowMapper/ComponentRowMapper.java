package avangardteen.java2app.data.RowMapper;

import avangardteen.java2app.Category;
import avangardteen.java2app.ComponentWheelchair;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComponentRowMapper implements RowMapper<ComponentWheelchair> {

        @Override
        public ComponentWheelchair mapRow(ResultSet rs, int rowNum) throws SQLException{
              ComponentWheelchair componentWheelchair =  new ComponentWheelchair();
              componentWheelchair.setCategory(Category.valueOf(rs.getString("category")));
              componentWheelchair.setComponentID(rs.getString("id"));
              componentWheelchair.setInformation(rs.getString("information"));
              componentWheelchair.setPrice(rs.getInt("price"));
                return componentWheelchair;
        }
}
