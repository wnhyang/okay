package org.okay4cloud.okay.common.log.event;

import org.okay4cloud.okay.admin.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author wnhyang
 * @date 2023/3/9
 **/
public class SysLogEvent extends ApplicationEvent {
    public SysLogEvent(SysLog source) {
        super(source);
    }
}
