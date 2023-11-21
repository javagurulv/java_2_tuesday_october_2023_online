package avangardteen.java2app.responce;

import avangardteen.java2app.*;

import java.util.List;

public class ChangeCompanentsResponce extends CoreResponce {
    List<Category> listAllCategory;
    List<Component> chooseNewComponent;
   Wheelchair wheelchair;

    public ChangeCompanentsResponce(List<CoreError> errorList) {
        super(errorList);
    }

    public Wheelchair getWheelchair() {
        return wheelchair;
    }


    public List<Category> getListAllCategory() {
        return listAllCategory;
    }

    public List<Component> getChooseNewComponent() {
        return chooseNewComponent;
    }

    public ChangeCompanentsResponce(List<Category> listAllCategory, List<Component> chooseNewComponent, Wheelchair wheelchair) {
        this.listAllCategory = listAllCategory;
        this.chooseNewComponent = chooseNewComponent;
        this.wheelchair = wheelchair;
    }

    public ChangeCompanentsResponce() {
    }
}