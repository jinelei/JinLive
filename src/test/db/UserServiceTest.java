import cn.jinelei.live.dao.UserMapper;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.model.enumstatus.user.UserStatus;
import cn.jinelei.live.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by jinelei on 17-4-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/live-servlet.xml", "classpath:spring-config.xml"})
@WebAppConfiguration
public class UserServiceTest {
    //    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
//
    @Autowired
    private UserService userService;
//
//    @Test
//    public void register1() throws UserException {
//        User user = new User();
//        user.setUserName("consoletest4");
//        user.setUserNickname("consoletest1");
//        user.setUserSex(1);
//        user.setUserAge(22);
//        user.setUserPhone("13100000000");
//        user.setUserHeight(180);
//        user.setUserWeight(135);
//        user.setUserArea(111111);
//        user.setUserStatus(1);
//        user.setUserTreasure(50000);
//        user.setUserPasswd("jin");
//        user.setUserEmail("consoletest1@163.com");
//        User user1 = userService.register(user);
//        logger.debug(String.valueOf(user1));
//    }
//
//    @Test
//    public void register2() throws UserException {
//        User user = new User();
//        user.setUserName("consoletest2");
//        user.setUserNickname("consoletest2");
//        user.setUserSex(1);
//        user.setUserAge(22);
//        user.setUserPhone("13100000000");
//        user.setUserHeight(180);
//        user.setUserWeight(135);
//        user.setUserArea(111111);
//        user.setUserPasswd("jin");
//        user.setUserEmail("consoletest1@163.com");
//        User user1 = userService.register(user);
//        logger.debug(String.valueOf(user1));
//    }
//
//    @Test
//    public void register3() throws UserException {
//        User user = new User();
//        user.setUserName("consoletest3");
//        user.setUserSex(1);
//        user.setUserAge(22);
//        user.setUserPasswd("jin");
//        User user1 = userService.register(user);
//        logger.debug(String.valueOf(user1));
//    }
//
//    @Test
//    public void login() {
//        logger.debug(String.valueOf(userService.verifyUser("consoletest4", "jin")));
//        logger.debug(String.valueOf(userService.verifyUser("consoletest0", "jin")));
//    }
//
//    @Test
//    public void getUserInfo() throws UserException {
//        User user2 = userService.getUserInfo("consoletest4");
//        logger.debug(String.valueOf(user2));
//    }
//
//    @Test
//    public void updateUser() throws UserException {
//        User user = userService.getUserInfo("consoletest4");
//        user.setUserNickname("changeNickname1");
//        user.setUserAge(33);
//        userService.updateUser(user);
//    }
//
//    @Test
//    public void deleteUser() throws UserException {
//        User user = userService.getUserInfo("consoletest4");
//        userService.deleteUser(user);
//    }
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    public void getAll() {
//
////        List<User> userList = userService.getAllUser();
//        userService.getAllUserAlive().forEach(user -> System.out.println(user));
//        userService.getAllUserOnline().forEach(user -> System.out.println(user));
//        userService.getAllUserOffline().forEach(user -> System.out.println(user));
//        userService.getAllUserActive().forEach(user -> System.out.println(user));
//        userService.getAllUserInactive().forEach(user -> System.out.println(user));
//        userService.getAllUserDelete().forEach(user -> System.out.println(user));
//
//        userService.getAllUser(0, 2).forEach(user -> System.out.println(user));
//
//        System.out.println(userService.getAllUserPageInfo());
//    }

//    @Test
//    public void test() throws UserException {
//        User user = userService.getUserInfo("jinelei");
//
//        assert user.getUserStatus() instanceof Integer;
//        assert Integer.valueOf(UserStatus.EXPIRED.ordinal()) instanceof Integer;
//        System.out.println(user.getUserStatus());
//        System.out.println(UserStatus.EXPIRED.toString());
//        System.out.println(user.getUserStatus() & Integer.valueOf(UserStatus.EXPIRED.toString()));
//    }

}
