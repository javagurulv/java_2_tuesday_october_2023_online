package lv.avangardteen.core.request;

public class ChangePersonalDateRequest {
    private Long id;
    private String nameSurname;
    private Integer phoneNumber;
    private String userAddress;

    public ChangePersonalDateRequest(Long id, String nameSurname, Integer phoneNumber, String userAddress) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
    }


    public Long getId() {
        return id;
    }


    public String getNameSurname() {
        return nameSurname;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }
}
