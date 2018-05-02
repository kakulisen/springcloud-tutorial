package com.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class Application {

    public static void main(String[] args){

    //    SpringApplication.run(Application.class,args);

        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }


}
