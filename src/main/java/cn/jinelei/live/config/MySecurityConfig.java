package cn.jinelei.live.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("jin").password("jin").roles("USER").and()
                .withUser("admin").password("admin").roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/live/index","/live/category**","/login").permitAll()
                .regexMatchers("/live/index","/live/","/live/search.*","/live/room.*","/live/login").permitAll()
                .anyRequest().authenticated()
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/category/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
                .and().formLogin()
//                .loginPage(String.format("%s/%s/minelogin", tomcat_nginx_server_ip, application_name))
                .loginPage("/live/login")
//                .defaultSuccessUrl("/live")
                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl(String.format("%s/%s/index", tomcat_nginx_server_ip, application_name))
//                .failureUrl(String.format("%s/%s/minelogin?error", tomcat_nginx_server_ip, application_name))
//                .failureForwardUrl("/live/error")
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
