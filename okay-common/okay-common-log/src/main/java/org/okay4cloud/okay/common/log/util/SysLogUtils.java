package org.okay4cloud.okay.common.log.util;

import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import lombok.experimental.UtilityClass;
import org.okay4cloud.okay.admin.api.entity.SysLog;
import org.okay4cloud.okay.common.log.enums.LogTypeEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author wnhyang
 * @date 2023/3/8
 **/
@UtilityClass
public class SysLogUtils {
    public SysLog getSysLog() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        SysLog sysLog = new SysLog();
        sysLog.setCreateBy(Objects.requireNonNull(getUsername()));
        sysLog.setUpdateBy(Objects.requireNonNull(getUsername()));
        sysLog.setType(LogTypeEnum.INFO.getType());
        sysLog.setRemoteAddr(ServletUtil.getClientIP(request));
        sysLog.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        sysLog.setMethod(request.getMethod());
        sysLog.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        sysLog.setParams(HttpUtil.toParams(request.getParameterMap()));
        sysLog.setServiceId(getClientId(request));
        return sysLog;
    }

    /**
     * 获取客户端
     *
     * @return clientId
     */
    private String getClientId(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            OAuth2Authentication auth2Authentication = (OAuth2Authentication) authentication;
            return auth2Authentication.getOAuth2Request().getClientId();
        }
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            BasicAuthenticationConverter basicAuthenticationConverter = new BasicAuthenticationConverter();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = basicAuthenticationConverter
                    .convert(request);
            if (usernamePasswordAuthenticationToken != null) {
                return usernamePasswordAuthenticationToken.getName();
            }
        }
        return null;
    }

    /**
     * 获取用户名称
     *
     * @return username
     */
    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getName();
    }
}
