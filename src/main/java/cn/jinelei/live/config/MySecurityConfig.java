package cn.jinelei.live.config;

import cn.jinelei.live.service.UserService;
import cn.jinelei.live.utils.user.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jinelei on 17-4-9.
 */
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private String tomcat_nginx_server_ip = "http://localhost/tomcat";
    private String application_name = "live";

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new MyUserDetailsService(userService));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .regexMatchers( "/live/index",
//                        "/live/",
//                        "/live",
//                        "/",
//                        "/live/search.*",
//                        "/live/category.*",
//                        "/live/room.*",
//                        "/login.*",
//                        "/logout.*",
//                        "/live/login.*",
//                        "/live/logout.*").permitAll()
//                .anyRequest().authenticated()
                .anyRequest().permitAll()
                .and().formLogin()
//                .loginPage("/live/login")
//                .loginProcessingUrl("/perform_login")
//                .failureForwardUrl("/live/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
                .and()
                .logout()
//                .logoutSuccessUrl("/live/index")
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
