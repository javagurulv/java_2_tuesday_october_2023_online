import java.util.ArrayList;
import java.util.List;

public class Wheelchair {
    UserSizes userSizes;
    ComponentDatabase componentDatabase;

     private int seatWidth;
     private int seatDepth;
     private int footrestLength;
     private int bachHeight;
     List<Component> components;


    public Wheelchair(int seatWidth, int seatDepth, int footrestLength, int bachHeight) {
        this.seatWidth = 0;
        this.seatDepth = 0;
        this.footrestLength = 0;
        this.components = new ArrayList<>();
    }
    public void AddComponents(Component component) {
components.add(component);
    }

    public int getSeatWidth() {
        return seatWidth;
    }

    public void setSeatWidth(int seatWidth) {
        this.seatWidth = userSizes.findSeatWidth();
    }

    public int getSeatDepth() {
        return seatDepth;
    }

    public void setSeatDepth(int seatDepth) {
        this.seatDepth = userSizes.findSeatDepth();
    }

    public int getFootrestLength() {
        return footrestLength;
    }

    public void setFootrestLength(int footrestLength) {
        this.footrestLength = userSizes.findFootrestLength();
    }

    public int getBachHeight() {
        return bachHeight;
    }

    public void setBachHeight(int bachHeight) {
        this.bachHeight = userSizes.backHeight;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;

    }
}
