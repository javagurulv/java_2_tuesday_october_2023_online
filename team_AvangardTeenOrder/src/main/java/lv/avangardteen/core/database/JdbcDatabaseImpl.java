package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.service.WheelchairComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcDatabaseImpl implements Database{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Client> getClients() {
        String sql = "SELECT * FROM clients";
        return jdbcTemplate.query(sql, new ClientRowMapper());
    }

    @Override
    public List<Wheelchair> getUserWheelchair() {
        return null;
    }

    @Override
    public List<UserSizes> getUserSizesOrders() {
        return null;
    }

    @Override
    public List<WheelchairComponent> getUserChooseComponents() {
        return null;
    }

    @Override
    public void addUser(Client client) {
        jdbcTemplate.update(
                    "INSERT INTO clients (name_surname, personal_code, phone, address) "
                            + "VALUES (?, ?, ?, ?)",
                    client.getNameSurname(), client.getPersonalCode(),
                client.getPhone(), client.getAddress()
            );


    }

    @Override
    public void addUserSize(UserSizes userSizes) {
        jdbcTemplate.update(
                "INSERT INTO client_size (pelvisWidth, thighLength, backHeight, shinLength) "
                        + "VALUES (?, ?, ?, ?, ?)",
                userSizes.getId(),
                userSizes.getPelvisWidth(),
                userSizes.getThighLength(),
                userSizes.getBackHeight(),
                userSizes.getShinLength()
                );
    }

    @Override
    public void addWheelchair(Wheelchair wheelchair) {

    }

    @Override
    public void addWheelchairComponents(WheelchairComponent wheelchairComponent) {

    }

    @Override
    public void updateUser(Long id, Client client) {

    }

    @Override
    public void updateUserSize(Long id, UserSizes userSizes) {

    }

    @Override
    public void updateWheelchair(Long id, Wheelchair wheelchair) {

    }

    @Override
    public void updateWheelchairComponents(Long id, WheelchairComponent wheelchairComponent) {

    }

    @Override
    public boolean deleteClientById(Long id) {
        String sql = "DELETE FROM clients WHERE id = ?";
        Object[] args = new Object[] {id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public Client getClient(Long id) {
        Client client = null;
        try {
            client = jdbcTemplate.queryForObject("SELECT * FROM clients WHERE id = ?", new ClientRowMapper());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Couldn't find entity of type Client with id =" + id);
        }

        return client;
    }

    @Override
    public UserSizes getUserSize(Long id) {
        UserSizes userSizes = null;
        try {
            userSizes = jdbcTemplate.queryForObject("SELECT * FROM client_size WHERE id = ?", new UserSizeRowMapper());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Couldn't find entity of type userSize with id =" + id);
        }

        return userSizes;
    }

    @Override
    public Wheelchair getWheelchair(Long id) {
        return null;
    }

    @Override
    public WheelchairComponent getWheelchairComponents(Long id) {
        return null;
    }

    @Override
    public Client findBySurnameAndPersonalCode(String surname, Long personalCode) {
        Client client = null;
        try {
            client = jdbcTemplate.queryForObject("SELECT * FROM clients WHERE name_surname = ? AND personal_code = ?", new ClientRowMapper());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Couldn't find entity of type Client with name_surname = " + surname + " and personal code = " + personalCode);
        }

        return client;
    }


}
