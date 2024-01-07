package avangardteen.java2app.service;

import avangardteen.java2app.*;
//import org.springframework.stereotype.Component;
import avangardteen.java2app.data.DatabaseComponent;
import avangardteen.java2app.domen.Wheelchair;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ChangeComponentsRequest;
import avangardteen.java2app.responce.ChangeCompanentsResponce;
import avangardteen.java2app.service.valigation.WheelchairValigator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static avangardteen.java2app.Category.BACK_WHEEL_SIZE;
@Component
public class ChangeComponentServise {

 @Autowired
 DatabaseComponent components;
   @Autowired
   Wheelchair wheelchair;
   @Autowired WheelchairValigator valigator;


    public ChangeCompanentsResponce responce() {
        List<Category> listAllCathegory = listAllCategory();
        ChangeCompanentsResponce responce = new ChangeCompanentsResponce(listAllCathegory, null, wheelchair);
        return responce;
    }


    public ChangeCompanentsResponce responce2(ChangeComponentsRequest request) {
        List<ComponentWheelchair> listAllComponen = listComponents(request);
        ChangeCompanentsResponce responce = new ChangeCompanentsResponce(null, listAllComponen, null);
        return responce;
    }

    public ChangeCompanentsResponce responce3(ChangeComponentsRequest request) {
        chooseNewComponent(request);
        ChangeCompanentsResponce responce = new ChangeCompanentsResponce();
        List<CoreError> errors = valigator.errorlist(wheelchair);
        if (!errors.isEmpty())
            return new ChangeCompanentsResponce(errors);
        return responce;
    }

    public List<ComponentWheelchair> responce4() {
       List<ComponentWheelchair> xx = checkSizeAndType();
       return xx;
    }
    public void responce5(ChangeComponentsRequest request) {
        List<ComponentWheelchair> x = checkSizeAndType();
        for (int i=0; i< x.size();i++)
        if (request.getNewChoose() == i + 1){
            String id = x.get(i).getComponentID();
            wheelchair.addComponents(id,components);
        }
    }



    public List<Category> listAllCategory() {
        List<Category> showCategory = new ArrayList<>();
        int number = 0;
        for (Map.Entry<Category, ComponentWheelchair> component : wheelchair.getComponents().entrySet()) {
            number++;
            showCategory.add(component.getValue().getCategory());
        }
        return showCategory;
    }

    public  List<ComponentWheelchair> chooseNewComponent(ChangeComponentsRequest request) {

        List<ComponentWheelchair> chooseNewComponent = listComponents(request);
        int choose = request.getNewChoose();
        for (int i = 1; i <= chooseNewComponent.size(); i++) {
            if (choose == i) {
                String id = chooseNewComponent.get(i - 1).getComponentID();
                wheelchair.addComponents(id, components);
            }

        }
        return chooseNewComponent;
    }

    public List<ComponentWheelchair> listComponents(ChangeComponentsRequest request) {
        List<Category> listAllCategory = listAllCategory();
        List<ComponentWheelchair> newChoose = new ArrayList<>();
        for (int i = 0; i < components.getAllComponents().size(); i++) {
            if (components.getAllComponents().get(i).getCategory().equals(
                    listAllCategory.get(request.getCathegory() - 1))) {
                newChoose.add(components.getAllComponents().get(i));
            }

        }
        return newChoose;
    }
    public List<ComponentWheelchair> checkSizeAndType(){
        List <ComponentWheelchair> info = new ArrayList<>();
        ComponentWheelchair comp = wheelchair.getComponents().get(BACK_WHEEL_SIZE);
        if (comp.getComponentID().equals("MG 04")) {
            info = new ArrayList<>();
            info.addAll(components.allBackWheelsFor20size());
        }
        if (comp.getComponentID().equals("MG 01")) {
            info = new ArrayList<>();
            info.addAll(components.allBackWheelsFor22size());
        }
        if (comp.getComponentID().equals("MG 02")) {
            info = new ArrayList<>();
            info.addAll(components.allBackWheelsFor24Size());
        }
        return info;

}
}