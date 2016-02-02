package be.cegeka.config;

import be.cegeka.rules.OverpopulationRule;
import be.cegeka.rules.ReproductionRule;
import be.cegeka.rules.SustenanceRule;
import be.cegeka.rules.UnderpopulationRule;
import be.cegeka.world.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fransg on 02/02/16.
 */
@Configuration
public class EngineConfig {

    @Bean
    public Engine engine(){
        Engine engine = new Engine();
        engine.addRules(new OverpopulationRule(), new ReproductionRule(), new SustenanceRule(), new UnderpopulationRule());
        return engine;
    }
}
