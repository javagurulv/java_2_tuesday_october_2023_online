package avangardteen.java.service;

import avangardteen.java.Client;

public class ChooseAntropometricDataServis {
    Client user;
    public ChooseAntropometricDataServis(Client user) {
        this.user = user;
    }


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
