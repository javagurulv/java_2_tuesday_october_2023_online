package lv.avangardteen;

import lv.avangardteen.dependency_injection.ApplicationContext;
import lv.avangardteen.dependency_injection.DIApplicationContextBuilder;

public class OrderListApplication {
    private static ApplicationContext applicationContext =
            new DIApplicationContextBuilder().build("lv.avangardteen");
}
