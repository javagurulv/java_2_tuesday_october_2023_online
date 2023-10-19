package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.data.DataComponents;
import avangardteen.java.Wheelchair;
import org.apache.catalina.User;

public class ChooseWheelChairComponentsServis {
    DataComponents data;
    Client client;

    public ChooseWheelChairComponentsServis(DataComponents data, Client client) {
        this.data = data;
        this.client = client;
    }
    public void addWheels(int choose) {
        for (int i = 1; i <= data.allWheels().size(); i++) {
            if (choose == i) {
                String id = data.allWheels().get(i - 1).getComponentID();
                client.getWheelchair().addComponents(id, data);
            }
        }
    }

    public void addArmest( int choose) {
        for (int i = 1; i <= data.allArmest().size(); i++) {
            if (choose == i) {
                String id = data.allArmest().get(i - 1).getComponentID();
                client.getWheelchair().addComponents(id, data);
            }
        }
    }

    public void addBreaks(int choose) {
        for (int i = 1; i <= data.allBrakes().size(); i++) {
            if (choose == i) {
                String id = data.allBrakes().get(i - 1).getComponentID();
                client.getWheelchair().addComponents(id, data);
            }
        }
    }
}
