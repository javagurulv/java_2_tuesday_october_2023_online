package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.UserSizes;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Component
@Transactional
public class ParametersRepository implements UserSizeDb {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserSizes> getUserSizesOrders() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM UserSize us", UserSizes.class)
                .getResultList();
    }

    @Override
    public void addUserSize(UserSizes userSizes) {
        sessionFactory.getCurrentSession().save(userSizes);
    }

    @Override
    public UserSizes getUserSizeByOrderId(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "FROM UserSize where order_id = :id");
        query.setParameter("order_id", id);
        try {
            query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return (UserSizes) query.getSingleResult();
    }


}
