package fitness_club.core.database;

import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.domain.Workouts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
abstract class JdbcDatabaseImpl implements Database {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Client client) {
        jdbcTemplate.update(
                "INSERT INTO clients (first_name, last_name, personal_code) "
                        + "VALUES (?, ?, ?)",
                client.getFirstName(), client.getLastName(), client.getPersonalCode()
        );
//        jdbcTemplate.update(
//                "INSERT INTO age_groups (age_group) "
//                        + "VALUES (?)",
//                client.getClientAgeGroup().toString()
//        );
//        jdbcTemplate.update(
//                "INSERT INTO workouts (workout) "
//                        + "VALUES (?)",
//                client.getWorkouts().toString()
//        );
//        jdbcTemplate.update(
//                "INSERT INTO fitness_centres (fitness_centre) "
//                        + "VALUES (?)",
//                client.getFitnessCentre().toString()
//        );
    }

    @Override
    public boolean deleteByPersonalCode(String personalCode) {
        String sql = "DELETE FROM clients WHERE personal_code = ?";
        Object[] args = new Object[]{personalCode};
        return jdbcTemplate.update(sql, args) == 1;
    }

    public List<Client> getAllClients() {
        String sql = "SELECT * FROM clients";
        return jdbcTemplate.query(sql, new ClientRowMapper());
    }

    /*@Override
    public boolean clientAgeGroupChangedByPersonalCode(String personalCode, ClientAgeGroups newAgeGroup) {
        Optional<Client> clientToChangeAgeGroupOpt = clients.stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst();
        if (clientToChangeAgeGroupOpt.isPresent()) {
            Client clientToChangeAgeGroup = clientToChangeAgeGroupOpt.get();
            clientToChangeAgeGroup.setClientAgeGroup(newAgeGroup);
            updateClientIds(clients);
            saveClient(clients);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean clientWorkoutsChangedByPersonalCode(String personalCode, Workouts newWorkout) {
        Optional<Client> clientToChangeWorkoutOpt = clients.stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst();
        if (clientToChangeWorkoutOpt.isPresent()) {
            Client clientToChangeWorkout = clientToChangeWorkoutOpt.get();
            clientToChangeWorkout.setWorkouts(newWorkout);
            updateClientIds(clients);
            saveClient(clients);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isClientFitnessCentreChangedByPersonalCode(String personalCode, FitnessCentre newFitnessCentre) {
        Optional<Client> clientToChangeFitnessCentreOpt = clients.stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst();
        if (clientToChangeFitnessCentreOpt.isPresent()) {
            Client clientToChangeFitnessCentre = clientToChangeFitnessCentreOpt.get();
            clientToChangeFitnessCentre.setFitnessCentre(newFitnessCentre);
            updateClientIds(clients);
            saveClient(clients);
            return true;
        } else {
            return false;
        }
    }

    public void saveClient(List<Client> clients) {
    }

     */

    @Override
    public List<Client> findByFirstName(String firstName) {
        String sql = "SELECT * FROM clients WHERE first_name = ?";
        Object[] args = new Object[]{firstName};
        return jdbcTemplate.query(sql, args, new ClientRowMapper());
    }

    @Override
    public List<Client> findByLastName(String lastName) {
        String sql = "SELECT * FROM clients WHERE last_name = ?";
        Object[] args = new Object[]{lastName};
        return jdbcTemplate.query(sql, args, new ClientRowMapper());
    }

    @Override
    public List<Client> findByFirstNameAndLastName(String firstName, String lastName) {
        String sql = "SELECT * FROM clients WHERE first_name = ? AND last_name = ?";
        Object[] args = new Object[]{firstName, lastName};
        return jdbcTemplate.query(sql, args, new ClientRowMapper());
    }

    @Override
    public List<Client> findByPersonalCode(String personalCode) {
        String sql = "SELECT * FROM clients WHERE personal_code = ?";
        Object[] args = new Object[]{personalCode};
        return jdbcTemplate.query(sql, args, new ClientRowMapper());
    }

  /*  private void updateClientIds(List<Client> clients) {
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).setId((long) (i + 1));
        }
    }

   */


}
