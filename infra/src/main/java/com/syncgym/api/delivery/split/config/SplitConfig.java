package com.syncgym.api.delivery.split.config;

import com.syncgym.api.delivery.split.mappers.SplitRepositoryMapper;
import com.syncgym.api.delivery.split.mappers.SplitResponseRestMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SplitConfig {

    @Bean
    public SplitRepositoryMapper splitRepositoryMapper() {
        return new SplitRepositoryMapper();
    }

    @Bean
    public SplitResponseRestMapper splitResponseRestMapper() {
        return new SplitResponseRestMapper();
    }
}
