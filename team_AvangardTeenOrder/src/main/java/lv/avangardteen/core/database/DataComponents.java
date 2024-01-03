package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Category;
import lv.avangardteen.core.domain.Components;

import java.util.List;

public interface DataComponents {
    void addCategory(Category category);
    List<Category> getCategories();
    void addComponent(String categoryTitle,String marking, String information, Double price);
    List<Components> getAllComponents();
    Components getComponent(Integer index);
    List<Integer> getAllIndex();
    List<Components> allFrontWheels();
    List<Components> allFootrest();
    List<Components> allBrakes();
    List<Components> allBackWheels();


}
