package cn.jinelei.live.utils.user;

import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by jinelei on 17-4-10.
 */

public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public MyUserDetailsService(UserService userService) {
//        System.out.println("myserdetailsservice construct: " + userService);
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
//            System.out.println(userService);
            User user = userService.getUserInfo(s);
            System.out.println(user.toString());
            return user;
        } catch (UserException e) {
            throw new UsernameNotFoundException("username not found");
        }
    }
}
