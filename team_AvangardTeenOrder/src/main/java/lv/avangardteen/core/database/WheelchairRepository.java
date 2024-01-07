package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Wheelchair;
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
    public List<Wheelchair> getWheelchair() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Wheelchair w", Wheelchair.class)
                .getResultList();
    }

    @Override
    public Long addWheelchair(Wheelchair wheelchair) {
        Long id = (Long) sessionFactory.getCurrentSession().save(wheelchair);
        return id;

    }

    @Override
    public void updateWheelchair(Long id, Wheelchair wheelchair) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Wheelchair c where id = :id");
        query.setParameter("id", id);
        query.setParameter("seatWidth", wheelchair.getSeatWidth());
        query.setParameter("seatDepth", wheelchair.getSeatDepth());
        query.setParameter("footrestLength", wheelchair.getFootrestLength());
        query.setParameter("bachHeight", wheelchair.getBachHeight());
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
    public Long getIdWheelchair() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SHOW id FROM Wheelchair where id = `PRIMARY KEY`");
        return (Long) query.getSingleResult(); //удалить, метод не работает
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

