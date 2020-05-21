package com.baba.test.controller;


import com.baba.test.config.JwtProperties;
import com.baba.test.entity.UserInfo;
import com.baba.test.service.AuthService;
import com.baba.test.utils.CookieUtils;
import com.baba.test.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


    @Autowired
    private AuthService authService;

    @Autowired
    private JwtProperties prop;

    @PostMapping("accredit")
    public ResponseEntity<Void> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest req, HttpServletResponse resp) {
        // 登录
        String token = this.authService.login(username, password);
        // 判断token
        if (StringUtils.isBlank(token)) {
            // 返回401
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        // 写入cookie中
        CookieUtils.setCookie(req, resp, prop.getCookieName(), token, true);

        // 返回200
        return ResponseEntity.ok().build();
    }

    @GetMapping("verify")
    public ResponseEntity<UserInfo> verify(
            @CookieValue("BABA_TOKEN") String token,
            HttpServletRequest req, HttpServletResponse resp) {
        // 解析token
        try {
            // 校验token
            UserInfo info = JwtUtils.getInfoFromToken(token, prop.getPublicKey());
            // 刷新token
            String newToken = JwtUtils.generateToken(info, prop.getPrivateKey(), prop.getExpire());
            // 写入cookie
            CookieUtils.setCookie(req, resp, prop.getCookieName(), newToken, true);
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            // 返回401
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


}
