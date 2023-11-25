package avangardteen.java2app.request;

public class ChooseWheelchairComponensRequest {
int chooseArmed;
int chooseFrontWheels;
int chooseBreaks;
int chooseBackWheels;
int chooseBackWheelSize;

    public int getChooseBackWheels() {
        return chooseBackWheels;
    }
    public int getChooseArmed() {
        return chooseArmed;
    }


    public int getChooseFrontWheels() {
        return chooseFrontWheels;
    }

    public int getChooseBreaks() {
        return chooseBreaks;
    }

    public int getChooseBackWheelSize() {
        return chooseBackWheelSize;
    }

    public ChooseWheelchairComponensRequest(int chooseArmed, int chooseFrontWheels, int chooseBreaks, int chooseBackWheels, int chooseBackWheelSize) {
        this.chooseArmed = chooseArmed;
        this.chooseFrontWheels = chooseFrontWheels;
        this.chooseBreaks = chooseBreaks;
        this.chooseBackWheels = chooseBackWheels;
        this.chooseBackWheelSize = chooseBackWheelSize;
    }
}

