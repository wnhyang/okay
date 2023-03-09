package org.okay4cloud.okay.admin.api.feign;

import org.okay4cloud.okay.admin.api.entity.SysLog;
import org.okay4cloud.okay.common.core.constant.SecurityConstants;
import org.okay4cloud.okay.common.core.constant.ServiceNameConstants;
import org.okay4cloud.okay.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author wnhyang
 * @date 2023/3/9
 **/
@FeignClient(contextId = "remoteLogService", value = ServiceNameConstants.UMPS_SERVICE)
public interface RemoteLogService {

    /**
     * 保存日志
     *
     * @param sysLog 日志实体
     * @param from   内部调用标志
     * @return succes、false
     */
    @PostMapping("/log")
    R<Boolean> saveLog(@RequestBody SysLog sysLog, @RequestHeader(SecurityConstants.FROM) String from);
}
