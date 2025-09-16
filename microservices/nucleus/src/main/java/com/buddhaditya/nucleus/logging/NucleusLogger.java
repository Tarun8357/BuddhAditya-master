package com.buddhaditya.nucleus.logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class NucleusLogger {

    private final Logger logger;

    private NucleusLogger(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    public static NucleusLogger getLogger(Class<?> clazz) {
        return new NucleusLogger(clazz);
    }

    public void info(String message, Object... args) {
        logger.info(message, args);
    }

    public void warn(String message, Object... args) {
        logger.warn(message, args);
    }

    public void error(String message, Object... args) {
        logger.error(message, args);
    }

    public void debug(String message, Object... args) {
        logger.debug(message, args);
    }

    public void trace(String message, Object... args) {
        logger.trace(message, args);
    }

    public void error(String message, Throwable throwable, Object... args) {
        logger.error(message, throwable);
    }
}
