package kr.crownrpg.lib.context;

import kr.crownrpg.lib.server.ServerType;

import java.util.UUID;

public class PlayerContext {
    private final UUID uuid;
    private final String name;
    private ServerType serverType;

    public PlayerContext(UUID uuid, String name, ServerType serverType) {
        this.uuid = uuid;
        this.name = name;
        this.serverType = serverType;
    }

    public UUID getUuid() { return uuid; }
    public String getName() { return name; }

    public ServerType getServerType() { return serverType; }
    public void setServerType(ServerType serverType) { this.serverType = serverType; }
}
