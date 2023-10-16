public class AddBackLengthService {

    private UserSizes size;

    public AddBackLengthService(UserSizes size) {
        this.size = size;
    }

    public void addBackLength(int backLength) {
        size.setBackHeight(backLength);
    }


}
