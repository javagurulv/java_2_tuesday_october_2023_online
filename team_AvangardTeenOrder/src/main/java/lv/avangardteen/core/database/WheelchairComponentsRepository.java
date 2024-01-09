package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.domain.WheelchairComponents;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WheelchairComponentsRepository implements WComponentsDB {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<WheelchairComponents> getChooseComponents(Wheelchair wheelchair) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM WheelchairComponents WHERE wheelchair_id = :wheelchair");
        query.setParameter("wheelchair", wheelchair);
        return query.getResultList();

    }

    @Override
    public void addWheelchairComponents(WheelchairComponents wheelchairComponents) {
        sessionFactory.getCurrentSession().save(wheelchairComponents);
    }

    @Override
    public boolean deleteWheelchairComponents(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete WheelchairComponents wc where wheelchair_id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result == 1;

    }

    @Override
    public List<WheelchairComponents> getAllWheelchairComponents() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM WheelchairComponents wc", WheelchairComponents.class)
                .getResultList();
    }

    @Override
    public Double getPriceComponents(Long idWheelchair) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("Select priceComponent from WheelchairComponents" +
                        "where wheelchair_id = id");
        query.setParameter("id", idWheelchair);
        return (Double) query.getSingleResult();
    }


}
