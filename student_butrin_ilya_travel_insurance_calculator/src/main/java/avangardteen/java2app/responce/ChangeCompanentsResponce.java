package avangardteen.java2app.responce;

import avangardteen.java2app.*;

import java.util.List;

public class ChangeCompanentsResponce extends CoreResponce {
    List<Category> listAllCategory;
    List<ComponentWheelchair> chooseNewComponent;
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

    public List<ComponentWheelchair> getChooseNewComponent() {
        return chooseNewComponent;
    }

    public ChangeCompanentsResponce(List<Category> listAllCategory, List<ComponentWheelchair> chooseNewComponent, Wheelchair wheelchair) {
        this.listAllCategory = listAllCategory;
        this.chooseNewComponent = chooseNewComponent;
        this.wheelchair = wheelchair;
    }

    public ChangeCompanentsResponce() {
    }
}