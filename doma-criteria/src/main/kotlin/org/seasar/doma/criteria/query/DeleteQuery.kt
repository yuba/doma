package org.seasar.doma.criteria.query

import java.lang.reflect.Method
import org.seasar.doma.jdbc.Config
import org.seasar.doma.jdbc.PreparedSql
import org.seasar.doma.jdbc.SqlExecutionSkipCause
import org.seasar.doma.jdbc.SqlLogType

class DeleteQuery(
    private val config: Config,
    private val sql: PreparedSql,
    private val className: String,
    private val methodName: String
) : org.seasar.doma.jdbc.query.DeleteQuery {
    override fun getConfig(): Config {
        return config
    }

    override fun getSql(): PreparedSql {
        return sql
    }

    override fun getClassName(): String {
        return className
    }

    override fun getMethodName(): String {
        return methodName
    }

    override fun getQueryTimeout(): Int {
        return config.queryTimeout
    }

    override fun getSqlLogType(): SqlLogType {
        throw UnsupportedOperationException()
    }

    override fun comment(sql: String?): String {
        throw UnsupportedOperationException()
    }

    override fun getMethod(): Method {
        throw UnsupportedOperationException()
    }

    override fun prepare() {
        throw UnsupportedOperationException()
    }

    override fun complete() {
        throw UnsupportedOperationException()
    }

    override fun getSqlExecutionSkipCause(): SqlExecutionSkipCause {
        throw UnsupportedOperationException()
    }

    override fun isOptimisticLockCheckRequired(): Boolean {
        return false
    }

    override fun isAutoGeneratedKeysSupported(): Boolean {
        return false
    }

    override fun isExecutable(): Boolean {
        return true
    }
}