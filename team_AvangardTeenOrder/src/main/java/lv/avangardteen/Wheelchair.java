package lv.avangardteen;

public class Wheelchair {
    private UserSizes userSizes;
    int seatWidth;
    int seatDepth;
    int footrestLength;
    int bachHeight;

     double priceWheelchair = 177000.0;

    public Wheelchair(UserSizes userSizes) {
        this.userSizes = userSizes;
    }

    public int getSeatWidth() {

        return this.seatWidth = setSeatWidth();
    }

    public int setSeatWidth() {

        return this.seatWidth = userSizes.findSeatWidth();
    }

    public int getSeatDepth() {

        return this.seatDepth = setSeatDepth();
    }

    public int setSeatDepth() {

        return  this.seatDepth = userSizes.findSeatDepth();
    }

    public int getFootrestLength() {

        return this.footrestLength = setFootrestLength(userSizes);
    }
    public int setFootrestLength(UserSizes userSizes) {

        return this.footrestLength = userSizes.findFootrestLength();

    }

    public int getBachHeight() {

        return this.bachHeight = setBachHeight(userSizes);
    }

    public int setBachHeight(UserSizes userSizes) {

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

