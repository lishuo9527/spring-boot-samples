package me.lishuo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lis on 17/1/6.
 */

public class TestJerseyController {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGet() {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/jersey",
                String.class);
        System.out.println(entity.getBody());
    }


}
