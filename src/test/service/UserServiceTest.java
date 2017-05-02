package service;

import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.model.enumstatus.user.UserStatus;
import cn.jinelei.live.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jinelei on 17-5-2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml", "classpath*:config/live-servlet.xml", "classpath*:config/servlet-websocket-config.xml"})
public class UserServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void test() {
        try {
            assert userService != null;
            User user = userService.getUserInfo("jinelei");
            System.out.println(user.getUserStatus());
            user.setUserStatus(user.getUserStatus() | Integer.valueOf(UserStatus.LOCKED.toString()));
            userService.updateUser(user);
            System.out.println(userService.getUserInfo("jinelei").getUserStatus());
            user.setUserStatus(user.getUserStatus() & (~Integer.valueOf(UserStatus.LOCKED.toString())));
            System.out.println(userService.getUserInfo("jinelei").getUserStatus());
//            userService.deleteUser(user);
//            System.out.println(userService.getUserInfo("jinelei"));
//            System.out.println("all user");
//            userService.getAllUser().forEach(u -> System.out.println(u.getUsername() + "\t" + u.getUserStatus() ));
//            System.out.println("all delete user");
//            userService.getAllUserDelete().forEach(u -> System.out.println(u.getUsername() + "\t" + u.getUserStatus() ));
//            System.out.println("all alive user");
//            userService.getAllUserAlive().forEach(u -> System.out.println(u.getUsername() + "\t" + u.getUserStatus() ));
//            System.out.println("all active user");
//            userService.getAllUserActive().forEach(u -> System.out.println(u.getUsername() + "\t" + u.getUserStatus() ));
//            System.out.println("all inactive user");
//            userService.getAllUserInactive().forEach(u -> System.out.println(u.getUsername() + "\t" + u.getUserStatus() ));
//            System.out.println("all offline user");
//            userService.getAllUserOffline().forEach(u -> System.out.println(u.getUsername() + "\t" + u.getUserStatus() ));
//            System.out.println("all online user");
//            userService.getAllUserOnline().forEach(u -> System.out.println(u.getUsername() + "\t" + u.getUserStatus() ));


        } catch (UserException e) {
            e.printStackTrace();
        }
    }
}
