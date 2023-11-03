package lv.avangardteen;

public class Wheelchair {
    private UserSizes userSizes;
    Integer seatWidth;
    Integer seatDepth;
    Integer footrestLength;
    Integer bachHeight;

     double priceWheelchair = 177000.0;

    public Wheelchair(UserSizes userSizes) {
        this.userSizes = userSizes;
    }

    public Integer getSeatWidth() {

        return this.seatWidth = setSeatWidth();
    }

    public Integer setSeatWidth() {

        return this.seatWidth = userSizes.findSeatWidth();
    }

    public Integer getSeatDepth() {

        return this.seatDepth = setSeatDepth();
    }

    public Integer setSeatDepth() {

        return  this.seatDepth = userSizes.findSeatDepth();
    }

    public Integer getFootrestLength() {

        return this.footrestLength = setFootrestLength(userSizes);
    }
    public Integer setFootrestLength(UserSizes userSizes) {

        return this.footrestLength = userSizes.findFootrestLength();

    }

    public Integer getBachHeight() {

        return this.bachHeight = setBachHeight(userSizes);
    }

    public Integer setBachHeight(UserSizes userSizes) {

        return this.bachHeight = userSizes.getBackHeight();
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

