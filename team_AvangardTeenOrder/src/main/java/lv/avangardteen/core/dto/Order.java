package lv.avangardteen.core.dto;

import lv.avangardteen.core.service.WheelchairComponent;

import java.util.Objects;

public class Order {
    Long id;
    Client client;
    UserSizes userSizes;
    Wheelchair wheelchair;
    WheelchairComponent wheelchairComponents;
    double priseOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public void setWheelchairComponents(WheelchairComponent wheelchairComponents) {
        this.wheelchairComponents = wheelchairComponents;
    }

    public double getPriseOrder() {
        return priseOrder;
    }

    public void setPriseOrder(double priseOrder) {
        this.priseOrder = priseOrder;
    }

    public boolean doQualityCheck() {
        return (client != null) && (userSizes != null) && (wheelchair != null) && (wheelchairComponents != null);
    }


    @Override
    public String toString() {
        return "Ваш заказ:" + '\n' +
                " Персональные данные " + '\n' + client +
                " антропометрические данные:" + '\n' + userSizes +
                " габариты Avangard Teen" + '\n' + wheelchair +
                " комплектующие: " + wheelchairComponents + '\n' +
                " Общая стоимость заказа: " + priseOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.priseOrder, priseOrder) == 0 && Objects.equals(id, order.id) && Objects.equals(client, order.client) && Objects.equals(userSizes, order.userSizes) && Objects.equals(wheelchair, order.wheelchair) && Objects.equals(wheelchairComponents, order.wheelchairComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, userSizes, wheelchair, wheelchairComponents, priseOrder);
    }
}
