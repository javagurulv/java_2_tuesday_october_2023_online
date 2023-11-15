package lv.avangardteen.dependency_injection;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassFinderTest {

    @Test
    public void findClass() throws IOException, ClassNotFoundException {
       ClassFinder classFinder = new ClassFinder();
        List<Class> classes = classFinder.findClassesInsidePackage("lv.avangardteen");
        classes.forEach(aClass -> {
            System.out.println(aClass.getName());
        });

    }
}