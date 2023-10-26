package avangardteen.java.request;

public class ChangeComponentsRequest {
    int cathegory;
    int newChoose;

    public ChangeComponentsRequest(int cathegory, int newChoose) {
        this.cathegory = cathegory;
        this.newChoose = newChoose;
    }

    public int getCathegory() {
        return cathegory;
    }

    public int getNewChoose() {
        return newChoose;
    }
}
