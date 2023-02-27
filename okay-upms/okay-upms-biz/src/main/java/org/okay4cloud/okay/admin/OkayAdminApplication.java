package org.okay4cloud.okay.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wnhyang
 * @date 2023/1/29
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class OkayAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(OkayAdminApplication.class, args);
    }
}
