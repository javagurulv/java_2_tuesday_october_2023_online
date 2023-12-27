package lv.avangardteen.core.domain;

import java.util.Objects;

public class Client {
    Long id;
    String nameSurname;
    Long personalCode;
    Long phone;
    String address;

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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(Long personalCode) {
        this.personalCode = personalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  " Имя, Фамилия: " + nameSurname + '\n' +
                "персональный код: " + personalCode + '\n' +
                " номер телефона: " + phone + '\n' +
                " адрес: " + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(nameSurname, client.nameSurname) && Objects.equals(personalCode, client.personalCode) && Objects.equals(phone, client.phone) && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSurname, personalCode, phone, address);
    }
}
