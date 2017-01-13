package me.lishuo.repository;

import me.lishuo.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by lis on 17/1/10.
 */
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByName(String name);

}
