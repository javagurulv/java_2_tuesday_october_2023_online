import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Wheelchair {
    UserSizes userSizes;
    ComponentDatabase componentDatabase;

     private int seatWidth;
     private int seatDepth;
     private int footrestLength;
     private int bachHeight;
     Map<Category,Component> components;


    public Wheelchair(int seatWidth, int seatDepth, int footrestLength, int bachHeight, Map<Category, Component> components) {
        this.seatWidth = seatWidth;
        this.seatDepth = seatDepth;
        this.footrestLength = footrestLength;
        this.bachHeight = bachHeight;
        this.components = components;
    }

    public void AddComponents(Category category, Component component) {
components.put(category,component);
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

    public void setComponents(Map<Category, Component> components) {
        this.components = components;
    }

    public Map<Category, Component> getComponents() {
        return components;
    }
}

