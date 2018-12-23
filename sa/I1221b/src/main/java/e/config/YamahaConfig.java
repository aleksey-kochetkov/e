package e.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import e.model.Bike;
import e.model.Yamaha;

@Configuration
public class YamahaConfig {
    @Bean
    public Bike yamaha() {
        return new Yamaha();
    }
}
