package me.lishuo;

import me.lishuo.service.TestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * Created by lis on 17/1/9.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Resource
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Result -> " + testService.testQryName());
    }
}
