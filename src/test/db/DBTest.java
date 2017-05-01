import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jinelei on 17-4-12.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:config/live-servlet.xml", "classpath:spring-config.xml"})
public class DBTest {

//    @Autowired
//    UserService userService;
//
//    @Test
//    public void userService() {
//        assert userService != null;
//    }
//
//    @Test
//    public void registerUser(){
//        User user=null;
////        第一次注册成功
//        try {
//            user = userService.register("testusername","testusernickname",1,22,"17155555555",180,65,000000,"asdfasdf","j@163.com");
//            assert user != null;
//        } catch (UserException e) {
//            System.out.println(e.getMessage());
//        }
////        第二次注册失败
//        try {
//            userService.register("testusername","testusernickname",1,22,"17155555555",180,65,000000,"asdfasdf","j@163.com");
//        } catch (UserException e) {
//            System.out.println(e.getMessage());
//
//        }
////        查询用户
//        try {
//            User u1 = userService.getUserInfo(user.getUserId());
//            User u2 = userService.getUserInfo(user.getUserName());
//            User u3 = userService.getUserInfo(user);
//            assert u1.equals(u2);
//            assert u1.equals(u3);
//        } catch (UserException e) {
//            e.printStackTrace();
//        }
////        更新信息
//        try {
//            user.setUserNickname("asdfasdfasdf");
//            boolean res = userService.updateUser(user);
//            assert res == true;
//            if (res){
//                User tmp = userService.getUserInfo(user);
//                assert "asdfasdfasdf".equals(tmp.getUserNickname());
//            }
//        } catch (UserException e) {
//            e.printStackTrace();
//        }
////        删除用户
//        try {
//            boolean res = userService.deleteUser(user);
//            assert res == true;
//        } catch (UserException e) {
//            e.printStackTrace();
//        }
//    }
}
