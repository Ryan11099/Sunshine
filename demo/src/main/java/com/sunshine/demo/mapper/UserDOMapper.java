package com.sunshine.demo.mapper;

import com.sunshine.demo.pojo.UserDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserDOMapper extends Mapper<UserDO> {
}