package org.okay4cloud.okay.common.log.annotation;

import java.lang.annotation.*;

/**
 * @author wnhyang
 * @date 2023/3/8
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    /**
     * 描述
     *
     * @return String
     */
    String value();
}
