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
public class WheelchairComponentsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<WheelchairComponents> getChooseComponents(Long id) {
        Query query =  sessionFactory.getCurrentSession()
                .createQuery("SELECT wc FROM WheelchairComponents WHERE client_id = :id");
        query.setParameter("client_id", id);
        return  query.getResultList();

    }

    public void addWheelchairComponents(WheelchairComponents wheelchairComponents) {
        sessionFactory.getCurrentSession().save(wheelchairComponents);
    }

    public boolean deleteWheelchairComponents(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete WheelchairComponents wc where client_id = :id");
        query.setParameter("client_id", id);
        int result = query.executeUpdate();
        return result == 1;

    }
    public List<WheelchairComponents> getAllWheelchairComponents() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT wc FROM WheelchairComponents wc", WheelchairComponents.class)
                .getResultList();
    }

}
