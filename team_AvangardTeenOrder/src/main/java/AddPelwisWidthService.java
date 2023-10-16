public class AddPelwisWidthService {

    private UserSizes size;

    public AddPelwisWidthService(UserSizes size) {
        this.size = size;
    }

   public void addUserPelwis(int pelvisWidth) {
        size.setPelvisWidth(pelvisWidth);
    }


}
