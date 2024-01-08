package avangardteen.java2app.data;

import avangardteen.java2app.Category;
import avangardteen.java2app.ComponentWheelchair;
import avangardteen.java2app.domen.Wheelchair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class JbdcDatabaseWheelchairImpl implements DatabaseWheelchair{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addWheelchairComponent(Map<Category, ComponentWheelchair> components) {
       String frontWheel =  components.get(Category.FRONT_WHEEL).getComponentID();
       String armrest =  components.get(Category.ARMREST).getComponentID();
       String brake =  components.get(Category.BRAKE).getComponentID();
       String backWheelSize =  components.get(Category.BACK_WHEEL_SIZE).getComponentID();
       String backWheels =  components.get(Category.BACK_WHEEL).getComponentID();

        jdbcTemplate.update( "INSERT INTO wheelchair (ID FRONT_WHEEL,ARMREST,BRAKE,BACK_WHEEL_SIZE,BACK_WHEEL)" +
                "values (?,?,?,?,?)", frontWheel,armrest,brake,backWheelSize,backWheels);

    }
    public void addWheelchairSizes (int seatDepth, int footrestLength, int seatWeight) {
        jdbcTemplate.update("INSERT INTO wheelchair (SeatDepth) " +
                "values (?)", seatDepth);
        jdbcTemplate.update("INSERT INTO wheelchair (SeatDepth) " +
                "values (?)", seatWeight);
        jdbcTemplate.update("INSERT INTO wheelchair (SeatDepth) " +
                "values (?)", footrestLength);

    }


    @Override
    public List<Wheelchair> getAllWheelchair() {
        return null;
    }

}