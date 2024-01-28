package avangardteen.java2app.data;

import avangardteen.java2app.domen.Client;
import avangardteen.java2app.domen.UserSizes;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrmDatabaseAntropometric implements DatabaseAtropometric {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addAntropologDate(UserSizes sizes) {
        sessionFactory.getCurrentSession().save(sizes);
    }
//        Query query = sessionFactory.getCurrentSession().createQuery("  INSERT INTO antropometric (pelvisWidth, thighLength, backHeight, shinLength) values (1,2,2,2)");
//        query.setParameter("choose", sizes.getPelvisWidth());
//        query.setParameter("choose2", sizes.getThighLength());
//        query.setParameter("choose3", sizes.getBackHeight());
//        query.setParameter("choose4", sizes.getShinLength());
//        ":choose, :choose2,:choose3, :choose4


    @Override
    public void getAntropologDatedyId(long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT b FROM antropometric " +
                "where id = :id");
        query.setParameter("id", id);

    }
    @Override
    public void changeAntropologDate(String type, int newChoose) {
    }
   @Override
    public void updateAntropologDate (long id, int newChoose, String type){
       Query query = sessionFactory.getCurrentSession()
               .createQuery("UPDATE antropometric set :type = :newChoose where id  = :id "  );
       query.setParameter("id", id);
       query.setParameter("type", type);
       query.setParameter("newChoose", newChoose);
   }
    @Override
    public List<Client> getAllClients() {
        return null;
    }
}
