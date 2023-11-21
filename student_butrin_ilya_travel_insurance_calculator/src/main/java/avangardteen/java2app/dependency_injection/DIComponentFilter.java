package avangardteen.java2app.dependency_injection;

import java.util.List;
import java.util.stream.Collectors;

public class DIComponentFilter {
    public List<Class> filter(List<Class> classes){
        List<Class>filter = classes.stream().filter(p->p.isAnnotationPresent(DIComponent.class)).collect(Collectors.toList());
        return filter;
    }
}
