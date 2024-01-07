package avangardteen.java2app.service;

import avangardteen.java2app.domen.UserSizes;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ChooseAntropometricDataServis {
   @Autowired
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
