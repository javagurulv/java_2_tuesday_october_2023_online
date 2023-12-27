package fitness_club.core.database;

import fitness_club.core.domain.Client;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrmClientRepositoryImpl implements ClientRepository {

    @Autowired private SessionFactory sessionFactory;

    @Override
    public void save(Client client) {
        sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public boolean deleteByPersonalCode(String personalCode) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Client where personal_code = :personalCode");
        query.setParameter("personalCode", personalCode);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public List<Client> getAllClients() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Client b", Client.class)
                .getResultList();
    }

    @Override
    public Long getClientIdByPersonalCode (String personalCode) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT c.id FROM Client c WHERE c.personalCode = :personalCode", Long.class)
                .setParameter("personalCode", personalCode)
                .uniqueResult();
    }

    @Override
    public List<Client> findByFirstName(String firsName) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Client b where first_name = :firstName");
        query.setParameter("firstName", firsName);
        return query.getResultList();
    }

    @Override
    public List<Client> findByLastName(String lastName) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Client b where last_name = :lastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<Client> findByPersonalCode(String personalCode) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Client b where personal_code = :personalCode");
        query.setParameter("personalCode", personalCode);
        return query.getResultList();
    }

    @Override
    public List<Client> findByFirstNameAndLastName(String firstName, String lastName) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Client b where first_name = : firstName AND last_name = :lastName");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
}
