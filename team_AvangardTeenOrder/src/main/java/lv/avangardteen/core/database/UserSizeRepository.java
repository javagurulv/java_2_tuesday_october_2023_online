package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.UserSizes;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserSizeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<UserSizes> getUserSizesOrders() {
      return sessionFactory.getCurrentSession()
                .createQuery("SELECT us FROM UserSize us", UserSizes.class)
                .getResultList();
    }


    public void addUserSize(UserSizes userSizes) {
        sessionFactory.getCurrentSession().save(userSizes);
    }


    public void updateUserSize(Long id, UserSizes userSizes) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE UserSize us where client_id = :id");
        query.setParameter("client_id", id);
        query.setParameter("pelvisWidth", userSizes.getPelvisWidth());
        query.setParameter("thighLength", userSizes.getThighLength());
        query.setParameter("backHeight", userSizes.getBackHeight());
        query.setParameter("shinLength", userSizes.getShinLength());
    }


    public UserSizes getUserSize(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select us FROM UserSize c where client_id = :id");
        query.setParameter("client_id", id);
        return (UserSizes) query.getSingleResult();

    }
}
