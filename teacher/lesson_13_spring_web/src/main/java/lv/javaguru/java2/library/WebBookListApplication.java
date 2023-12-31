package lv.javaguru.java2.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import lv.javaguru.java2.library.console_ui.ProgramMenu;
import lv.javaguru.java2.library.web_ui.config.SpringWebConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class WebBookListApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebConfiguration.class);

//		ProgramMenu programMenu = context.getBean(ProgramMenu.class);
//		while (true) {
//			programMenu.print();
//			int menuNumber = programMenu.getMenuNumberFromUser();
//			programMenu.executeSelectedMenuItem(menuNumber);
//		}
	}

}
