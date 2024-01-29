package avangardteen.java2app.service;

import avangardteen.java2app.Category;
import avangardteen.java2app.domen.ComponentWheelchair;
import avangardteen.java2app.data.DatabaseWheelchair;
import avangardteen.java2app.domen.Wheelchair;
import avangardteen.java2app.data.DatabaseComponent;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ChooseWheelchairComponensRequest;
import avangardteen.java2app.responce.ChooseWheelchairComponensResponce;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public class ChooseWheelChairComponentsServis {

  @Autowired
  DatabaseComponent data;
  @Autowired
  DatabaseWheelchair databaseWheelchair;
  @Autowired Wheelchair wheelchair;


    public List<ComponentWheelchair> getAllFrontWheels() {
        List<ComponentWheelchair> frontWheelList = data.allCathegoryComponent(Category.FRONT_WHEEL);
        return frontWheelList;
    }
    public List<ComponentWheelchair> getAllBrakes() {
        List<ComponentWheelchair> breakList = data.allCathegoryComponent(Category.BRAKE);
        return breakList;
    }
    public List<ComponentWheelchair> getAllArmest() {
        List<ComponentWheelchair> armestList = data.allCathegoryComponent(Category.ARMREST);
        return armestList;
    }
    public List<ComponentWheelchair> getAllBackWheels() {
        List<ComponentWheelchair> backWheelList = data.allCathegoryComponent(Category.BACK_WHEEL);
        return backWheelList;
    }
    public List<ComponentWheelchair> getAllBackWheelsFor20Size() {
        List<ComponentWheelchair> backWheelListFor20Size = data.allBackWheelsBySize("MG 04");
        return backWheelListFor20Size;
    }
    public List<ComponentWheelchair> getAllBackWheelsFor22Size() {
        List<ComponentWheelchair> backWheelListFor22Size = data.allBackWheelsBySize("MG 01");;
        return backWheelListFor22Size;
    }
    public List<ComponentWheelchair> getAllBackWheelsFor24Size() {
        List<ComponentWheelchair> backWheelListFor24Size = data.allBackWheelsBySize("MG 02");
        return backWheelListFor24Size;
    }
    public List<ComponentWheelchair> getAllBackWheelsSize() {
        List<ComponentWheelchair> backWheelsizeList = data.allCathegoryComponent(Category.BACK_WHEEL_SIZE);
        return backWheelsizeList;
    }

    public ChooseWheelchairComponensResponce addAllComponent(ChooseWheelchairComponensRequest request){
        addFrontWheels(request.getChooseFrontWheels());
        addArmest(request.getChooseArmed());
        addBreaks(request.getChooseBreaks());
        addBackWheels(request.getChooseBackWheels());
        addBackWheelsSize(request.getChooseBackWheelSize());
        databaseWheelchair.addWheelchairComponent(wheelchair.getComponents());
        System.out.println(wheelchair.getId());
        return new ChooseWheelchairComponensResponce();
    }
    public void addFrontWheels(int choose) {
        for (int i = 1; i <= data.allCathegoryComponent(Category.FRONT_WHEEL).size(); i++) {
            if (choose == i) {
                String id = data.allCathegoryComponent(Category.FRONT_WHEEL).get(i - 1).getComponentID();
                wheelchair.addComponents(id, data);
            }
        }
    }
    public void addBackWheelsSize(int choose) {
        for (int i = 1; i <= data.allCathegoryComponent(Category.BACK_WHEEL_SIZE).size(); i++) {
            if (choose == i) {
                String id = data.allCathegoryComponent(Category.BACK_WHEEL_SIZE).get(i - 1).getComponentID();
                wheelchair.addComponents(id, data);
            }
        }
    }
    public void addBackWheels(int choose) {
        for (int i = 1; i <=  data.allCathegoryComponent(Category.BACK_WHEEL).size(); i++) {
            if (choose == i) {
                String id = data.allCathegoryComponent(Category.BACK_WHEEL).get(i - 1).getComponentID();
                wheelchair.addComponents(id, data);
            }
        }
    }

    public void addArmest(int choose) {
        for (int i = 1; i <= data.allCathegoryComponent(Category.ARMREST).size(); i++) {
            if (choose == i) {
                String id = data.allCathegoryComponent(Category.ARMREST).get(i - 1).getComponentID();
                wheelchair.addComponents(id, data);
            }
        }
    }

    public void addBreaks(int choose) {
        for (int i = 1; i <= data.allCathegoryComponent(Category.BRAKE).size(); i++) {
            if (choose == i) {
                String id = data.allCathegoryComponent(Category.BRAKE).get(i - 1).getComponentID();
                wheelchair.addComponents(id, data);
            }
        }
    }
}
