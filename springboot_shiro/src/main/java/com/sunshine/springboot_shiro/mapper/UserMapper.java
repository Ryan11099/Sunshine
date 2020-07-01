package com.sunshine.springboot_shiro.mapper;

import com.sunshine.springboot_shiro.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yanjh
 * @date 2020/7/1 20:49
 */
@Mapper
public interface UserMapper {

     User findByName(String name);

     User findById(Integer id);
}
