public class AddThighLengthService {

    private UserSizes size;

    public AddThighLengthService(UserSizes size) {
        this.size = size;
    }

    public void addThighLength(int thighLength) {
        size.setThighLength(thighLength);
    }


}
