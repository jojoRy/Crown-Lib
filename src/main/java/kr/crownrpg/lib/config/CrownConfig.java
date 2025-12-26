package kr.crownrpg.lib.config;

import org.bukkit.configuration.file.FileConfiguration;

public class CrownConfig {

    private final FileConfiguration config;

    public CrownConfig(FileConfiguration config) {
        this.config = config;
    }

    public boolean isDebug() {
        return config.getBoolean("debug", false);
    }
}
