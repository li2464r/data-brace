package com.racacia.regular.base;

import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:li2464r@163.com">R</a>
 * @date 2025/3/28 10:46
 */
public class SQLOutImpl implements Log {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public SQLOutImpl(String clazz) {
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void error(String s, Throwable e) {
        logger.error(s, e);
    }

    @Override
    public void error(String s) {
        logger.error(s);
    }

    @Override
    public void debug(String s) {
        logger.info(s);
    }

    @Override
    public void trace(String s) {
        logger.info(s);
    }

    @Override
    public void warn(String s) {
        logger.info(s);
    }

}
