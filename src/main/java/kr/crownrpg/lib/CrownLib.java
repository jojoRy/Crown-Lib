package kr.crownrpg.lib;

import kr.crownrpg.lib.service.ServiceRegistry;
import kr.crownrpg.lib.util.CrownLogger;
import org.bukkit.plugin.java.JavaPlugin;

public final class CrownLib extends JavaPlugin {

    private static CrownLib instance;

    @Override
    public void onEnable() {
        instance = this;
        CrownLogger.init(getLogger());
        ServiceRegistry.init();
        CrownLogger.info("CrownLib enabled");
    }

    @Override
    public void onDisable() {
        ServiceRegistry.clear();
        CrownLogger.info("CrownLib disabled");
    }

    public static CrownLib getInstance() {
        return instance;
    }
}
