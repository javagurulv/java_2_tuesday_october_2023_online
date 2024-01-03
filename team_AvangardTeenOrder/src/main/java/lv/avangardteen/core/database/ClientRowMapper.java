package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(rs.getLong("id"));
        client.setNameSurname(rs.getString("name_surname"));
        client.setPersonalCode(rs.getLong("personal_code"));
        client.setPhone(rs.getLong("phone"));
        client.setAddress(rs.getString("address"));
        return client;
    }
}
