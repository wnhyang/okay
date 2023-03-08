package org.okay4cloud.okay.common.log.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author wnhyang
 * @date 2023/3/8
 **/
@Getter
@RequiredArgsConstructor
public enum LogTypeEnum {
    /**
     * 正常日志类型
     */
    INFO("0", "正常日志"),

    /**
     * 警告日志类型
     */
    WARN("5", "警告日志"),

    /**
     * 错误日志类型
     */
    ERROR("9", "错误日志");


    /**
     * 类型
     */
    private final String type;

    /**
     * 描述
     */
    private final String description;
}
