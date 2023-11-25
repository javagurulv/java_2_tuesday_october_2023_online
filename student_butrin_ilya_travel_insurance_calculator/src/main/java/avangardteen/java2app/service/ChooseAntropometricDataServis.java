package avangardteen.java2app.service;

import avangardteen.java2app.Client;
import avangardteen.java2app.UserSizes;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;

@DIComponent
public class ChooseAntropometricDataServis {
   @DIDependency
    UserSizes sizes;


    public  void setPelvis (int choose){
        sizes.setPelvisWidth(choose);
    }
    public  void setShinLength (int choose){
        sizes.setShinLength(choose);
    }
    public  void setBackLength (int choose){
        sizes.setBackHeight(choose);
    }
    public  void setThighLength (int choose){
        sizes.setThighLength(choose);
    }
}
