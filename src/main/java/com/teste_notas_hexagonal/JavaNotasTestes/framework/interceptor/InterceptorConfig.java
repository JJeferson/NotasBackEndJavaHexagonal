package com.teste_notas_hexagonal.JavaNotasTestes.framework.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {


    @Value("123654789")  // em base64 MTIzNjU0Nzg5
    private String TokenFixo;

    @Bean
    public AuthInterceptor requestHandler() {
        String Token = TokenFixo;

        return new AuthInterceptor(Token);
    }



    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(requestHandler()).excludePathPatterns(
                "/healthcheck"
        );
    }

}
