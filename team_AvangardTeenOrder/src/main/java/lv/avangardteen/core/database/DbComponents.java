package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Components;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbComponents implements DataComponents{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addComponent(Components components) {
        sessionFactory.getCurrentSession().save(components);
    }

    @Override
    public List<Components> getAllComponents() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Components c", Components.class)
                .getResultList();
    }

    @Override
    public Components getComponent(Integer id) {
        return sessionFactory.getCurrentSession()
                .get(Components.class, id);
    }

    @Override
    public List<Components> allFrontWheels() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Components " +
                        "WHERE category = :category");
        query.setParameter("category", "FRONT-WHEEL");
        return query.getResultList();
    }

    @Override
    public List<Components> allFootrest() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Components " +
                        "WHERE category = :category");
        query.setParameter("category", "FOOTREST");
        return query.getResultList();
    }

    @Override
    public List<Components> allBrakes() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Components " +
                        "WHERE category = :category");
        query.setParameter("category", "BRAKE");
        return query.getResultList();
    }

    @Override
    public List<Components> allBackWheels() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Components " +
                        "WHERE category = :category");
        query.setParameter("category", "BACK-WHEEL");
        return query.getResultList();
    }
}
