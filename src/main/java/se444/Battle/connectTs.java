package se444.Battle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
 
@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class connectTs {
 
    @RequestMapping("/")
    String hello() {
        return "Connecttion Success";
    }
 
    public static void main(String[] args) throws Exception {
        //This one Static Method allows our �App� 
        // to be deployed to a Servlet Container that
        // has already been created and run by Spring
        SpringApplication.run(connectTs.class, args);
    }
}
