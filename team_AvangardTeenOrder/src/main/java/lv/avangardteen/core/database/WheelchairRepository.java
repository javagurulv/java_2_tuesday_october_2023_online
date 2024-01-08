package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.domain.WheelchairComponents;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Component
@Transactional
public class WheelchairRepository implements WheelchairDB {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Wheelchair> getWheelchairsList() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Wheelchair w", Wheelchair.class)
                .getResultList();
    }

    @Override
    public void addWheelchair(Wheelchair wheelchair) {
        sessionFactory.getCurrentSession().save(wheelchair);
    }

    @Override
    public Wheelchair getWheelchair(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "FROM Wheelchair c where id = :id");
        query.setParameter("id", id);
        try {
            query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return (Wheelchair) query.getSingleResult();
    }


    @Override
    public Double getPrice(Long id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT price FROM Wheelchair where id = :id");
        query.setParameter("id", id);
        return (Double) query.getSingleResult();

    }

    @Override
    public boolean deleteWheelchairById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Wheelchair where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result == 1;
    }

}

