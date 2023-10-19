package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.Wheelchair;

public class GetAntropometricDataServis {
     Client client;

    public GetAntropometricDataServis(Client client) {
        this.client = client;
    }

    public  int getPelvis () {return client.getWheelchair().getUserData().getUserSizes().getPelvisWidth();
    }
    public  int getShinLength (){
        return client.getWheelchair().getUserData().getUserSizes().getShinLength();
    }
    public  int getBackLength (){
        return client.getWheelchair().getUserData().getUserSizes().getBackHeight();
    }
    public  int getThighLength (){
        return client.getWheelchair().getUserData().getUserSizes().getThighLength();
    }
}

