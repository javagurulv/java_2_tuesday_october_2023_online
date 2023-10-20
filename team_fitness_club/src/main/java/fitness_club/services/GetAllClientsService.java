package fitness_club.services;
import fitness_club.database.Database;
import fitness_club.domain.Client;

import java.util.List;


    public class GetAllClientsService {

        private Database database;

        public GetAllClientsService(Database database) {
            this.database = database;
        }

        public List<Client> getAllClients() {
            return database.getAllClients();
        }
    }
