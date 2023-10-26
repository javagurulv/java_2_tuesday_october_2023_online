package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.Component;
import avangardteen.java.data.DataComponents;
import avangardteen.java.Wheelchair;
import avangardteen.java.request.ChooseWheelchairComponensRequest;
import avangardteen.java.responce.ChooseWheelchairComponensResponce;
import org.apache.catalina.User;

import java.util.List;

public class ChooseWheelChairComponentsServis {

    DataComponents data;
    Client client;

    public List<Component> getAllFrontWheels() {
        List<Component> frontWheelList = data.allWheels();
        return frontWheelList;
    }
    public List<Component> getAllBrakes() {
        List<Component> BreakList = data.allBrakes();
        return BreakList;
    }
    public List<Component> getAllArmest() {
        List<Component> armestList = data.allArmest();
        return armestList;
    }
    public ChooseWheelChairComponentsServis(DataComponents data, Client client) {
        this.data = data;
        this.client = client;
    }
    public ChooseWheelchairComponensResponce addAllComponent(ChooseWheelchairComponensRequest request){
        addFrontWheels(request.getChooseFrontWheels());
        addArmest(request.getChooseArmed());
        addBreaks(request.getChooseBreaks());
        return new ChooseWheelchairComponensResponce();
    }
    public void addFrontWheels(int choose) {
        for (int i = 1; i <= data.allWheels().size(); i++) {
            if (choose == i) {
                String id = data.allWheels().get(i - 1).getComponentID();
                client.getWheelchair().addComponents(id, data);
            }
        }
    }

    public void addArmest(int choose) {
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
