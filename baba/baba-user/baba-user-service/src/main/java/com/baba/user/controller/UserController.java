package com.baba.user.controller;


import com.baba.user.pojo.User;
import com.baba.user.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 用户表，所有登录CRM系统的员工账号都存储在此表 前端控制器
 * </p>
 *
 * @author xiechao
 * @since 2020-04-14
 */
@RestController
@RequestMapping("user")//如果整个工程controller下面都不配置@RequestMapping("user")名称的话，那么swagger.html页面都打不开
//@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    //还需要如下的方法：
//    传入组织机构ID，获取指定机构下的用户列表？？？？？？？？？？？还带有用户名及用户查询参数
//    传入组织机构ID，获取指定机构及子孙机构下的用户列表？？？？？？？？？？？还带有用户名查询参数

    @GetMapping("{id}")
    @ApiOperation(value = "根据用户ID查询用户，返回用户对象", notes = "查询用户")
    @ApiImplicitParam(name = "id", dataType ="String", required = true, value = "用户的ID")
    //注意返回User对象，在swagger里面可以直接看到此User模型
    public ResponseEntity<User> queryUserById(@PathVariable("id")String id){
        List list = new ArrayList();

        User user = userService.getById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping("base-result-map/{id}")
    @ApiOperation(value = "从xml文件中加载sql语句，根据用户ID查询用户，返回用户对象", notes = "查询用户")
    @ApiImplicitParam(name = "id", dataType ="String", required = true, value = "用户的ID")
    //注意返回User对象，在swagger里面可以直接看到此User模型
    public ResponseEntity<User> queryUserByIdFromXmlReturnBaseResultMap(@PathVariable("id")String id){
        User user = userService.queryUserByIdFromXmlReturnBaseResultMap(id);
        if(user == null){
            return ResponseEntity.notFound().build();
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping("hash-result-map/{id}")
    @ApiOperation(value = "从xml文件中加载sql语句，根据用户ID查询用户，返回用户对象", notes = "查询用户")
    @ApiImplicitParam(name = "id", required = true, value = "用户的ID")
    public ResponseEntity<Object> queryUserByIdFromXmlReturnHashMap(@PathVariable("id")String id){
        List<HashMap<Object, Object>> list = userService.queryUserByIdFromXmlReturnHashMap(id);
        if(CollectionUtils.isEmpty(list)){
            return ResponseEntity.notFound().build();
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(list);
    }

    /**
     * 分页查询当前用户列表
     * @param pageNum 页码
     * @param pageSize 每页数据量大小
     * @return
     */
    @GetMapping("list")
    @ApiOperation(value = "分页查询当前用户列表，并且可以根据用户状态过滤", notes = "分页查询用户列表")
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

    /**
     * 分页查询当前用户列表
     * @param pageNum 页码
     * @param pageSize 每页数据量大小
     * @return
     */
    @GetMapping("list/from-xml-sql")
    @ApiOperation(value = "分页查询当前用户订单，并且可以根据订单状态过滤", notes = "分页查询当前用户订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", defaultValue = "1", type = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", defaultValue = "5", type = "Integer"),
            @ApiImplicitParam(name = "userType", value = "用户类型：1：超级管理员，2：区域管理员，3：分校管理员，4：部门管理员，5：销售人员，6：普通用户，7：代理商用户", type = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "用户的分页结果"),
            @ApiResponse(code = 404, message = "没有查询到结果"),
            @ApiResponse(code = 500, message = "查询失败")
    })
    public ResponseEntity<IPage<User>> queryUserListFromXmlSql(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize,
            @RequestParam(value = "userType", defaultValue = "1") String userType) {
        IPage<User> result = userService.queryUserListFromXmlSql(pageNum, pageSize, userType);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

//    /**
//     * 既传page对象，又传paramMap对象，使用mybatis plus原生支持的分页，是不行的
//     * 这种方式对代码侵入太高了，有时间，把PageHelper集成进来，原生分页使用mybatis plus的Ipage，自定义分页sql语句使用PageHelper
//     * @param pageNum 页码
//     * @param pageSize 每页数据量大小
//     * @return
//     */
//    @GetMapping("list/from-xml-param-map-sql")
//    @ApiOperation(value = "分页查询当前用户订单，并且可以根据订单状态过滤", notes = "分页查询当前用户订单")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageNum", value = "当前页", defaultValue = "1", type = "Integer"),
//            @ApiImplicitParam(name = "pageSize", value = "每页大小", defaultValue = "5", type = "Integer"),
//            @ApiImplicitParam(name = "userType", value = "用户类型：1：超级管理员，2：区域管理员，3：分校管理员，4：部门管理员，5：销售人员，6：普通用户，7：代理商用户", type = "String")
//    })
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "用户的分页结果"),
//            @ApiResponse(code = 404, message = "没有查询到结果"),
//            @ApiResponse(code = 500, message = "查询失败"),
//    })
//    public ResponseEntity<IPage<User>> queryUserListFromXmlParamMapSql(
//            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
//            @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize,
//            @RequestParam(value = "userType", required = true) String userType) {
//        Map<Object, Object> paramMap = new HashMap<>();
//        paramMap.put("userType", userType);
//
//        //IPage<User> result = userService.queryUserListFromXmlParamMapPageSql(pageNum, pageSize, paramMap);
//        if (result == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(result);
//    }
}
