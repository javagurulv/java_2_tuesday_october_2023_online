package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import java.util.List;

public class RemoveIngredientResponse extends CoreResponse{

        private boolean ingredientRemoved;

        public RemoveIngredientResponse(List<CoreError> errors) {
                super(errors);
        }

        public RemoveIngredientResponse(boolean ingredientRemoved) {
                this.ingredientRemoved = ingredientRemoved;
        }

        public boolean isIngredientRemoved() {
                return ingredientRemoved;
        }
}
