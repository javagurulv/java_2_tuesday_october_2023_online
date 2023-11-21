package avangardteen.java2app.request;

public class ChangeComponentsRequest {
    int cathegory;
    int newChoose;

    public ChangeComponentsRequest(int cathegory, int newChoose) {
        this.cathegory = cathegory;
        this.newChoose = newChoose;
    }

    public ChangeComponentsRequest(int cathegory) {
        this.cathegory = cathegory;
    }


    public int getCathegory() {
        return cathegory;
    }

    public int getNewChoose() {
        return newChoose;
    }
}
