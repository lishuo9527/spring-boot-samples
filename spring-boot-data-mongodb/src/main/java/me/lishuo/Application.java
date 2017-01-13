package me.lishuo;

import me.lishuo.entity.Person;
import me.lishuo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * Created by lis on 17/1/10.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Resource
    private PersonRepository personRepository;

    @Override
    public void run(String... strings) throws Exception {
//        personRepository.deleteAll();

        // save a couple of customers
        personRepository.save(new Person("Alice", "XXX", 1));
        personRepository.save(new Person("Bob", "XXX", 2));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Person person : personRepository.findAll()) {
            System.out.println(person);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
