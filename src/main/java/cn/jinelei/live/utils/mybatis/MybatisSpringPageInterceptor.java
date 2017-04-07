package cn.jinelei.live.utils.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by jinelei on 17-4-7.
 */
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }),
        @Signature(method = "query", type = Executor.class, args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class MybatisSpringPageInterceptor implements Interceptor{

    private static final Logger log = LoggerFactory.getLogger(MybatisSpringPageInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
