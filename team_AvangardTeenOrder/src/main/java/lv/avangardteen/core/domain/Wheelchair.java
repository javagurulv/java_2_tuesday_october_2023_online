package lv.avangardteen.core.domain;

import java.util.Objects;

public class Wheelchair {
    Long id;
    Integer seatWidth;
    Integer seatDepth;
    Integer footrestLength;
    Integer bachHeight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private double priceWheelchair = 177000.0;

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

    public double getPriceWheelchair() {
        return priceWheelchair;
    }

    public void setPriceWheelchair(double priceWheelchair) {

        this.priceWheelchair = priceWheelchair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheelchair that = (Wheelchair) o;
        return Double.compare(that.priceWheelchair, priceWheelchair) == 0 && Objects.equals(id, that.id) && Objects.equals(seatWidth, that.seatWidth) && Objects.equals(seatDepth, that.seatDepth) && Objects.equals(footrestLength, that.footrestLength) && Objects.equals(bachHeight, that.bachHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seatWidth, seatDepth, footrestLength, bachHeight, priceWheelchair);
    }

    @Override
    public String toString() {
        return  "Габариты инвалидного кресла: " + '\n' +
                " ширина сиденья = " + getSeatWidth() + '\n' +
                        " глубина сиденья = " + getSeatDepth() + '\n' +
                        " длина подставки для ног = " + getFootrestLength() + '\n' +
                        " высота спинки = " + getBachHeight() + '\n' +
                        " стоимость = " + priceWheelchair + '\n';

    }
}

