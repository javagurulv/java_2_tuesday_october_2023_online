//package avangardteen.java2app.data;
//
//import avangardteen.java2app.domen.ComponentWheelchair;
//
//import avangardteen.java2app.data.RowMapper.ComponentRowMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
////@Component
//class JdbcDatabaseImpl implements DatabaseComponent {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<ComponentWheelchair> getAllComponents() {
//        String sql = "SELECT * FROM components";
//        return jdbcTemplate.query(sql, new ComponentRowMapper());
//    }
//
//    @Override
//    public List<ComponentWheelchair> allFrontWheels() {
//        String sql = "select * from components where category = \"FRONT_WHEEL\" " ;
//return  jdbcTemplate.query(sql, new ComponentRowMapper());
//    }
//
//    @Override
//    public List<ComponentWheelchair> allArmest() {
//        String sql = "select * from components where category = \"ARMREST\" " ;
//        return  jdbcTemplate.query(sql, new ComponentRowMapper());
//    }
//
//
//    @Override
//    public List<ComponentWheelchair> allBrakes() {
//        String sql = "select * from components where category = \"BRAKE\" " ;
//        return  jdbcTemplate.query(sql, new ComponentRowMapper());
//    }
//
//    @Override
//    public List<ComponentWheelchair> allBackWheelsFor20size() {
//            String sql = "select * from components " +
//                    "where id = \"MG 05\"";
//            return jdbcTemplate.query(sql, new ComponentRowMapper());
//        }
//
//    @Override
//    public List<ComponentWheelchair> allBackWheelsFor22size() {
//        String sql = "select * from components " +
//                "where id = \"MG 06\" or id = \"MG 15\" or id = \"MG 80\"";
//        return  jdbcTemplate.query(sql, new ComponentRowMapper());
//    }
//
//    @Override
//    public List<ComponentWheelchair> allBackWheelsFor24Size() {
//        String sql = "select * from components " +
//                "where category = \"BACK_WHEEL\" AND ID != \"MG 05\"";
//        return  jdbcTemplate.query(sql, new ComponentRowMapper());
//    }
//
//    @Override
//    public List<ComponentWheelchair> allBackWheels() {
//        String sql = "select * from components where category = \"BACK_WHEEL\" " ;
//        return  jdbcTemplate.query(sql, new ComponentRowMapper());
//    }
//
//    @Override
//    public List<ComponentWheelchair> allBackWheelsSize() {
//        String sql = "select * from components where category = \"BACK_WHEEL_SIZE\" " +
//                "ORDER BY information asc" ;
//        return  jdbcTemplate.query(sql, new ComponentRowMapper());
//    }
//}
