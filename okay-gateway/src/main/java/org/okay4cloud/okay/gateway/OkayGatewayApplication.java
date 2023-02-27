package org.okay4cloud.okay.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wnhyang
 * @date 2023/1/29
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class OkayGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(OkayGatewayApplication.class, args);
    }
}
