package kr.crownrpg.lib.util;

import java.util.logging.Logger;

public final class CrownLogger {
    private static Logger logger;
    private CrownLogger() {}

    public static void init(Logger baseLogger) { logger = baseLogger; }

    public static void info(String msg) {
        getLoggerOrThrow().info(msg); // SAFETY FIX
    }

    public static void warn(String msg) {
        getLoggerOrThrow().warning(msg); // SAFETY FIX
    }

    public static void error(String msg) {
        getLoggerOrThrow().severe(msg); // SAFETY FIX
    }

    private static Logger getLoggerOrThrow() {
        if (logger == null) {
            throw new IllegalStateException("CrownLogger is not initialized");
        }
        return logger;
    }
}
