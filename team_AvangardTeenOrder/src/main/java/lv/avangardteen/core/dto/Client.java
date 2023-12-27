package lv.avangardteen.core.dto;

import java.util.Objects;

public class Client {
    Long id;
    String nameSurname;
    Long phoneNumber;
    String userAddress;

    public Client(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return  " Имя, Фамилия: " + nameSurname + '\n' +
                " номер телефона: " + phoneNumber + '\n' +
                " адрес: " + userAddress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(nameSurname, client.nameSurname) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(userAddress, client.userAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSurname, phoneNumber, userAddress);
    }
}
