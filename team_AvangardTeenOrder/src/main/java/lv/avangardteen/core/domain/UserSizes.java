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


    public UserSizes() {
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
        return Objects.equals(id, userSizes.id) && Objects.equals(pelvisWidth, userSizes.pelvisWidth) && Objects.equals(thighLength, userSizes.thighLength) && Objects.equals(backHeight, userSizes.backHeight) && Objects.equals(shinLength, userSizes.shinLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pelvisWidth, thighLength, backHeight, shinLength);
    }

    @Override
    public String toString() {
        return "ширина таза =" + pelvisWidth + '\n' +
                " длинна бедра =" + thighLength + '\n' +
                " высота спины =" + backHeight + '\n' +
                " длинна голени =" + shinLength + '\n';

    }
}
