package org.okay4cloud.okay.common.log;

import lombok.RequiredArgsConstructor;
import org.okay4cloud.okay.admin.api.feign.RemoteLogService;
import org.okay4cloud.okay.common.log.aspect.SysLogAspect;
import org.okay4cloud.okay.common.log.event.SysLogListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author wnhyang
 * @date 2023/3/8
 **/
@EnableAsync
@RequiredArgsConstructor
@ConditionalOnWebApplication
@Configuration(proxyBeanMethods = false)
public class LogAutoConfiguration {

    @Bean
    public SysLogListener sysLogListener(RemoteLogService remoteLogService) {
        return new SysLogListener(remoteLogService);
    }

    @Bean
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }

}
