package avangardteen.java.service;

import avangardteen.java.Component;
import avangardteen.java.data.DataComponents;
import avangardteen.java.Wheelchair;
import avangardteen.java.request.ChooseWheelchairComponensRequest;
import avangardteen.java.responce.ChooseWheelchairComponensResponce;

import java.util.List;

public class ChooseWheelChairComponentsServis {

    DataComponents data;
    Wheelchair wheelchair;

    public ChooseWheelChairComponentsServis(DataComponents data, Wheelchair wheelchair) {
        this.data = data;
        this.wheelchair = wheelchair;
    }

    public List<Component> getAllFrontWheels() {
        List<Component> frontWheelList = data.allFrontWheels();
        return frontWheelList;
    }
    public List<Component> getAllBrakes() {
        List<Component> breakList = data.allBrakes();
        return breakList;
    }
    public List<Component> getAllArmest() {
        List<Component> armestList = data.allArmest();
        return armestList;
    }
    public List<Component> getAllBackWheels() {
        List<Component> backWheelList = data.allBackWheels();
        return backWheelList;
    }
    public List<Component> getAllBackWheelsFor20Size() {
        List<Component> backWheelListFor20Size = data.allBackWheelsFor20size();
        return backWheelListFor20Size;
    }
    public List<Component> getAllBackWheelsFor22Size() {
        List<Component> backWheelListFor22Size = data.allBackWheelsFor22size();
        return backWheelListFor22Size;
    }
    public List<Component> getAllBackWheelsFor24Size() {
        List<Component> backWheelListFor24Size = data.allBackWheelsFor24Size();
        return backWheelListFor24Size;
    }
    public List<Component> getAllBackWheelsSize() {
        List<Component> backWheelsizeList = data.allBackWheelsSize();
        return backWheelsizeList;
    }

    public ChooseWheelchairComponensResponce addAllComponent(ChooseWheelchairComponensRequest request){
        addFrontWheels(request.getChooseFrontWheels());
        addArmest(request.getChooseArmed());
        addBreaks(request.getChooseBreaks());
        addBackWheels(request.getChooseBackWheels());
        addBackWheelsSize(request.getChooseBackWheelSize());
        return new ChooseWheelchairComponensResponce();
    }
    public void addFrontWheels(int choose) {
        for (int i = 1; i <= data.allFrontWheels().size(); i++) {
            if (choose == i) {
                String id = data.allFrontWheels().get(i - 1).getComponentID();
                wheelchair.addComponents(id, data);
            }
        }
    }
    public void addBackWheelsSize(int choose) {
        for (int i = 1; i <= data.allBackWheelsSize().size(); i++) {
            if (choose == i) {
                String id = data.allBackWheelsSize().get(i - 1).getComponentID();
                wheelchair.addComponents(id, data);
            }
        }
    }
    public void addBackWheels(int choose) {
        for (int i = 1; i <= data.allBackWheels().size(); i++) {
            if (choose == i) {
                String id = data.allBackWheels().get(i - 1).getComponentID();
                wheelchair.addComponents(id, data);
            }
        }
    }

    public void addArmest(int choose) {
        for (int i = 1; i <= data.allArmest().size(); i++) {
            if (choose == i) {
                String id = data.allArmest().get(i - 1).getComponentID();
                wheelchair.addComponents(id, data);
            }
        }
    }

    public void addBreaks(int choose) {
        for (int i = 1; i <= data.allBrakes().size(); i++) {
            if (choose == i) {
                String id = data.allBrakes().get(i - 1).getComponentID();
                wheelchair.addComponents(id, data);
            }
        }
    }
}
