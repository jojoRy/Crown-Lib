package kr.crownrpg.lib.persistence.model;

import kr.crownrpg.lib.server.ServerType;

import java.util.UUID;

public class PlayerSnapshot {

    private final UUID uuid;
    private final String name;
    private final ServerType serverType;
    private final long updatedAt;

    public PlayerSnapshot(UUID uuid, String name, ServerType serverType, long updatedAt) {
        this.uuid = uuid;
        this.name = name;
        this.serverType = serverType;
        this.updatedAt = updatedAt;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public ServerType getServerType() {
        return serverType;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }
}
