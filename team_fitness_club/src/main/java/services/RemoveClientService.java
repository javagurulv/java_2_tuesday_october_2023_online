package services;
import database.*;
import domain.*;

public class RemoveClientService {

    private Database database;

    public  RemoveClientService(Database database) {
        this.database = database;
    }

    public void removeClient(String firstName, String lastName, String personalCode) {
        Client client = new Client(firstName, lastName, personalCode);
        database.removeClient(client);
    }
}

