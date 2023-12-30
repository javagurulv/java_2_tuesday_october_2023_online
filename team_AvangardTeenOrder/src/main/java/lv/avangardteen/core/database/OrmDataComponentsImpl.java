package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Category;
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


    public void addCategory(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }


    @Override
    public void addComponent(Components component) {
        sessionFactory.getCurrentSession().save(component);
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
                .createQuery("SELECT c FROM Components WHERE category_key = : titleCategory");
        query.setParameter("category_key", "FRONT-WHEEL");
        return query.getResultList();
    }

    @Override
    public List<Components> allFootrest() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Components WHERE category_key = : titleCategory");
        query.setParameter("category_key", "FOOTREST");
        return query.getResultList();
    }

    @Override
    public List<Components> allBrakes() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Components WHERE category_key = : titleCategory");
        query.setParameter("category_key", "BRAKE");
        return query.getResultList();
    }

    @Override
    public List<Components> allBackWheels() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Components WHERE category_key = : titleCategory");
        query.setParameter("category_key", "BACK-WHEEL");
        return query.getResultList();
    }

}
