package fitness_club.dependency_injection;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DIComponentFilterTest {

    @Test
    void filter() throws IOException, ClassNotFoundException {
        ClassFinder finder = new ClassFinder();
        DIComponentFilter filter = new DIComponentFilter();
        List<Class> classList = finder.findClassesInsidePackage("fitness_club");
        List<Class> diComponent = filter.filter(classList);
        diComponent.forEach(aClass -> {
            System.out.println(aClass.getName());
        });
    }
}