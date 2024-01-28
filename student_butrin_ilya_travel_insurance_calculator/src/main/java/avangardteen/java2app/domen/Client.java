package avangardteen.java2app.domen;

import org.hibernate.annotations.Entity;

import javax.persistence.*;


@Entity
@Table(name="client")
public class Client {
    @Column(name="first_Name")
    private String firstName;
    @Column(name="last_Name")
    private String lastName;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name="e-mail")
    private String e_mail;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="wheelchair")

    Wheelchair wheelchair;

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    @Column(name="antropometricSizes")

    UserSizes userSizes;

    public Client() {
    }

    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public Client(Wheelchair wheelchair, UserSizes userSizes) {
        this.wheelchair = wheelchair;
        this.userSizes = userSizes;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getE_mail() {
        return e_mail;
    }
    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public UserSizes getUserSizes() {
        return userSizes;
    }

    public void setUserSizes(UserSizes userSizes) {
        this.userSizes = userSizes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void setUserEmail(String userAddress) {
        this.e_mail = userAddress;
    }
}
