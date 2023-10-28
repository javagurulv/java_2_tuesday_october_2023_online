package avangardteen.java.service;

import avangardteen.java.Category;
import avangardteen.java.Client;
import avangardteen.java.Component;
import avangardteen.java.data.DataComponents;
import avangardteen.java.request.ChangeComponentsRequest;
import avangardteen.java.responce.ChangeCompanentsResponce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ChangeComponentServise {
    DataComponents components;
    Client client;

    public ChangeComponentServise(DataComponents components, Client client) {
        this.components = components;
        this.client = client;
    }


    public ChangeCompanentsResponce responce() {
        List<Category> listAllCathegory = listAllCategory();
        ChangeCompanentsResponce responce = new ChangeCompanentsResponce(listAllCathegory,client);
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
        for (Map.Entry<Category, Component> component : client.getWheelchair().getComponents().entrySet()) {
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
                client.getWheelchair().addComponents(id, components);
            }
        }
        return chooseNewComponent;
    }

    public List<Component> listComponents(ChangeComponentsRequest request) {
        List<Category> listAllCategory = listAllCategory();
        List<Component> newChoose = new ArrayList<>();
        for (int i = 0; i < components.getAllComponents().size(); i++) {
            if (listAllCategory.get(request.getCathegory() - 1).equals(components.getAllComponents().get(i).getCategory())) {
                newChoose.add(components.getAllComponents().get(i));
            }
        }
        return newChoose;
    }
}