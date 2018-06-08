package dm.spring.mvc.dmspringmvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * If you don't want to define view prefix and suffix mapping in
 * application.properties then use this class otherwise delete this class
 * because by default spring boot will look mapping in application.properties
 * file if no mapping found there then it will look for
 * annotation @Configuration .
 *
 * @author mithleshs
 * @version 1.0
 * @since Jun 4, 2018
 */

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = "dm.spring.mvc.dmspringmvc")
public class DmAppConfiguration {

	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/jsp/");
		bean.setSuffix(".jsp");
		return bean;
	}
}
