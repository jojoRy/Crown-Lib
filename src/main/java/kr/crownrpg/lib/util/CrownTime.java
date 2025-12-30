package kr.crownrpg.lib.util;

// 시간 관련 유틸리티를 제공하는 클래스.
public final class CrownTime {
    private CrownTime() {}
    // 현재 시간을 밀리초 단위로 반환한다.
    public static long now() { return System.currentTimeMillis(); }
}
