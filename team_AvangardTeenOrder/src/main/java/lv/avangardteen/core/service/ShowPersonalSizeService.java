package lv.avangardteen.core.service;

import lv.avangardteen.Client;


public class ShowPersonalSizeService {
     Client client;

    public ShowPersonalSizeService(Client client) {
        this.client = client;
    }

    public void execute() {
        System.out.println(client.getUserSizes().toString());
    }
}

