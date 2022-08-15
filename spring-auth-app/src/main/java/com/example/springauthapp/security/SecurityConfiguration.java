//package murraco.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableAuthorizationServer
//public class SecurityConfiguration extends AuthorizationServerConfigurerAdapter{
//	
//	@Autowired
//	private JwtTokenProvider jwtTokenProvider;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    	// Disable CSRF (cross site request forgery)
//        http.csrf().disable();
//
//        // No session will be created or used by spring security
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // Entry points
//        http.authorizeRequests()//
//            .antMatchers("/users/signin").permitAll()//
//            .antMatchers("/users/signup").permitAll()//
//            .antMatchers("/h2-console/**/**").permitAll()
//            // Disallow everything else..
//            .anyRequest().authenticated();
//
//        // If a user try to access a resource without having enough permissions
//        http.exceptionHandling().accessDeniedPage("/login");
//
//        // Apply JWT
//        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
//
//        // Optional, if you want to test the API from a browser
//        // http.httpBasic();
//        return http.build();
//    }
//    
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/users/login", "/users/signup", "/users");
//    }
//    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//      return new BCryptPasswordEncoder(12);
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//      return super.authenticationManagerBean();
//    }
//
//}
