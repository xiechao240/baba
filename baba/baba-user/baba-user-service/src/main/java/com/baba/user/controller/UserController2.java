package com.baba.user.controller;


import com.baba.user.pojo.User;
import com.baba.user.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表，所有登录CRM系统的员工账号都存储在此表 前端控制器
 * </p>
 *
 * @author xiechao
 * @since 2020-04-14
 */
@RestController
@RequestMapping("user")//
//@RequestMapping //不配置（“user”）这样的名称，会导致swagger.html页面打不开
public class UserController2 {

    @Autowired
    UserService userService;



    /**
     * 分页查询当前用户列表
     * @param pageNum 页码
     * @param pageSize 每页数据量大小
     * @return
     */
    @GetMapping("list2")
    @ApiOperation(value = "分页查询当前用户订单，并且可以根据订单状态过滤", notes = "分页查询当前用户订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", defaultValue = "1", type = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", defaultValue = "5", type = "Integer"),
            @ApiImplicitParam(name = "userType", value = "用户类型：1：超级管理员，2：区域管理员，3：分校管理员，4：部门管理员，5：销售人员，6：普通用户，7：代理商用户", type = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "用户的分页结果"),
            @ApiResponse(code = 404, message = "没有查询到结果"),
            @ApiResponse(code = 500, message = "查询失败"),
    })
    public ResponseEntity<IPage<User>> queryUserList(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize) {
        IPage<User> result = userService.queryUserList(pageNum, pageSize);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(result);
    }


}
