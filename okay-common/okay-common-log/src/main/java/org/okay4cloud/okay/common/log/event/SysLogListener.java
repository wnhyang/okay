package org.okay4cloud.okay.common.log.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okay4cloud.okay.admin.api.entity.SysLog;
import org.okay4cloud.okay.admin.api.feign.RemoteLogService;
import org.okay4cloud.okay.common.core.constant.SecurityConstants;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @author wnhyang
 * @date 2023/3/9
 **/
@Slf4j
@RequiredArgsConstructor
public class SysLogListener {
    private final RemoteLogService remoteLogService;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        SysLog sysLog = (SysLog) event.getSource();
        remoteLogService.saveLog(sysLog, SecurityConstants.FROM_IN);
    }
}
