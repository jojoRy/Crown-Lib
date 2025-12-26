package kr.crownrpg.lib.util;

import java.util.logging.Logger;

public final class CrownLogger {
    private static Logger logger;
    private CrownLogger() {}

    public static void init(Logger baseLogger) { logger = baseLogger; }
    public static void info(String msg) { logger.info(msg); }
    public static void warn(String msg) { logger.warning(msg); }
    public static void error(String msg) { logger.severe(msg); }
}
