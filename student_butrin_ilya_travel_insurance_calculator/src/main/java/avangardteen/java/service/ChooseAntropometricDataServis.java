package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.dependency_injection.DIComponent;
import avangardteen.java.dependency_injection.DIDependency;

@DIComponent
public class ChooseAntropometricDataServis {
   @DIDependency
   Client user;


    public  void setPelvis (int choose){
        user.getUserSizes().setPelvisWidth(choose);
    }
    public  void setShinLength (int choose){
        user.getUserSizes().setShinLength(choose);
    }
    public  void setBackLength (int choose){
        user.getUserSizes().setBackHeight(choose);
    }
    public  void setThighLength (int choose){
        user.getUserSizes().setThighLength(choose);
    }
}
