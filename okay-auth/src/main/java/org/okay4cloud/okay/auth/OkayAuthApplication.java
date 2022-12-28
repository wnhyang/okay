package org.okay4cloud.okay.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: wnhyang
 * @create: 2022-12-28 11:10
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class OkayAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OkayAuthApplication.class, args);
    }
}
