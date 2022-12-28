package org.okay4cloud.okay.common.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.okay4cloud.okay.common.mybatis.handler.MybatisPlusMetaObjectHandler;
import org.okay4cloud.okay.common.mybatis.interceptor.OkayPaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wnhyang
 * @create: 2022-12-28 10:21
 * <p>
 * mybatis-plus 统一配置
 **/
@Configuration(proxyBeanMethods = false)
public class MybatisPlusAutoConfiguration {

    /**
     * 分页插件, 对于单一数据库类型来说,都建议配置该值,避免每次分页都去抓取数据库类型
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OkayPaginationInnerInterceptor());
        return interceptor;
    }

    /**
     * 审计字段自动填充
     *
     * @return {@link MetaObjectHandler}
     */
    @Bean
    public MybatisPlusMetaObjectHandler mybatisPlusMetaObjectHandler() {
        return new MybatisPlusMetaObjectHandler();
    }
}
