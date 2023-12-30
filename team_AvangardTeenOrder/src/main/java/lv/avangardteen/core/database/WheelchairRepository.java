package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Wheelchair;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WheelchairRepository {

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
                .createQuery("UPDATE Wheelchair c where id = :id");
        query.setParameter("id", id);
        query.setParameter("seatWidth", wheelchair.getSeatWidth());
        query.setParameter("seatDepth", wheelchair.getSeatDepth());
        query.setParameter("footrestLength", wheelchair.getFootrestLength());
        query.setParameter("bachHeight", wheelchair.getBachHeight());
    }

    public Wheelchair getWheelchair(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select c FROM Wheelchair c where id = :id");
        query.setParameter("id", id);
        return (Wheelchair) query.getSingleResult();
    }

    public Long getIdWheelchair() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SHOW id FROM Wheelchair where id = `PRIMARY KEY`");
        return (Long) query.getSingleResult();
    }

    public Double getPrice(Long id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT price FROM Wheelchair where id = :id");
          query.setParameter("id", id);
          return (Double) query.getSingleResult();

    }

}
 // $mysqli->insert_id)

/*
    SHOW INDEX FROM presort.final_conf_score_mld_run2
        WHERE Key_name = 'PRIMARY';*/
