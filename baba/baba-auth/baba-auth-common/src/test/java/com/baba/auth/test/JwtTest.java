package com.baba.auth.test;

import com.baba.auth.entity.UserInfo;
import com.baba.auth.utils.JwtUtils;
import com.baba.auth.utils.RsaUtils;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

/**
 * @Author: 98050
 * @Time: 2018-10-23 20:58
 * @Feature: JWT测试
 */
public class JwtTest {

    private static final String pubKeyPath = "E:\\baba\\rsa\\rsa.pub";

    private static final String priKeyPath = "E:\\baba\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testDate() {
        System.out.println(System.currentTimeMillis());;
        System.out.println(DateTime.now().plusMinutes(1).toDate().getTime());
        System.out.println(DateTime.now().plusMinutes(1).toDate());

        ;
    }


    @Test
    public void testRsa() throws Exception {
        //生成公钥与私钥
        //第一次运行，请将下面的@Before方法注掉
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    //供下面的方法测试的前置条件
    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    //生成tokean
    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
//        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU0MDMwMjU4MX0.KFGDe8V8TwLl5xGqM1brPV50JXf3Z6G4cXPIeYxsqaeeol06BnXNNsyLAbUSrFxloUf-hQqO41O1OrtERllU-JfZXs6MA6rTBSfpar2MJRSZyDGKqfBpPoRED3yZv8oFuzI_94GONqsipmGyQFqWUkhTf9k0tZ5LPRvvGl9tkvc";
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU5MDI4NTc5OX0.KsEiP_PX5cvrIoA2szm1PdhjMJdWH6jdHmlSE5KP2J1icjqPlTRGxjQsQJFxM_8iIjSL_f2piYslcDKt9G4yT5aa28FFstCsH_pEqOIx1kqT2eYmIASWS5kvfmrGmBOcYF8CKw-gFmOQ9myWXQ_T4jFP4OLYAP6RM0uLXMpYCOk";
        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }

    @Test
    public void date(){
        System.out.println(new Date());
    }
}