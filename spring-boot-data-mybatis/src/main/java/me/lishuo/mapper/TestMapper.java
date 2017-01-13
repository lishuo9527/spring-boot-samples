package me.lishuo.mapper;

import org.apache.ibatis.annotations.Mapper;


/**
 * Created by lis on 17/1/9.
 */
@Mapper
public interface TestMapper {

    String selectNameById(long id);
}
