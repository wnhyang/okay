package org.okay4cloud.okay.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.okay4cloud.okay.common.mybatis.base.BaseEntity;

/**
 * <p>
 * 日志表
 * </p>
 *
 * @author wnhyang
 * @since 2023-03-08
 */
@Data
@TableName("sys_log")
@EqualsAndHashCode(callSuper = true)
public class SysLog extends BaseEntity {

    @TableId("id")
    private Long id;

    /**
     * 日志类型
     */
    @TableField("type")
    private String type;

    /**
     * 日志标题
     */
    @TableField("title")
    private String title;

    /**
     * 服务ID
     */
    @TableField("service_id")
    private String serviceId;

    /**
     * 操作IP地址
     */
    @TableField("remote_addr")
    private String remoteAddr;

    /**
     * 用户代理
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * 请求URI
     */
    @TableField("request_uri")
    private String requestUri;

    /**
     * 操作方式
     */
    @TableField("method")
    private String method;

    /**
     * 操作提交的数据
     */
    @TableField("params")
    private String params;

    /**
     * 执行时间
     */
    @TableField("time")
    private Long time;

    /**
     * 删除标记
     */
    @TableField("deleted")
    @TableLogic
    private String deleted;

    /**
     * 异常信息
     */
    @TableField("exception")
    private String exception;


}
