package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Components;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OrmDataComponentsImpl implements DataComponents{

    private Integer nextId = 1;
    List<Components> components = new ArrayList<>();

    @Override
    public void addComponent(Components component) {
        component.setId(nextId);
        nextId++;
        components.add(component);
    }

    @Override
    public List<Components> getAllComponents() {
        return null;
    }

    @Override
    public Components getComponent(Integer index) {
        return null;
    }

    @Override
    public List<Integer> getAllIndex() {
        return null;
    }

    @Override
    public List<Components> allFrontWheels() {
        return null;
    }

    @Override
    public List<Components> allArmrest() {
        return null;
    }

    @Override
    public List<Components> allBrakes() {
        return null;
    }

    @Override
    public List<Components> allBackWheels() {
        return null;
    }


}
