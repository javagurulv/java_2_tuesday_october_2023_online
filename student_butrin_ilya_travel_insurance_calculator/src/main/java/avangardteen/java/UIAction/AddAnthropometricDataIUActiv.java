package avangardteen.java.UIAction;


import avangardteen.java.CoreError;
import avangardteen.java.request.AddAnthropometricDataRequest;
import avangardteen.java.responce.AddAnthropometricDataResponse;
import avangardteen.java.service.AddAtropologDateServis;
import avangardteen.java.service.ChooseAntropometricDataServis;

import java.util.List;
import java.util.Scanner;

public class AddAnthropometricDataIUActiv implements UIAction {

    Scanner scan = new Scanner(System.in);
    AddAtropologDateServis servis;

    public AddAnthropometricDataIUActiv(AddAtropologDateServis servis) {
        this.servis = servis;
    }

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



