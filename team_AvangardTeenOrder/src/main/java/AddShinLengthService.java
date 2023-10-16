public class AddShinLengthService {

    private UserSizes size;

    public AddShinLengthService(UserSizes size) {
        this.size = size;
    }

    public void addShinLength(int shinLength) {
        size.setShinLength(shinLength);
    }


}
