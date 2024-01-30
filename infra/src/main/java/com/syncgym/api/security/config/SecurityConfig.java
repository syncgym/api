package com.syncgym.api.security.config;

import com.syncgym.api.delivery.user.repositories.UserRepository;
import com.syncgym.api.permission.getPermissionByDescriptionUseCase.GetPermissionByDescriptionUseCase;
import com.syncgym.api.security.jwt.JwtTokenFilter;
import com.syncgym.api.security.jwt.JwtTokenProvider;
import com.syncgym.api.security.services.refreshTokenService.RefreshTokenServiceImpl;
import com.syncgym.api.security.services.signInService.SignInServiceImpl;
import com.syncgym.api.security.services.signUpService.SignUpServiceImpl;
import com.syncgym.api.user.usecases.createUser.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private GetPermissionByDescriptionUseCase getPermissionByDescriptionUseCase;

    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        return new JwtTokenProvider();
    }

    @Bean
    public RefreshTokenServiceImpl refreshTokenService() {
        return new RefreshTokenServiceImpl();
    }

    @Bean
    public SignInServiceImpl signInService() {
        return new SignInServiceImpl(jwtTokenProvider(), userRepository);
    }

    @Bean
    public SignUpServiceImpl signUpService() {
        return new SignUpServiceImpl(createUserUseCase, signInService(), passwordEncoder(), getPermissionByDescriptionUseCase);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider());

        return http
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        authorizedRequests -> authorizedRequests
//                                .requestMatchers(
//                                        "/auth/signIn",
//                                        "/auth/signUp",
//                                        "/auth/refreshToken/**",
//                                        "/api-docs/**",
//                                        "swagger-ui/**",
//                                        "v3/api-docs/**"
//                                ).permitAll()
//                                .requestMatchers("/api/**").permitAll()
//                                .requestMatchers("/users").hasAnyAuthority("ADMIN")
//                                .anyRequest().authenticated()
                                .anyRequest().permitAll()
                )
                .cors(cors -> {
                })
                .build();

    }
}
