package com.dcl.accommodate;

import com.dcl.accommodate.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Duration;
import java.util.Map;

@SpringBootApplication
@EnableJpaAuditing
public class AccommodationMarketplaceApplication {
    @Autowired
    private JwtService jwtService;


	public static void main(String[] args) {

        var context= SpringApplication.run(AccommodationMarketplaceApplication.class, args);
        var app= context.getBean(AccommodationMarketplaceApplication.class);

        Map<String,Object> claims=Map.of(
                "email","abc@gmail.com",
                "role" ,"HOST"
        );

        var token = app.jwtService.generateToken(claims,"abc", Duration.ofHours(1));
        System.out.println(token);



	}

}
