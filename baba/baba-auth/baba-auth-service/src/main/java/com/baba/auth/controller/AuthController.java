package com.baba.auth.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表，所有登录CRM系统的员工账号都存储在此表 前端控制器
 * </p>
 *
 * @author xiechao
 * @since 2020-04-14
 */
@RestController
@RequestMapping("/auth")
public class AuthController {



    @GetMapping("{id}")
    public ResponseEntity<String> queryUserById(@PathVariable("id")String id){
        System.out.println("12343");
        return ResponseEntity.ok("123");
    }


}
