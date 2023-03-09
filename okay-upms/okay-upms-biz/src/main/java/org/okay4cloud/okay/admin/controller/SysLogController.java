package org.okay4cloud.okay.admin.controller;


import lombok.RequiredArgsConstructor;
import org.okay4cloud.okay.admin.api.entity.SysLog;
import org.okay4cloud.okay.admin.service.SysLogService;
import org.okay4cloud.okay.common.core.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author wnhyang
 * @since 2023-03-08
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
public class SysLogController {

    private final SysLogService sysLogService;

    /**
     * 插入日志
     *
     * @param sysLog 日志实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> save(@Valid @RequestBody SysLog sysLog) {
        return R.ok(sysLogService.save(sysLog));
    }

}
