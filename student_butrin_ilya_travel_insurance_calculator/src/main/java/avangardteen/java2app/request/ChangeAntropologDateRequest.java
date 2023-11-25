package avangardteen.java2app.request;

public class ChangeAntropologDateRequest {
int newChoose;
String meaning;

    public String getMeaning() {
        return meaning;
    }

    public ChangeAntropologDateRequest(int newChoose, String meaning) {
        this.newChoose = newChoose;
        this.meaning = meaning;
    }

    public int getNewChoose() {
        return newChoose;
    }
}
