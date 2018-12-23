package e.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Bean;
import e.model.Bike;
import e.model.Rider;

@Configuration
@Import({HondaConfig.class, BajajConfig.class, YamahaConfig.class})
public class Config {

    @Bean
    public Rider one(Bike honda) {
        return new Rider("one", honda);
    }

    @Bean
    public Rider two(Bike bajaj) {
        return new Rider("two", bajaj);
    }

    @Bean
    public Rider three(Bike yamaha) {
        return new Rider("three", yamaha);
    }
}
