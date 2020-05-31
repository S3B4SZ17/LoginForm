package com.login.demo.Configuration;




import com.login.demo.Services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Set my own configuration overriding this method by the auth object
        auth.userDetailsService(userDetailsService);//we are using an instance of that interface to configure the authorization
    }
    /*
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        //we create this method to generate a password encoder,
        // becasue the passwords should not be seen in plain text.

            return new BCryptPasswordEncoder();
    }

     */


    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return  NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/admin").hasAuthority("ADMIN")//this permits if the API is admin only ADMIN users
                    .antMatchers("/user").hasAnyAuthority("ADMIN","USER")//this permits if the API is user to be ADMIN or USER
                    .antMatchers("/").permitAll()
                    .and().formLogin();
    }
}
