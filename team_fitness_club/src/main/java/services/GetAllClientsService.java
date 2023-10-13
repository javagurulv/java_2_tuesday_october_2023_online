package services;
import database.*;
import domain.*;
import java.util.List;


    public class GetAllClientsService {

        private Database database;

        public GetAllClientsService(Database database) {
            this.database = database;
        }

        public List<Client> execute() {
            return database.getAllClients();
        }
    }
