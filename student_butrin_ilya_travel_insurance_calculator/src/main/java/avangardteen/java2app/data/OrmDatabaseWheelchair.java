package avangardteen.java2app.data;

import avangardteen.java2app.Category;
import avangardteen.java2app.domen.ComponentWheelchair;
import avangardteen.java2app.domen.Wheelchair;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class OrmDatabaseWheelchair implements  DatabaseWheelchair {
    @Override
    public void addWheelchairComponent(Map<Category, ComponentWheelchair> components) {
    }

    @Override
    public List<Wheelchair> getAllWheelchair() {
        return null;
    }
}