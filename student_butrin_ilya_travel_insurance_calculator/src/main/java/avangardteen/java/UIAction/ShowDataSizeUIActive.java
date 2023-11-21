package avangardteen.java.UIAction;


import avangardteen.java.UserSizes;
import avangardteen.java.dependency_injection.DIComponent;
import avangardteen.java.dependency_injection.DIDependency;
import avangardteen.java.request.ShowDataSizeRequest;
import avangardteen.java.responce.ShowDataSizeResponse;
import avangardteen.java.service.GetAntropometricDataServis;
@DIComponent
public class ShowDataSizeUIActive implements UIAction{
  @DIDependency
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
