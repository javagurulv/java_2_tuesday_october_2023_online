package avangardteen.java.request;

import avangardteen.java.Category;

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
