package cakeCake;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Cake {
    private String type;
    private String colour;



    public Cake (String type, String colour){
        this.type=type;
        this.colour=colour;
    }

}
