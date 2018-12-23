package e.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import e.model.Bike;
import e.model.Honda;

@Configuration
public class HondaConfig {
    @Bean
    public Bike honda() {
        return new Honda();
    }
}
