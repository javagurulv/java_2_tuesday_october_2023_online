package avangardteen.java2app.UIAction;


import avangardteen.java2app.CoreError;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;
import avangardteen.java2app.request.AddAnthropometricDataRequest;
import avangardteen.java2app.responce.AddAnthropometricDataResponse;
import avangardteen.java2app.service.AddAtropologDateServis;

import java.util.List;
import java.util.Scanner;
@DIComponent
public class AddAnthropometricDataIUActiv implements UIAction {

   @DIDependency
   AddAtropologDateServis servis;

    Scanner scan = new Scanner(System.in);
    public void execute() {
        System.out.println("введите ширину таза пользователя");
        String pelwicWidthscan = scan.nextLine();
        int pelwicWidth;
        if (pelwicWidthscan.isEmpty()||pelwicWidthscan == null)
            pelwicWidth = 0;
            else pelwicWidth = Integer.parseInt(pelwicWidthscan);
        System.out.println("введите длину бедра пользователя");
        String thighLengthScan = scan.nextLine();
        int thighLength;
        if (thighLengthScan.isEmpty()||thighLengthScan == null)
            thighLength = 0;
        else thighLength = Integer.parseInt(thighLengthScan);
        System.out.println("введите длину голени пользователя");
        String shinLengthScan = scan.nextLine();
        int shinLength;
        if (shinLengthScan.isEmpty()||shinLengthScan == null)
            shinLength = 0;
        else shinLength = Integer.parseInt(shinLengthScan);
        System.out.println("введите длину спины пользователя до нижнего края лопатки");
        String backLengthScan = scan.nextLine();
        int backLength;
        if(backLengthScan.isEmpty()||backLengthScan == null) backLength = 0;
        else backLength = Integer.parseInt(backLengthScan);
        AddAnthropometricDataRequest request = new AddAnthropometricDataRequest(pelwicWidth,thighLength,backLength,shinLength);
        AddAnthropometricDataResponse response = servis.execute(request);
        if(response.hasErrors()){
            List<CoreError> errors = response.getErrorList();
            for (CoreError error : errors) {
                System.err.println(error.getLocation() +  ": " + error.getMessage());

            }
        }
       else {
        System.out.println("ВСЁ ОК"); }


    }
}



