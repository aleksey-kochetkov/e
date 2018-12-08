package e.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.*;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
//            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            .withUser("user")
// In spring-security-core:5.0.0.RC1, the default PasswordEncoder is built as a DelegatingPasswordEncoder.
// Который требует задать id для обращения к конкретному PasswordEncoder.
// Без id падает. "{noop}" это способ задать id. NoOpPasswordEncoder в
// данном случае. Это аналогично закомментированному выше методу
// passwordEncoder(PasswordEncoder). Однако NoOpPasswordEncoder помечен
// как depricated.
            .password("{noop}password")
            .roles("USER")
            .and()
            .withUser("test").password("{noop}test").roles("ADMIN");
    }
}
