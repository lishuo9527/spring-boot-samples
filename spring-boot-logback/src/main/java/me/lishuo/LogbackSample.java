package me.lishuo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * Created by lis on 17/1/9.
 */
@SpringBootApplication
public class LogbackSample {

    private static final Logger logger = LoggerFactory.getLogger(LogbackSample.class);

    @PostConstruct
    public void testLog() {
        logger.debug("Sample Debug Message");
        logger.error("Sample Error Message");
    }

    // java -jar xxx.jar --spring.profiles.active=prod
    public static void main(String[] args) throws Exception {
        SpringApplication.run(LogbackSample.class, args);
    }

}
