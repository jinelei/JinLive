package cn.jinelei.live.config.security;

import cn.jinelei.live.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinelei on 17-4-9.
 */
public class MyAuthenticationProvider implements AuthenticationProvider {
    private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationProvider.class);
    private static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        logger.debug(String.format("username: %s\tpassword: %s", username, password));
        boolean valid = userService.verifyUser(username, password);
        if (valid) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ROLE_USER);
            authorities.add(authority);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, password, authorities);
            auth.setDetails("login user.");
            return auth;
        } else {
            logger.debug("valid faild");
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
