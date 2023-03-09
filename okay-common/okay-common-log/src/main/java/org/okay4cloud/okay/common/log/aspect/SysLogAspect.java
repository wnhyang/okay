package org.okay4cloud.okay.common.log.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.okay4cloud.okay.admin.api.entity.SysLog;
import org.okay4cloud.okay.common.core.util.SpringContextHolder;
import org.okay4cloud.okay.common.log.enums.LogTypeEnum;
import org.okay4cloud.okay.common.log.event.SysLogEvent;
import org.okay4cloud.okay.common.log.util.SysLogUtils;

/**
 * @author wnhyang
 * @date 2023/3/8
 **/
@Aspect
@Slf4j
public class SysLogAspect {

    @Around("@annotation(sysLog)")
    @SneakyThrows
    public Object around(ProceedingJoinPoint point, org.okay4cloud.okay.common.log.annotation.SysLog sysLog) {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);

        SysLog logVo = SysLogUtils.getSysLog();
        logVo.setTitle(sysLog.value());

        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj;

        try {
            obj = point.proceed();
        } catch (Exception e) {
            logVo.setType(LogTypeEnum.ERROR.getType());
            logVo.setException(e.getMessage());
            throw e;
        } finally {
            Long endTime = System.currentTimeMillis();
            logVo.setTime(endTime - startTime);
            SpringContextHolder.publishEvent(new SysLogEvent(logVo));
        }

        return obj;
    }
}
