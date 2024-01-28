//package avangardteen.java2app.data;
//
//import avangardteen.java2app.domen.Client;
//import avangardteen.java2app.data.RowMapper.ClientRowMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
////@Component
//public class JbdcDatabaseClientImpl implements DatabaseClient {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    @Override
//    public void addClient(Client client) {
//        jdbcTemplate.update( "INSERT INTO client (first_name, last_name, phone, e_mail)" +
//                "values (?,?,?,?,?)",  client.getFirstName(), client.getLastName(), client.getPhoneNumber(), client.getE_mail());
//    }
//
//    @Override
//    public void deleteClient(int id) {
//        jdbcTemplate.update("delete from client " +
//                "where id = ?" + id);
//    }
//
//    @Override
//    public List<Client> findClientBySecondName(String secondName) {
//        String sql = "select * from client" +
//                "where second_name = ?";
//        Object[] args = new Object[] {secondName};
//        return jdbcTemplate.query(sql, args, new ClientRowMapper());
//    }
//
//    @Override
//    public List<Client> getAllClients() {
//        String sql = "select * from client";
//        return  jdbcTemplate.query(sql, new ClientRowMapper());
//    }
//}
