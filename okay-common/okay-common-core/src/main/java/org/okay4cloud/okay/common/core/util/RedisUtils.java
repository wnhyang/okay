package org.okay4cloud.okay.common.core.util;

import lombok.experimental.UtilityClass;

/**
 * @author wnhyang
 * @date 2023/3/11
 **/
@UtilityClass
public class RedisUtils {

    /**
     * 超时时间 1
     */
    public final long TIME_OUT_1 = 1L;

    /**
     * 超时时间 3
     */
    public final long TIME_OUT_3 = 3L;

    /**
     * 超时时间 7
     */
    public final long TIME_OUT_7 = 7L;

    /**
     * 超时时间 14
     */
    public final long TIME_OUT_14 = 15L;

    /**
     * 超时时间 30
     */
    public final long TIME_OUT_30 = 30L;

    /**
     * 超时时间 60
     */
    public final long TIME_OUT_60 = 60L;

    public String getKey(String keyPrefix, Object... ids) {
        StringBuilder builder = new StringBuilder().append(keyPrefix);
        for (Object id : ids) {
            builder.append(":").append(id);
        }
        return builder.toString();
    }

}
