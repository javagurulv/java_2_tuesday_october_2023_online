package avangardteen.java2app.data;

import avangardteen.java2app.domen.Client;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrmDatabaseClient implements DatabaseClient {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addClient(Client client) {
        sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public void deleteClient(int id) {

        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Client where id = :id");
        query.setParameter("id", id);
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> query = sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Client b", Client.class)
                .getResultList();
        return query;
    }

    @Override
    public List<Client> findClientBySecondName(String secondName) {

        Query query = sessionFactory.getCurrentSession().createQuery("SELECT b FROM CLIENT b where last_name = :lastName");
        query.setParameter("last_name", secondName);
        List<Client> clients = query.getResultList();
        return  clients;
    }
}

