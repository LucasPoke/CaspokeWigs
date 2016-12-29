package br.com.caspoke.springmvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("clienteDetailsService")
	UserDetailsService clienteDetailsService;
	
	@Autowired
    PersistentTokenRepository tokenRepository;
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("caspoke").password("admin").roles("NORMAL", "PARCIAL", "TOTAL");
        auth.userDetailsService(clienteDetailsService);	
        auth.authenticationProvider(authenticationProvider());
    }
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        /* 
	        http.authorizeRequests().antMatchers("/", "/list")
	                .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
	                .antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')").antMatchers("/edit-user-*")
	                .access("hasRole('ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login")
	                .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
	                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
	                .tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");
	        */
	        http.authorizeRequests()
	        	.antMatchers("/").access("hasRole('NORMAL') or hasRole('PARCIAL') or hasRole('TOTAL')")
	        	.antMatchers("/listaPerucas").access("hasRole('TOTAL') or hasRole('PARCIAL')")
	        	.and().formLogin().loginPage("/login")
                .usernameParameter("ssoId").passwordParameter("senha").and()
                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
                .tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");
	    }
	 
	 	@Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(clienteDetailsService);
	        authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }
	 
	    @Bean
	    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
	        PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
	                "remember-me", clienteDetailsService, tokenRepository);
	        return tokenBasedservice;
	    }
	 
	    @Bean
	    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
	        return new AuthenticationTrustResolverImpl();
	    }
}
