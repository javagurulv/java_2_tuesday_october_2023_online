package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;


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
        if(findBySurnameAndPersonalCode(client.getNameSurname(), client.getPersonalCode()) == null) {
            sessionFactory.getCurrentSession().save(client);
        }

    }

    @Override
    public Client getClientById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select c FROM Client c where id = :id", Client.class);
        query.setParameter("id", id);
        try {
            query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return (Client) query.getSingleResult();
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
    public Client findBySurnameAndPersonalCode(String surname, Long personalCode) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "FROM Client c WHERE nameSurname = :nameSurname AND personalCode = :personalCode");
        query.setParameter("nameSurname", surname);
        query.setParameter("personalCode", personalCode);
        try {
           query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return (Client) query.getSingleResult();
    }

    @Override
    public Optional<Client> findClientById(Long id) {
       Client client = sessionFactory.getCurrentSession().get(Client.class, id);
        if (client == null) {
            return Optional.empty();
        } else {
            return Optional.of(client);
        }
    }

}
