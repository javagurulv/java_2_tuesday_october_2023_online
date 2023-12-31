package lv.avangardteen.core.domain;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name="clients")
public class Client {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name_surname", nullable = false)
    String nameSurname;

    @Column(name = "personal_code", nullable = false)
    Long personalCode;

    @Column(name = "phone", nullable = false)
    Long phone;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "order_id")
    private Long orderId;


    public Client(){}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(nameSurname, client.nameSurname) && Objects.equals(personalCode, client.personalCode) && Objects.equals(phone, client.phone) && Objects.equals(address, client.address) && Objects.equals(orderId, client.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSurname, personalCode, phone, address, orderId);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nameSurname='" + nameSurname + '\'' +
                ", personalCode=" + personalCode +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
