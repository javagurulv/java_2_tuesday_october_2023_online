package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import java.util.List;

public class RemoveIngridientResponse{

        private boolean ingridientRemoved;


        public  RemoveIngridientResponse ( boolean ingridientRemoved){
                this.ingridientRemoved=ingridientRemoved;

        }
        public boolean isIngridientRemoved() {
                return ingridientRemoved;
        }
}
