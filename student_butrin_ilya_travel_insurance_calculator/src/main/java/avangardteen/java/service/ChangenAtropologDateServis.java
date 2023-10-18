package avangardteen.java.service;

import avangardteen.java.Client;

public class ChangenAtropologDateServis {
    private static Client user;

    public ChangenAtropologDateServis(Client user) {
        this.user = user;
    }
    public void setShinLength(int choose) {
        user.getUserSizes().setShinLength(choose);
    }
    public void setPelvis(int choose) {
        user.getUserSizes().setPelvisWidth(choose);
    }
    public void setThighLength(int choose) {
        user.getUserSizes().setThighLength(choose);
    }
    public void setBackLength(int choose) {
        user.getUserSizes().setShinLength(choose);
    }
}