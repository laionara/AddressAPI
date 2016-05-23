/**
 * 
 */
package com.github.addressapi.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.github.addressapi.controller.AddressController;
import com.github.addressapi.dao.AddressDAO;
import com.github.addressapi.service.AddressService;
import com.github.addressapi.validation.AddressValidator;
import com.mysql.cj.fabric.Response;

/**
 * @author layonara
 *
 */
@EnableWebMvc
@ComponentScan(basePackageClasses={AddressController.class, AddressDAO.class, AddressValidator.class, AddressService.class, Response.class})
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/messages.properties");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		return bundle;
	}
}
