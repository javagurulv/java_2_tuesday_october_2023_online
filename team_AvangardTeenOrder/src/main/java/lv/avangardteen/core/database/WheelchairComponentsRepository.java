package lv.avangardteen.core.database;

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
    public List<WheelchairComponents> getChooseComponents(Long id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT wc FROM WheelchairComponents WHERE wheelchair_id = :id");
        query.setParameter("wheelchair_id", id);
        return query.getResultList();

    }

    @Override
    public void addWheelchairComponents(Long idWheelchair, Integer chooseComponent) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("INSERT INTO order_components WHERE wheelchair_id = :wheelchair.id" +
                        "AND components_id = :components.id");
        query.setParameter("wheelchair_id", idWheelchair);
        query.setParameter("component_id", chooseComponent);
    }

    @Override
    public boolean deleteWheelchairComponents(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete order_components wc where wheelchair_id = :id");
        query.setParameter("wheelchair_id", id);
        int result = query.executeUpdate();
        return result == 1;

    }

    @Override
    public List<WheelchairComponents> getAllWheelchairComponents() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT wc FROM order_components wc", WheelchairComponents.class)
                .getResultList();
    }

    @Override
    public Double getPriceComponents(Long idWheelchair) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT Sum(price) FROM Order_components" +
                        "WHERE wheelchair_id = : id");
        query.setParameter("wheelchair_id", idWheelchair);
        return (Double) query.getSingleResult();
    }


}
