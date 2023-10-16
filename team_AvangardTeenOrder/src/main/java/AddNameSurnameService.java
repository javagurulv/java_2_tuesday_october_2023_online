public class AddNameSurnameService {

    private UserData userData;

    public AddNameSurnameService(UserData userData) {
        this.userData = userData;
    }

    public void addNameSurname (String nameSurname){
        userData.setNameSurname(nameSurname);

    }

}
