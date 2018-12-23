package e.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import e.model.Bike;
import e.model.Bajaj;

@Configuration
public class ConfigBajaj {
    @Bean
    public Bike bajaj() {
        return new Bajaj();
    }
}
