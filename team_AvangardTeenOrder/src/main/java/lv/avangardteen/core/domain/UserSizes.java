package lv.avangardteen.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parameters")
public class UserSizes {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "pelvisWidth", nullable = false)
    private Integer pelvisWidth;

    @Column(name = "thighLength", nullable = false)
    private Integer thighLength;

    @Column(name = "backHeight", nullable = false)
    private Integer backHeight;

    @Column(name = "shinLength", nullable = false)
    private Integer shinLength;

      public UserSizes() {}

    public UserSizes(Long id, Client client, Integer pelvisWidth, Integer thighLength, Integer backHeight, Integer shinLength) {
        this.id = id;
        this.client = client;
        this.pelvisWidth = pelvisWidth;
        this.thighLength = thighLength;
        this.backHeight = backHeight;
        this.shinLength = shinLength;
    }

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
        return Objects.equals(id, userSizes.id) && Objects.equals(client, userSizes.client) && Objects.equals(pelvisWidth, userSizes.pelvisWidth) && Objects.equals(thighLength, userSizes.thighLength) && Objects.equals(backHeight, userSizes.backHeight) && Objects.equals(shinLength, userSizes.shinLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, pelvisWidth, thighLength, backHeight, shinLength);
    }

    @Override
    public String toString() {
        return "ширина таза = " + pelvisWidth +
                ", длина бедра = " + thighLength +
                ", высота спины = " + backHeight +
                " длинна голени = " + shinLength + ";";

    }
}
