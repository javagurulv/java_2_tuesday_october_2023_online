package avangardteen.java2app.data.RowMapper;

import avangardteen.java2app.domen.Client;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client =  new Client();
        client.setFirstName(rs.getString("first_name"));
        client.setLastName(rs.getString("last_name"));
        client.setPhoneNumber(rs.getString("phone"));
        client.setUserEmail(rs.getString("e_mail"));
        client.getWheelchair().setId(rs.getInt("wheelchair"));
        client.getUserSizes().setId(rs.getInt("antropometricSizes"));
        return client;
    }

}
