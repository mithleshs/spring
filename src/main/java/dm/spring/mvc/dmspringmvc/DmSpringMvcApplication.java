package dm.spring.mvc.dmspringmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dm.spring.mvc.dmspringmvc")
public class DmSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmSpringMvcApplication.class, args);
	}
}
