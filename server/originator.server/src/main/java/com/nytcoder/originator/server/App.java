package com.nytcoder.originator.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.nytcoder" })
@EntityScan("com.nytcoder")
@EnableJpaRepositories({ "com.nytcoder" })
public class App extends SpringBootServletInitializer {
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }



	public static void initiateShutdown(ApplicationContext applicationContext, int returnCode) {
		SpringApplication.exit(applicationContext, () -> returnCode);
	}

}

