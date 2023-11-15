package avangardteen.java.responce;

import avangardteen.java.Category;
import avangardteen.java.Client;
import avangardteen.java.Component;
import avangardteen.java.Wheelchair;

import java.util.List;

public class ChangeCompanentsResponce {
    List<Category> listAllCategory;
    List<Component> chooseNewComponent;
   Wheelchair wheelchair;


    public Wheelchair getWheelchair() {
        return wheelchair;
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

    public ChangeCompanentsResponce(List<Category> listAllCategory, Wheelchair wheelchair) {
        this.listAllCategory = listAllCategory;
        this.wheelchair = wheelchair;
    }

    public ChangeCompanentsResponce() {
    }
}