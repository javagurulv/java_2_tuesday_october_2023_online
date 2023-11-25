package avangardteen.java2app.service;

import avangardteen.java2app.*;
import avangardteen.java2app.data.DataComponents;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;
import avangardteen.java2app.request.ChangeComponentsRequest;
import avangardteen.java2app.responce.ChangeCompanentsResponce;
import avangardteen.java2app.service.valigation.WheelchairValigator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static avangardteen.java2app.Category.BACK_WHEEL_SIZE;
@DIComponent
public class ChangeComponentServise {

 @DIDependency  DataComponents components;
   @DIDependency Wheelchair wheelchair;
   @DIDependency WheelchairValigator valigator;


    public ChangeCompanentsResponce responce() {
        List<Category> listAllCathegory = listAllCategory();
        ChangeCompanentsResponce responce = new ChangeCompanentsResponce(listAllCathegory, null, wheelchair);
        return responce;
    }


    public ChangeCompanentsResponce responce2(ChangeComponentsRequest request) {
        List<Component> listAllComponen = listComponents(request);
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

    public List<Component> responce4() {
       List<Component> xx = checkSizeAndType();
       return xx;
    }
    public void responce5(ChangeComponentsRequest request) {
        List<Component> x = checkSizeAndType();
        for (int i=0; i< x.size();i++)
        if (request.getNewChoose() == i + 1){
            String id = x.get(i).getComponentID();
            wheelchair.addComponents(id,components);
        }
    }



    public List<Category> listAllCategory() {
        List<Category> showCategory = new ArrayList<>();
        int number = 0;
        for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
            number++;
            showCategory.add(component.getValue().getCategory());
        }
        return showCategory;
    }

    public  List<Component> chooseNewComponent(ChangeComponentsRequest request) {

        List<Component> chooseNewComponent = listComponents(request);
        int choose = request.getNewChoose();
        for (int i = 1; i <= chooseNewComponent.size(); i++) {
            if (choose == i) {
                String id = chooseNewComponent.get(i - 1).getComponentID();
                wheelchair.addComponents(id, components);
            }

        }
        return chooseNewComponent;
    }

    public List<Component> listComponents(ChangeComponentsRequest request) {
        List<Category> listAllCategory = listAllCategory();
        List<Component> newChoose = new ArrayList<>();
        for (int i = 0; i < components.getAllComponents().size(); i++) {
            if (components.getAllComponents().get(i).getCategory().equals(
                    listAllCategory.get(request.getCathegory() - 1))) {
                newChoose.add(components.getAllComponents().get(i));
            }

        }
        return newChoose;
    }
    public List<Component> checkSizeAndType(){
        List <Component> info = new ArrayList<>();
        Component comp = wheelchair.getComponents().get(BACK_WHEEL_SIZE);
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