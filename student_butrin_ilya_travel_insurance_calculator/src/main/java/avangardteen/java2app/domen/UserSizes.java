package avangardteen.java2app.domen;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Table(name = "antropometric")
public class UserSizes {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pelvisWidth")
    private int pelvisWidth; //ширина таза
    @Column(name = "thighLength")
    private int thighLength; //длинна бедра
    @Column(name = "backHeight")
    private int backHeight; //высота спины
    @Column(name = "shinLength")
    private int shinLength; //длинна голен

    public UserSizes() {
    }

    public UserSizes(int pelvisWidth, int thighLength, int backHeight, int shinLength) {
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

    //ширина сиденья
    public int findSeatWidth() {
        int seatWidth = pelvisWidth + 4;
        if (seatWidth <= 22) {
            seatWidth = 22;
        }
        if (seatWidth > 22 && seatWidth <= 24) {
            seatWidth = 24;
        }
        if (seatWidth > 24 && seatWidth <= 26) {
            seatWidth = 26;
        }
        if (seatWidth > 26 && seatWidth <= 28) {
            seatWidth = 28;
        }
        if (seatWidth > 28 && seatWidth <= 30) {
            seatWidth = 30;
        }
        if (seatWidth > 30 && seatWidth <= 32) {
            seatWidth = 32;
        }
        if (seatWidth > 32 && seatWidth <= 34) {
            seatWidth = 34;
        }
        if (seatWidth > 34) {
            seatWidth = 36;
        }
        return seatWidth;
    }

    //глубина сиденья
    public int findSeatDepth() {
        int seatDepth = thighLength - 2;
        if (seatDepth <= 24) {
            seatDepth = 24;
        }
        if (seatDepth> 24 && seatDepth <= 26) {
            seatDepth = 26;
        }
        if (seatDepth> 26 && seatDepth <= 28) {
            seatDepth = 28;
        }
        if (seatDepth> 28 && seatDepth <= 30) {
            seatDepth = 30;
        }
        if (seatDepth> 30 && seatDepth <= 32) {
            seatDepth = 32;
        }
        if (seatDepth> 32 && seatDepth <= 34) {
            seatDepth = 34;
        }
        if (seatDepth> 34 && seatDepth <= 36) {
            seatDepth = 36;
        }
        if (seatDepth> 36 && seatDepth <= 38) {
            seatDepth = 38;
        }
        if (seatDepth> 38) {
            seatDepth = 40;
        }
        return seatDepth;
    }
    //длинна подножки
    public int findFootrestLength() {
        int footrestLength = shinLength;
        if (shinLength <= 40) {
            footrestLength = 40;
        }
        if (shinLength > 40 && shinLength <= 47) {
            footrestLength = 41;
        }
        if (shinLength > 47) {
            footrestLength = 42;
        }
        return footrestLength;

    }

    public int getPelvisWidth() {
        return pelvisWidth;
    }

    public void setPelvisWidth(int pelvisWidth) {
        this.pelvisWidth = pelvisWidth;
    }

    public int getThighLength() {
        return thighLength;
    }

    public void setThighLength(int thighLength) {
        this.thighLength = thighLength;
    }

    public int getBackHeight() {
        return backHeight;
    }

    public void setBackHeight(int backHeight) {
        this.backHeight = backHeight;
    }

    public int getShinLength() {
        return shinLength;
    }

    public void setShinLength(int shinLength) {
        this.shinLength = shinLength;
    }
}
