package flower.flowercontinue.flower;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FlowerConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            FlowerRepository repository) {
        return args -> {
            Flower tulip = new Flower(
                    2.5,
                    FlowerColor.BLUE,
                    25.40,
                    FlowerType.TULIP
            );
            Flower rose = new Flower(
                    1.3,
                    FlowerColor.RED,
                    34.85,
                    FlowerType.ROSE
            );

            repository.saveAll(
                    List.of(tulip, rose)
            );
        };
    }
}
