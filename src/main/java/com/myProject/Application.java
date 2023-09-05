package com.myProject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

	@EventListener({ApplicationReadyEvent.class})
	private static void openPage() throws IOException {
		Runtime rt = Runtime.getRuntime();
		rt.exec("rundll32 url.dll,FileProtocolHandler " + "http:/localhost:8080/pre_join");
		//rt.exec("rundll32 url.dll,FileProtocolHandler " + "http:/localhost:8080/login");
	}

	@Configuration
	public class MvcConfig implements WebMvcConfigurer {
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/static/**")
					.addResourceLocations("classpath:/static/");
		}


	}


	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Application.class, args);


		List<String> fd = new ArrayList<String>();
		fd.add("txt1");
		fd.add("txt2");
		fd.add("txt3");

		Stream<Integer> fx;


	}

}
