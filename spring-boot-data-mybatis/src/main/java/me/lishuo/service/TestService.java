package me.lishuo.service;

import me.lishuo.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lis on 17/1/10.
 */
@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public String testQryName(){
        return testMapper.selectNameById(1);
    }

}
