/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */
package com.cs544.roommate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${auth.query}")
	private String authQuery;
	@Value("${author.query}")
	private String authorQuery;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/index", "/modules/**", 
                				"/css/**","/login/",
                				"/account/signup", "/js/**",
                				"/images/**",
                				"/api/**").permitAll()
                .antMatchers("/owner/**","/property/**").hasRole("OWNER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/search/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin().loginPage("/login/")
            	.permitAll()
            	.usernameParameter("email")
            	.passwordParameter("password")
            	.defaultSuccessUrl("/")
            	.and()
            .logout()
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            	.invalidateHttpSession(true)
             .clearAuthentication(true)
            	.logoutSuccessUrl("/")
                .permitAll();
        http.csrf().disable();
    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(authQuery)
								.authoritiesByUsernameQuery(authorQuery)
								.dataSource(dataSource);
	}
}