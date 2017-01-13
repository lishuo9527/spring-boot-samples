package me.lishuo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by lis on 17/1/6.
 */
@Component
@Path("/jersey")
public class JerseyController {

    @GET
    public String testJersey() {
        return "Hello Jersey.";
    }

}
