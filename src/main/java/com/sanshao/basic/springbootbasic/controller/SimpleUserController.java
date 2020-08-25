package com.sanshao.basic.springbootbasic.controller;

import com.sanshao.basic.springbootbasic.domain.SimpleUser;
import com.sanshao.basic.springbootbasic.service.SimpleUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户管理相关接口")
public class SimpleUserController {

    @Autowired
    SimpleUserService simpleUserService;

    @PostMapping("/simpleuser")
    public SimpleUser addSimpleUser(@RequestBody SimpleUser simpleUser) {
        return simpleUserService.addUser(simpleUser);
    }

    @DeleteMapping("/simpleuser/{id}")
    public boolean deleteSimpleUser(@PathVariable(name = "id") Long id) {
        return simpleUserService.deleteUser(id);

    }

    @PutMapping("/simpleuser")
    public boolean updateSimpleUser(@RequestBody SimpleUser simpleUser) {
        return simpleUserService.updateUser(simpleUser);
    }


    @GetMapping("/simpleuser/{id}")
    public SimpleUser getSimpleUsers(@PathVariable(value = "id") long id) {
        return simpleUserService.getSimpleUser(id);
    }


    @GetMapping("/simpleuser")
    @ApiOperation("分页获取用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", defaultValue = "sanshao" , required = true),
            @ApiImplicitParam(name = "page", value = "页数", defaultValue = "0", required = true),
            @ApiImplicitParam(name = "size", value = "大小", defaultValue = "3", required = true)
    })
    public List<SimpleUser> getSimpleUsers(@RequestParam(value = "name") String name, @RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {
        return simpleUserService.getSimpleUsers(name, page, size);
    }


}
