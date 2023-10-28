package avangardteen.java.responce;

import avangardteen.java.Category;
import avangardteen.java.Client;
import avangardteen.java.Component;

import java.util.List;

public class ChangeCompanentsResponce {
    List<Category> listAllCategory;
    List<Component> chooseNewComponent;
    Client client;


    public Client getClient() {
        return client;
    }

    public ChangeCompanentsResponce(List<Component> newChoose) {
        this.chooseNewComponent = newChoose;
    }

    public List<Category> getListAllCategory() {
        return listAllCategory;
    }

    public List<Component> getChooseNewComponent() {
        return chooseNewComponent;
    }

    public ChangeCompanentsResponce(List<Category> listAllCategory, Client client) {
        this.listAllCategory = listAllCategory;
        this.client = client;
    }

    public ChangeCompanentsResponce() {
    }
}