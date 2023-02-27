package org.okay4cloud.okay.common.mybatis.interceptor;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ParameterUtils;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.SQLException;

/**
 * 分页拦截器
 * <p>
 * 重构分页插件，当 size 小于 0 时，直接设置 0，防止错误查表
 *
 * @author wnhyang
 * @date 2022-12-28 10:05
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class OkayPaginationInnerInterceptor extends PaginationInnerInterceptor {


    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        IPage<?> iPage = ParameterUtils.findPage(parameter).orElse(null);
        // size 小于 0 直接设置 0，即不查数据
        if (null != iPage && iPage.getSize() < 0) {
            iPage.setSize(0);
        }
        super.beforeQuery(executor, ms, parameter, rowBounds, resultHandler, boundSql);
    }
}
