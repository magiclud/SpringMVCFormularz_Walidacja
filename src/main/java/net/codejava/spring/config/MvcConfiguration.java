package net.codejava.spring.config;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "net.codejava.spring")
//@PropertySource("classpath:/message_en.properties")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

//	@Bean
//	public PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}

	@Bean
	public ViewResolver getViewResolver() {
		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYY"
				+ this.getClass().getName());
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
		registry.addResourceHandler("/assets/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/css/**").addResourceLocations("/css/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/")
				.setCachePeriod(31556926);
	}

	
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		super.addViewControllers(registry);
		registry.addViewController("login/form").setViewName("login");		
		registry.addViewController("welcome").setViewName("welcome");
		registry.addViewController("admin").setViewName("admin");
	}
	@Bean(name = "messageSource")
	public MessageSource configureMessageSource()
	{
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:message_en");
		messageSource.setCacheSeconds(5);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver()
	{
		SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.put("org.springframework.dao.DataAccessException", "error");
		b.setExceptionMappings(mappings);
		return b;
	}
}
