package kr.crownrpg.lib.util;

import java.util.logging.Logger;

// Bukkit 로거를 간편하게 사용하기 위한 헬퍼 클래스.
public final class CrownLogger {
    // 플러그인에서 제공하는 기본 로거 인스턴스를 저장한다.
    private static Logger logger;
    private CrownLogger() {}

    // 초기화 시 Bukkit 로거를 전달받아 내부에 저장한다.
    public static void init(Logger baseLogger) { logger = baseLogger; }
    // 일반 정보 로그를 출력한다.
    public static void info(String msg) { logger.info(msg); }
    // 경고 로그를 출력한다.
    public static void warn(String msg) { logger.warning(msg); }
    // 심각한 오류 로그를 출력한다.
    public static void error(String msg) { logger.severe(msg); }
}
