package kr.crownrpg.lib.identity;

import java.util.UUID;

public final class CrownIds {

    private CrownIds() {}

    /** 표준 ID 생성 (UUID v4, 문자열) */
    public static String random() {
        return UUID.randomUUID().toString();
    }
}
