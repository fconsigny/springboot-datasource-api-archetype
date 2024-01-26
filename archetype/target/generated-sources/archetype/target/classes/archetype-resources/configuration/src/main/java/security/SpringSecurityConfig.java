#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.${artifactId}.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfig {
    @Value("${symbol_dollar}{app.spring.security.secure.auth.method}")
    private String principalRequestHeader;

    @Value("${symbol_dollar}{app.spring.security.secure.api.key}")
    private String principalRequestValue;

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        ApiKeyAuthenticationFilter filter = new ApiKeyAuthenticationFilter(principalRequestHeader);
        System.out.println("Attempt to login with: " + principalRequestHeader + " and " + principalRequestValue);
        filter.setAuthenticationManager(authentication -> {
            final String principal = (String) authentication.getPrincipal();
            if (!principalRequestValue.equals(principal)) {
                throw new BadCredentialsException("Unauthorized");
            }

            authentication.setAuthenticated(true);
            return authentication;
        });

        httpSecurity.
                csrf().disable()
                .cors().and()
                .headers().frameOptions().sameOrigin().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/actuator/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api-docs/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api-docs.yaml")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/swagger-ui.html")).permitAll()
                )
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilter(filter)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/**")).authenticated()
                );

        return httpSecurity.build();
    }



}
