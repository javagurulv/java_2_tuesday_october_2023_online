package avangardteen.java.request;

public class ChooseWheelchairComponensRequest {
int chooseArmed;
int chooseFrontWheels;
int chooseBreaks;

    public int getChooseArmed() {
        return chooseArmed;
    }

    public int getChooseFrontWheels() {
        return chooseFrontWheels;
    }

    public int getChooseBreaks() {
        return chooseBreaks;
    }

    public ChooseWheelchairComponensRequest(int chooseArmed, int chooseFrontWheels, int chooseBreaks) {
        this.chooseArmed = chooseArmed;
        this.chooseFrontWheels = chooseFrontWheels;
        this.chooseBreaks = chooseBreaks;
    }
}
