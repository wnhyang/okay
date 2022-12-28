package org.okay4cloud.okay.common.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: wnhyang
 * @create: 2022-12-28 15:47
 **/
@Configuration(proxyBeanMethods = false)
public class RestTemplateConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
