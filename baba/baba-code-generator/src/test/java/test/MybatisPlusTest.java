package test;

import com.baba.item.CodeGeneratorApplication;
import com.baba.item.mapper.UserMapper;
import com.baba.item.pojo.User;
import com.baba.item.service.UserService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author xiechao
 * @Date 2020/4/14 11:19
 * @Version 1.0.0
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CodeGeneratorApplication.class)
public class MybatisPlusTest {
    @Autowired
    UserMapper userMapper;

//    @Autowired
//    DictMapper dictMapper;

    @Autowired
    UserService userService;

//    @Test
//    public void testDictInsert(){
//        Dict dict = new Dict();
//        dict.setTag("customer_group");
//        dict.setTagName("客户分组");
//        dict.setRemark("此标签代表客户分组");
//        dict.setLevel(true);
//        dict.setAvailable(true);
//        dict.setIsEdit(true);
//        dict.setSortNum(1);
//        dict.setCreateById("xiechao");
////        dict.setCreateDateTime(LocalDateTime.now()); //新增时创建时间，已经采用自动补全的方案
//        dict.setUpdateById("xiechao");
////        dict.setUpdateDateTime(LocalDateTime.now());//新增时修改时间，已经采用自动补全的方案
//
//        dictMapper.insert(dict);
//    }
//
//    @Test
//    public void testDictUpdate(){
//        Dict dict = new Dict();
//        dict.setTagId("50ac687916fa2de0c259e9d5604e08c6");
//        dict.setSortNum(2);
////        dict.setCreateById("xiechao"); //以后采用补全方案，有时间再整
////        dict.setUpdateDateTime(LocalDateTime.now());//修改时，修改时间，已经采用自动初全的方案
//
//        dictMapper.updateById(dict);
//    }
//
//    @Test
//    public void testDictDelete(){
//        dictMapper.deleteById("1bd099d79689e44a82d01e896bd43054");
//    }


    @Test
    public void testUserInsert() {
        User user = new User();
        user.setUserName("老七");
        user.setAddress("天心区");
        user.setCompanyName("大立");
        user.setLoginName("lisi");
        user.setPassword("123456");
        user.setSalt("&*!@#");
        user.setDataScope(1);
        user.setUserType("1");
//        user.setCreateDateTime(LocalDateTime.now());
//        user.setUpdateDateTime(LocalDateTime.now());


        userMapper.insert(user);
    }

    @Test //主要测试没赋值的属性，会不会全库更新为null的问题
    public void testUpdateUser() {
        User user = new User();
        user.setUserId("03e5205e8899fcba680671b900bae271");
//        user.setUserName("谢超2");
        user.setPassword("88888888");
//        userMapper.updateById(user);

//        userMapper.update(user, new UpdateWrapper<>().eq("user_name", "谢超2")));
        userMapper.update(user, new UpdateWrapper<User>().eq("user_name", "谢超"));
    }

    @Test
    public void testDeleteUser() {
        userMapper.deleteById("03e5205e8899fcba680671b900bae271");
    }


    @Test
    public void testPageUser() {

    }

}
