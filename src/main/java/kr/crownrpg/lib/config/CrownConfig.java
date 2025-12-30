package kr.crownrpg.lib.config;

import org.bukkit.configuration.file.FileConfiguration;

// 플러그인 설정 값을 편리하게 조회하기 위한 래퍼 클래스.
public class CrownConfig {

    // Bukkit에서 제공하는 설정 객체를 보관한다.
    private final FileConfiguration config;

    public CrownConfig(FileConfiguration config) {
        this.config = config;
    }

    // 디버그 모드 활성화 여부를 반환한다. 설정에 값이 없으면 기본적으로 false가 된다.
    public boolean isDebug() {
        return config.getBoolean("debug", false);
    }
}