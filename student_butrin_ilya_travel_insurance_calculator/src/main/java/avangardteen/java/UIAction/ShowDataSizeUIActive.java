package avangardteen.java.UIAction;


import avangardteen.java.UserSizes;
import avangardteen.java.request.ShowDataSizeRequest;
import avangardteen.java.responce.ShowDataSizeResponse;
import avangardteen.java.service.GetAntropometricDataServis;

public class ShowDataSizeUIActive implements UIAction{

    public ShowDataSizeUIActive(GetAntropometricDataServis servis) {
        this.servis = servis;
    }

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
