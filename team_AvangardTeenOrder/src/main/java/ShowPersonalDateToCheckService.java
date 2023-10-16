
public class ShowPersonalDateToCheckService {
  private UserData userData;

   public ShowPersonalDateToCheckService(UserData userData) {
       this.userData = userData;
   }

   public String checkUserName() {
       return userData.getNameSurname();
   }

    public String checkUserPhone() {
       return userData.getPhoneNumber();
    }

    public String checkUserAddress() {
        return userData.getUserAddress();
    }

}
