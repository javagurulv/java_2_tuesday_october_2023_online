public class AddUserAddressService {

    private UserData userData;

    public AddUserAddressService(UserData userData) {
        this.userData = userData;
    }

    public void addUserAddress (String userAddress){
        userData.setUserAddress(userAddress);

    }


}
