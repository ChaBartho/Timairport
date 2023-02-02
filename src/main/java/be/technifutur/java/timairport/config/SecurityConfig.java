package be.technifutur.java.timairport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.List;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.httpBasic();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

/*
        RequestMatchers:
        - * : n'importe quelle valeur dans 1 segment
        - {machin:regex} : n'importe quelles valeurs correspondant au pattern regex pour1 segment
        - ** : n'importe quelle valeur dans deux segments (seulement au dernier segment)

        Authorization

        PermitAll() :       tout le monde passe
        DenyAll() :         personne passe
        authenticated :     les users authentifiés
        hasAuthority() :     les users non-authentifiés
        HasAnyAuthority() :
        HasRole() :
        HasAnyRole() :

        Une authority c'est un droit sous forme de String(plus un droit à une action)
        Un Role est une Authority qui commence par 'ROLE_' (qui est l'utilisateur pour mon app)


        auth: 'ROLE_TRUC' -> role: 'TRUC'
        auth: 'MACHIN' -> (/) role
*/

        http.authorizeHttpRequests( (authorize) -> {
            authorize
                    //Via mapping d'URI
                    .requestMatchers("/plane/all").anonymous()
                    .requestMatchers("/plane/add").authenticated()
                    .requestMatchers("/plane/*/update").hasRole(("ADMIN"))//.hasAuthority("ROLE_ADMIN")
                    // Via HttpMethod + mapping d'URI
                    .requestMatchers(HttpMethod.DELETE,"/plane/*")
                                                .hasAnyRole("USER", "ADMIN")
                                                //.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                    .anyRequest().permitAll();
        });

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        List<UserDetails> users = List.of(
                User.builder()
                        .username("user")
                        .password(encoder.encode("pass"))
                        .roles("USER")
                        .build(),
                User.builder()
                        .username("admin")
                        .password(encoder.encode("pass"))
                        .roles("ADMIN", "USER")
                        .build()
        );

                return new InMemoryUserDetailsManager(users);
    }





}