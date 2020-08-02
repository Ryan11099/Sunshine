package com.sunshine.demo.controller;

import com.sunshine.demo.pojo.UserDO;
import com.sunshine.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanjh
 * @date 2020/7/28 21:27
 */
@RestController
@RequestMapping("/api/news")
@Api(tags = {"用户消息通知管理"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/get_list")
    @ApiOperation(value = "获取消息通知列表", notes = "")
    public int getNewsList(@ApiParam(name = "", value = "传入json格式", required = false) @RequestBody UserDO param) {
        int insert = userService.insert(param);
        return insert;
    }

}
