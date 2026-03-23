package me.serbob.zaryxnear.config;

import me.serbob.zaryxnear.autogen.apiDocGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    @Bean
    public ApiDocGenerator apiDocGenerator() {
        return new ApiDocGenerator();
    }
}
