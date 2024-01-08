package avangardteen.java2app.UIAction;


import avangardteen.java2app.domen.UserSizes;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ShowDataSizeRequest;
import avangardteen.java2app.responce.ShowDataSizeResponse;
import avangardteen.java2app.service.GetAntropometricDataServis;
@Component
public class ShowDataSizeUIActive implements UIAction{
  @Autowired
  GetAntropometricDataServis servis;
    @Override
    public void execute() {
        ShowDataSizeRequest request = new ShowDataSizeRequest();
        ShowDataSizeResponse response = servis.response(request);
        UserSizes userSizes = response.getUserSizes();
        System.out.println("1. ширина таза:  " + userSizes.getPelvisWidth());
        System.out.println("2. длина бедра: " + userSizes.getThighLength());
        System.out.println("3. длина спины до нижнего края лопатки: " + userSizes.getBackHeight());
        System.out.println("4. длину голени: " + userSizes.getShinLength());
    }
}
