package br.com.s2it.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("s2it").password("s2it").roles("ADMIN");
    }
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .csrf().disable()
	      .authorizeRequests()
	        .anyRequest().authenticated()
	        .and()
	      .httpBasic().and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  }
	
}
