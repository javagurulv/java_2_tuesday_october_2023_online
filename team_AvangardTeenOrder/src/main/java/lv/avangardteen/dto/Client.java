package lv.avangardteen.dto;

import java.util.Objects;

public class Client {
    Long id;
    String nameSurname;
    Integer phoneNumber;
    String userAddress;
    UserSizes userSizes;
    Wheelchair wheelchair = new Wheelchair();
    WheelchairComponent wheelchairComponents;
    double priseOrder;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPriseOrder() {
        return priseOrder;
    }

    public void setPriseOrder(double priseOrder) {
        this.priseOrder = priseOrder;
    }


    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public UserSizes getUserSizes() {
        return userSizes;
    }

    public void setUserSizes(UserSizes userSizes) {

        this.userSizes = userSizes;
    }

    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public WheelchairComponent getWheelchairComponents() {
        return wheelchairComponents;
    }

    public void setWheelchairComponents(WheelchairComponent wheelchairComponent) {
        this.wheelchairComponents = wheelchairComponent;
    }

    @Override
    public String toString() {
        return "Ваш заказ:" + '\n' +

                " Имя, Фамилия: " + nameSurname + '\n' +
                " номер телефона: " + phoneNumber + '\n' +
                " адрес: " + userAddress + '\n' +
                " антропометрические данные:" + '\n' + userSizes +
                " габариты Avangard Teen" +'\n' + wheelchair +
                " комплектующие: " + wheelchairComponents + '\n' +
                " Общая стоимость заказа: " + priseOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Double.compare(client.priseOrder, priseOrder) == 0 && Objects.equals(nameSurname, client.nameSurname) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(userAddress, client.userAddress) && Objects.equals(userSizes, client.userSizes) && Objects.equals(wheelchair, client.wheelchair) && Objects.equals(wheelchairComponents, client.wheelchairComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameSurname, phoneNumber, userAddress, userSizes, wheelchair, wheelchairComponents, priseOrder);
    }
}
