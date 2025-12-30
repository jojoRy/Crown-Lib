package kr.crownrpg.lib;

import kr.crownrpg.lib.service.ServiceRegistry;
import kr.crownrpg.lib.util.CrownLogger;
import org.bukkit.plugin.java.JavaPlugin;

// 메인 플러그인 클래스, Bukkit이 로드하는 진입점 역할을 한다.
public final class CrownLib extends JavaPlugin {

    // 플러그인의 전역 인스턴스를 저장한다.
    private static CrownLib instance;

    @Override
    public void onEnable() {
        // 현재 플러그인 인스턴스를 보관하고 로거 및 서비스 레지스트리를 초기화한다.
        instance = this;
        CrownLogger.init(getLogger());
        ServiceRegistry.init();
        CrownLogger.info("CrownLib enabled");
    }

    @Override
    public void onDisable() {
        // 등록된 서비스를 정리하고 종료 로그를 남긴다.
        ServiceRegistry.clear();
        CrownLogger.info("CrownLib disabled");
    }

    // 다른 클래스에서 플러그인 인스턴스에 접근할 때 사용한다.
    public static CrownLib getInstance() {
        return instance;
    }
}