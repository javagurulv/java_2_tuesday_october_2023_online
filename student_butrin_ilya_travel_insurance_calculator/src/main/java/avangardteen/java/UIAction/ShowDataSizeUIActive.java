package avangardteen.java.UIAction;


import avangardteen.java.Wheelchair;

import avangardteen.java.service.GetAntropometricDataServis;

public class ShowDataSizeUIActive implements UIAction{

    public ShowDataSizeUIActive(GetAntropometricDataServis servis) {
        this.servis = servis;
    }

    GetAntropometricDataServis servis;


    @Override
    public void execute() {
        System.out.println("1. ширина таза:  " + servis.getPelvis());
        System.out.println("2. длина бедра: " + servis.getThighLength());
        System.out.println("3. длина спины до нижнего края лопатки: " + servis.getBackLength());
        System.out.println("4. длину голени: " + servis.getShinLength());
    }
}
