package avangardteen.java2app.service;

import avangardteen.java2app.ComponentWheelchair;
import avangardteen.java2app.data.DataComponents;
import avangardteen.java2app.Wheelchair;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ChooseWheelchairComponensRequest;
import avangardteen.java2app.responce.ChooseWheelchairComponensResponce;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ChooseWheelChairComponentsServis {

  @Autowired DataComponents data;
  @Autowired Wheelchair wheelchair;


    public List<ComponentWheelchair> getAllFrontWheels() {
        List<ComponentWheelchair> frontWheelList = data.allFrontWheels();
        return frontWheelList;
    }
    public List<ComponentWheelchair> getAllBrakes() {
        List<ComponentWheelchair> breakList = data.allBrakes();
        return breakList;
    }
    public List<ComponentWheelchair> getAllArmest() {
        List<ComponentWheelchair> armestList = data.allArmest();
        return armestList;
    }
    public List<ComponentWheelchair> getAllBackWheels() {
        List<ComponentWheelchair> backWheelList = data.allBackWheels();
        return backWheelList;
    }
    public List<ComponentWheelchair> getAllBackWheelsFor20Size() {
        List<ComponentWheelchair> backWheelListFor20Size = data.allBackWheelsFor20size();
        return backWheelListFor20Size;
    }
    public List<ComponentWheelchair> getAllBackWheelsFor22Size() {
        List<ComponentWheelchair> backWheelListFor22Size = data.allBackWheelsFor22size();
        return backWheelListFor22Size;
    }
    public List<ComponentWheelchair> getAllBackWheelsFor24Size() {
        List<ComponentWheelchair> backWheelListFor24Size = data.allBackWheelsFor24Size();
        return backWheelListFor24Size;
    }
    public List<ComponentWheelchair> getAllBackWheelsSize() {
        List<ComponentWheelchair> backWheelsizeList = data.allBackWheelsSize();
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
