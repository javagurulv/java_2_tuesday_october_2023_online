package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class OrmClientRepository implements Database {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Client> getClients() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Client c", Client.class)
                .getResultList();
    }

    @Override
    public void addUser(Client client) {
        sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public void updateUser(Long id, Client client) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Client c where id = :id");
        query.setParameter("id", id);
        query.setParameter("name_surname", client.getNameSurname());
        query.setParameter("personal_code", client.getPersonalCode());
        query.setParameter("phone", client.getPhone());
        query.setParameter("address", client.getAddress());
    }

    @Override
    public boolean deleteClientByOrderId(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Client where order_id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public Client getClientByOrderId(Long idOrder) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select c FROM Client c where order_id = :idOrder", Client.class);
        query.setParameter("idOrder", idOrder);
        Client client = (Client) query.getSingleResult();
        return client;
    }

    @Override
    public Client findBySurnameAndPersonalCode(String surname, Long personalCode) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select c FROM Client c where name_surname = :surname AND personal_code = :personalCode");
        query.setParameter("name_surname", surname);
        query.setParameter("personal_code", personalCode);
        return (Client) query.getSingleResult();
    }

    @Override
    public void setOrderId(Long orderId) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("INSERT INTO Clients c order_id = :id");
        query.setParameter("order_id", orderId);
    }

    @Override
    public Query getIdClient() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT LAST_INSERT_ID()");

    }
}
