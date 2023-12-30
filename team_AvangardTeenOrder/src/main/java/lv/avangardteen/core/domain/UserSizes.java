package lv.avangardteen.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client_size")
public class UserSizes {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "pelvisWidth")
    private Integer pelvisWidth;

    @Column(name = "thighLength")
    private Integer thighLength;

    @Column(name = "backHeight")
    private Integer backHeight;

    @Column(name = "shinLength")
    private Integer shinLength;

    @Column(name = "order_id")
    private Long orderId;


    public UserSizes() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

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

    public Integer getPelvisWidth() {
        return pelvisWidth;
    }

    public void setPelvisWidth(Integer pelvisWidth) {
        this.pelvisWidth = pelvisWidth;
    }

    public Integer getThighLength() {
        return thighLength;
    }

    public void setThighLength(Integer thighLength) {
        this.thighLength = thighLength;
    }

    public Integer getBackHeight() {
        return backHeight;
    }

    public void setBackHeight(Integer backHeight) {
        this.backHeight = backHeight;
    }

    public Integer getShinLength() {
        return shinLength;
    }

    public void setShinLength(Integer shinLength) {
        this.shinLength = shinLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSizes userSizes = (UserSizes) o;
        return Objects.equals(id, userSizes.id) && Objects.equals(client, userSizes.client) && Objects.equals(pelvisWidth, userSizes.pelvisWidth) && Objects.equals(thighLength, userSizes.thighLength) && Objects.equals(backHeight, userSizes.backHeight) && Objects.equals(shinLength, userSizes.shinLength) && Objects.equals(orderId, userSizes.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, pelvisWidth, thighLength, backHeight, shinLength, orderId);
    }

    @Override
    public String toString() {
        return "ширина таза =" + pelvisWidth + '\n' +
                " длинна бедра =" + thighLength + '\n' +
                " высота спины =" + backHeight + '\n' +
                " длинна голени =" + shinLength + '\n';

    }
}
