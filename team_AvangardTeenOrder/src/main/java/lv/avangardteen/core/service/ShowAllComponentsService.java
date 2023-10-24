package lv.avangardteen.core.service;

import lv.avangardteen.Client;


public class ShowAllComponentsService {
    Client client;

    public ShowAllComponentsService(Client client) {
        this.client = client;
    }

    public void execute() {
       System.out.println(client.getWheelchairComponents().toString());

    }
}
