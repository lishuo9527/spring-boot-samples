package me.lishuo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lis on 17/1/5.
 */

@Controller
@RequestMapping("/springmvc")
@ResponseBody
public class SpringMVCController {

    @RequestMapping(method = RequestMethod.GET)
    public String testGet() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "hello, spring-boot & springmvc!");
        return jsonObject.toString();
    }

}
