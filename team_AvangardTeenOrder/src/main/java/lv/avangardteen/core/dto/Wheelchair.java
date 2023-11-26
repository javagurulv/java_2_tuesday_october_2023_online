package lv.avangardteen.core.dto;

public class Wheelchair {

    Integer seatWidth;
    Integer seatDepth;
    Integer footrestLength;
    Integer bachHeight;

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
    public String toString() {
        return
                " ширина сиденья = " + getSeatWidth() + '\n' +
                " глубина сиденья = " + getSeatDepth() + '\n' +
                " длина подставки для ног = " + getFootrestLength() + '\n' +
                " высота спинки = " + getBachHeight() + '\n' +
                " стоимость = " + priceWheelchair + '\n';

    }
}

