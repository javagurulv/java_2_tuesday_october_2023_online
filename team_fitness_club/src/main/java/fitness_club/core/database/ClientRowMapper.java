package fitness_club.core.database;

import fitness_club.core.domain.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(rs.getLong("id"));
        client.setFirstName(rs.getString("first_name"));
        client.setLastName(rs.getString("last_name"));
        client.setPersonalCode(rs.getString("personal_code"));
        //client.setClientAgeGroup(ClientAgeGroups.valueOf(rs.getString("age_group")));
        //client.setWorkouts(Workouts.valueOf(rs.getString("workout")));
        //client.setFitnessCentre(FitnessCentre.valueOf(rs.getString("fitness_centre")));
        return client;
    }

}
