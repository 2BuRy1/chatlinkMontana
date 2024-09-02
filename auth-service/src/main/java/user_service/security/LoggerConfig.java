package user_service.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class LoggerConfig {


    @Bean
    public Logger logger() {
        Logger logger = Logger.getLogger(LoggerConfig.class.getName());
        logger.setLevel(Level.INFO);

//        ConsoleHandler consoleHandler = new ConsoleHandler();
//        consoleHandler.setLevel(Level.INFO);
//
//        logger.addHandler(consoleHandler);

        return logger;
    }



}
