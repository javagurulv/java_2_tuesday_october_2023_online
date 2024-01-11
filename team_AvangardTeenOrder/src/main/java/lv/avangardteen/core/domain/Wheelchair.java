package lv.avangardteen.core.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "wheelchair")
public class Wheelchair {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "seatWidth", nullable = false)
    Integer seatWidth;

    @Column(name = "seatDepth", nullable = false)
    Integer seatDepth;

    @Column(name = "footrestLength", nullable = false)
    Integer footrestLength;

    @Column(name = "bachHeight", nullable = false)
    Integer bachHeight;

    @Column(name = "price", nullable = false)
    double price = 177000.0;

    @OneToMany(mappedBy="wheelchair", fetch=FetchType.EAGER)
    private List<WheelchairComponents> wheelchairComponents;

    public Wheelchair() {
    }

    public Wheelchair(Integer seatWidth, Integer seatDepth, Integer footrestLength, Integer bachHeight) {
        this.seatWidth = seatWidth;
        this.seatDepth = seatDepth;
        this.footrestLength = footrestLength;
        this.bachHeight = bachHeight;

    }

    public Wheelchair( Client client, Integer seatWidth, Integer seatDepth, Integer footrestLength, Integer bachHeight, double price, List<WheelchairComponents> wheelchairComponents) {

        this.client = client;
        this.seatWidth = seatWidth;
        this.seatDepth = seatDepth;
        this.footrestLength = footrestLength;
        this.bachHeight = bachHeight;
        this.price = price;
        this.wheelchairComponents = wheelchairComponents;
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

    public List<WheelchairComponents> getWheelchairComponents() {
        return wheelchairComponents;
    }

    public void setWheelchairComponents(List<WheelchairComponents> wheelchairComponents) {
        this.wheelchairComponents = wheelchairComponents;
    }

    public Integer getSeatWidth() {
        return seatWidth;
    }

    public void setSeatWidth(Integer seatWidth) {
        this.seatWidth = seatWidth;
    }

    public Integer getSeatDepth() {
        return seatDepth;
    }

    public void setSeatDepth(Integer seatDepth) {
        this.seatDepth = seatDepth;
    }

    public Integer getFootrestLength() {
        return footrestLength;
    }

    public void setFootrestLength(Integer footrestLength) {
        this.footrestLength = footrestLength;
    }

    public Integer getBachHeight() {
        return bachHeight;
    }

    public void setBachHeight(Integer bachHeight) {
        this.bachHeight = bachHeight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheelchair that = (Wheelchair) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(seatWidth, that.seatWidth) && Objects.equals(seatDepth, that.seatDepth) && Objects.equals(footrestLength, that.footrestLength) && Objects.equals(bachHeight, that.bachHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, seatWidth, seatDepth, footrestLength, bachHeight, price);
    }

    @Override
    public String toString() {
        return "Габариты инвалидного кресла: " + '\n' +
                " ширина сиденья = " + getSeatWidth() + '\n' +
                " глубина сиденья = " + getSeatDepth() + '\n' +
                " длина подставки для ног = " + getFootrestLength() + '\n' +
                " высота спинки = " + getBachHeight() + '\n' +
                " стоимость = " + price + ';';

    }


}

