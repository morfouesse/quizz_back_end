package com.antoine.quizz.security;

// ici on protège les endpoints
/*
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //  https://stackoverflow.com/questions/32081578/spring-security-nosuchbeandefinitionexception-no-qualifying-bean-of-type-org

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .httpBasic()
                .and()
                .authorizeHttpRequests(requests -> requests.mvcMatchers(HttpMethod.GET, "/quizz/surveys")
                        .permitAll()
                        .mvcMatchers(HttpMethod.GET, "/quizz/surveys/*")
                        .permitAll()
                        .mvcMatchers(HttpMethod.POST, "/quizz/survey")
                        .permitAll()
                        .mvcMatchers(HttpMethod.PUT, "/quizz/survey")
                        .permitAll()
                        .mvcMatchers(HttpMethod.DELETE, "/quizz/survey/*")
                        .permitAll());
    }
}//
*/