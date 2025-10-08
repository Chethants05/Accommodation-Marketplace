package com.dcl.accommodate.Config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppEnv {

    @NestedConfigurationProperty
    private Jwt jwt;  // this must be an object, not String

    @Getter
    @Setter
    public static class Jwt {
        private String key;  // maps to app.jwt.key
    }
}


