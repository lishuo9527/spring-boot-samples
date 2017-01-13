package me.lishuo.controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by lis on 17/1/6.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(JerseyController.class);
    }
}
