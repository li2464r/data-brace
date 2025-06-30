package com.racacia.repository.config.mybatisplus;

import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:li2464r@163.com">li2464r</a>
 * @date 2024-03-06 11:45
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
