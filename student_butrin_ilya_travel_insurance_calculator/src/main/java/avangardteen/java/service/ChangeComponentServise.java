package avangardteen.java.service;

import avangardteen.java.Category;
import avangardteen.java.Client;
import avangardteen.java.Component;
import avangardteen.java.Wheelchair;
import avangardteen.java.data.DataComponents;
import avangardteen.java.request.ChangeComponentsRequest;
import avangardteen.java.responce.ChangeCompanentsResponce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static avangardteen.java.Category.BACK_WHEEL;
import static avangardteen.java.Category.BACK_WHEEL_SIZE;

public class ChangeComponentServise {
    DataComponents components;
    Wheelchair wheelchair;

    public ChangeComponentServise(DataComponents components, Wheelchair wheelchair) {
        this.components = components;
        this.wheelchair = wheelchair;
    }

    public ChangeCompanentsResponce responce() {
        List<Category> listAllCathegory = listAllCategory();
        ChangeCompanentsResponce responce = new ChangeCompanentsResponce(listAllCathegory, wheelchair);
        return responce;
    }
    public ChangeCompanentsResponce responce2(ChangeComponentsRequest request) {
        List<Component> listAllComponen = listComponents(request);
        ChangeCompanentsResponce responce = new ChangeCompanentsResponce(listAllComponen);
        return responce;
    }
    public ChangeCompanentsResponce responce3 (ChangeComponentsRequest request) {
        chooseNewComponent(request);
        ChangeCompanentsResponce responce = new ChangeCompanentsResponce();
        return responce;
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
                newChoose.add(components.getAllComponents().get(i));}
            if (listAllCategory.get(request.getCathegory() - 1).equals(BACK_WHEEL)) {
                Component comp = wheelchair.getComponents().get(BACK_WHEEL_SIZE);
                if (comp.getComponentID().equals("MG 04")) {
                    List<Component> newChoose20Size = new ArrayList<>();
                    newChoose20Size.addAll(components.allBackWheelsFor20size());
                    return newChoose20Size;}
                if (comp.getComponentID().equals("MG 01")) {
                    List<Component> newChoose22Size = new ArrayList<>();
                    newChoose22Size.addAll(components.allBackWheelsFor22size());
                    return newChoose22Size;}
                if (comp.getComponentID().equals("MG 02")) {
                    List<Component> newChoose24Size = new ArrayList<>();
                    newChoose24Size.addAll(components.allBackWheelsFor20size());
                    return newChoose24Size;}
            }
        }
        return newChoose;

}
}