package com.example.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class MyAppInitializer implements WebApplicationInitializer {
	
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(MyAppConfig.class);
        appContext.refresh();

        ServletRegistration.Dynamic registration = servletContext.addServlet("MyApp", new DispatcherServlet(appContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("/v1/*");
	}
}
