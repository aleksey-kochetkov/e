package e.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import e.model.Warehouse;
import e.model.Transfer;

@Configuration
@ComponentScan("e.model")
public class Config {

    @Bean
    public Warehouse fromWarehouse() {
        return new Warehouse("060", "Description 060");
    }

    @Bean
    public Warehouse toWarehouse() {
        return new Warehouse("000", "Description 000");
    }

    @Bean
    public Transfer one() {
        return new Transfer(1, this.fromWarehouse(), this.toWarehouse());
    }

    @Bean
    public Transfer two(Warehouse fromWarehouse, Warehouse toWarehouse) {
        return new Transfer(2, fromWarehouse, toWarehouse);
    }
}
