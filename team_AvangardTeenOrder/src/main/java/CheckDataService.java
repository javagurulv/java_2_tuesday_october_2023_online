public class CheckDataService {
  private UserSizes size;

    public CheckDataService(UserSizes size) {
        this.size = size;
    }

    public int checkPelvisWidth() {
       return size.getPelvisWidth();
   }

    public int checkThighLength() {
       return size.getThighLength();
    }

    public int checkBackLengt() {
        return size.getBackHeight();
    }
    public int checkShinLength() {  return size.getShinLength(); }


}
