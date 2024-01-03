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
public class UserSizeRepositoryImpl implements UserSizeDb {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserSizes> getUserSizesOrders() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT us FROM Client_size us", UserSizes.class)
                .getResultList();
    }

    @Override
    public void addUserSize(UserSizes userSizes) {
        sessionFactory.getCurrentSession().save(userSizes);
    }

    @Override
    public void updateUserSize(Long id, UserSizes userSizes) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Client_size us where order_id = :id");
        query.setParameter("order_id", id);
        query.setParameter("pelvisWidth", userSizes.getPelvisWidth());
        query.setParameter("thighLength", userSizes.getThighLength());
        query.setParameter("backHeight", userSizes.getBackHeight());
        query.setParameter("shinLength", userSizes.getShinLength());
    }

    @Override
    public UserSizes getUserSizeByOrderId(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select us FROM Client_size where order_id = :id");
        query.setParameter("order_id", id);
        return (UserSizes) query.getSingleResult();

    }

    @Override
    public void setOrderId(Long orderId) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("INSERT INTO Client_size c order_id = :id");
        query.setParameter("order_id", orderId);
    }

  /*  @Override
    public void setClientId(Query queryClient) {
        Query query1 = sessionFactory.getCurrentSession()
                .createQuery("INSERT INTO Client_size c client_id = :id");
        query1.setParameter("client_id", queryClient);
    }*/
}
