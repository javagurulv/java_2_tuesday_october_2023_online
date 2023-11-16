package fitness_club.dependency_injection;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


class ClassFinderTest {

    @Test
    void findClassesInsidePackage() throws IOException, ClassNotFoundException {
        ClassFinder classFinder = new ClassFinder();
        List<Class> classes = classFinder.findClassesInsidePackage("fitness_club");
        classes.forEach(aClass -> {
            System.out.println(aClass.getName());
        });
    }
}