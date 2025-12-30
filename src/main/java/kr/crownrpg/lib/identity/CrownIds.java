package kr.crownrpg.lib.identity;

import java.util.UUID;

// 다양한 곳에서 사용할 무작위 식별자를 생성하는 유틸리티 클래스.
public final class CrownIds {

    private CrownIds() {}

    /** 표준 ID 생성 (UUID v4, 문자열) */
    public static String random() {
        return UUID.randomUUID().toString();
    }
}