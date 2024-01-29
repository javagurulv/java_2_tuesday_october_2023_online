package avangardteen.java2app.data;

import avangardteen.java2app.Category;
import avangardteen.java2app.domen.ComponentWheelchair;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrmDatabaseComponent implements DatabaseComponent {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ComponentWheelchair> getAllComponents() {
        List<ComponentWheelchair> query = sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Component b", ComponentWheelchair.class)
                .getResultList();
        return query;
    }
    @Override
    public List<ComponentWheelchair> allCathegoryComponent(Category category) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Component b where Category = :category");
        query.setParameter("category", category);
        return query.getResultList();
    }

    @Override
    public List<ComponentWheelchair> allBackWheelsBySize(String id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Component b where Category = BACK_WHEEL_SIZE and " +
                        "id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
