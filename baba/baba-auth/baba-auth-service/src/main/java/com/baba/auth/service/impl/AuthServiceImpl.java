package com.baba.auth.service.impl;



import com.baba.auth.config.JwtProperties;
import com.baba.auth.entity.UserInfo;
import com.baba.auth.service.AuthService;
import com.baba.auth.utils.JwtUtils;
import com.baba.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * @author: HuYi.Zhang
 * @create: 2018-07-07 18:01
 **/
@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtProperties prop;

//    @Autowired
//    private UserClient userClient;

    public String login(String username, String password) {
        try {
//            // 校验用户名密码
//            User user = this.userClient.queryUserByUsernameAndPassword(username, password);

//            if (user == null) {
//                return null;
//            }
            // 生成token
//            UserInfo userInfo = new UserInfo();
//            userInfo.setId(user.getId());
//            userInfo.setUsername(user.getUsername());
//            String token = JwtUtils.generateToken(userInfo, prop.getPrivateKey(), prop.getExpire());

            UserInfo userInfo = new UserInfo();
            userInfo.setId(123456L);
            userInfo.setUsername("xiechao");
            String token = JwtUtils.generateToken(userInfo, prop.getPrivateKey(), prop.getExpire());

            // 返回
            return token;
        } catch (Exception e) {
            return null;
        }
    }
}

