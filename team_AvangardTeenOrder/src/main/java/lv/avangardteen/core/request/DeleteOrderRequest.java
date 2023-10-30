package lv.avangardteen.core.request;

public class DeleteOrderRequest {
    int id;
    String surname;

    public DeleteOrderRequest(int id, String surname) {
        this.id = id;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }
}
