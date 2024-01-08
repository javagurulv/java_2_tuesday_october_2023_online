package avangardteen.java2app.data;

import avangardteen.java2app.domen.Client;
import avangardteen.java2app.domen.UserSizes;

import java.util.List;

public interface DatabaseAtropometric {
    void addAntropologDate(UserSizes sizes);

    void AntropologDate(int id);

    List<Client> getAllClients();

}
