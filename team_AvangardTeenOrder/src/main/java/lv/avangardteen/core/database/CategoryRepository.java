package lv.avangardteen.core.database;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;


}
