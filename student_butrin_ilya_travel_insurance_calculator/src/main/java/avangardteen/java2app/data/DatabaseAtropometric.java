package avangardteen.java2app.data;

import avangardteen.java2app.domen.Client;
import avangardteen.java2app.domen.UserSizes;

import java.util.List;

public interface DatabaseAtropometric {
    void addAntropologDate(UserSizes sizes);
    public void changeAntropologDate(String type, int newShoose);
    void getAntropologDatedyId(long  id);
    public void updateAntropologDate (long  id, int newChoose, String type);
    List<Client> getAllClients();

}
