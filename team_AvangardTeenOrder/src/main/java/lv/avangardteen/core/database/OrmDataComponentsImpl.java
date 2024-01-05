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
public class OrmDataComponentsImpl implements DataComponents {

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
        Query query = sessionFactory.getCurrentSession()
                .createQuery("Select c FROM Components WHERE id = :id", Components.class);
        query.setParameter("id", id);
        return (Components) query.getSingleResult();

    }

    @Override
    public List getAllIndex() {
        return sessionFactory.getCurrentSession()
                .createQuery("Select id FROM Components c").getResultList();

    }

    @Override
    public List<Components> allFrontWheels() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Components " +
                        "JOIN Category ON category.id  = components.category_key" +
                        "WHERE category.title = title");
        query.setParameter("title", "FRONT-WHEEL");

        return query.getResultList();
    }

    @Override
    public List<Components> allFootrest() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Components " +
                        "JOIN Category ON category.id  = components.category_key" +
                        "WHERE category.title = title");
        query.setParameter("title", "FOOTREST");
        return query.getResultList();
    }

    @Override
    public List<Components> allBrakes() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Components " +
                        "JOIN Category ON category.id  = components.category_key" +
                        "WHERE category.title = title");
        query.setParameter("title", "BRAKE");
        return query.getResultList();
    }

    @Override
    public List<Components> allBackWheels() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Components " +
                        "JOIN Category ON category.id  = components.category_key" +
                        "WHERE category.title = title");
        query.setParameter("title", "BACK-WHEEL");
        return query.getResultList();
    }

}
