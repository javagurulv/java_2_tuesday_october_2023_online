package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.service.WheelchairComponent;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrmWheelchairRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Wheelchair> getWheelchair() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT w FROM Wheelchair w", Wheelchair.class)
                .getResultList();
    }

    public void addWheelchair(Wheelchair wheelchair) {
        sessionFactory.getCurrentSession().save(wheelchair);

    }

    public void updateWheelchair(Long id, Wheelchair wheelchair) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Wheelchair c where client_id = :id");
        query.setParameter("client_id", id);
        query.setParameter("seatWidth", wheelchair.getSeatWidth());
        query.setParameter("seatDepth", wheelchair.getSeatDepth());
        query.setParameter("footrestLength", wheelchair.getFootrestLength());
        query.setParameter("bachHeight", wheelchair.getBachHeight());
    }

    public Wheelchair getWheelchair(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select c FROM Wheelchair c where client_id = :id");
        query.setParameter("client_id", id);
        return (Wheelchair) query.getSingleResult();
    }

}
