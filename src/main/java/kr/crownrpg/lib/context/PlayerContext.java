package kr.crownrpg.lib.context;

import kr.crownrpg.lib.server.ServerType;

import java.util.UUID;

// 플레이어의 신원 및 접속 서버 정보를 담는 컨텍스트 객체.
public class PlayerContext {
    // 플레이어의 고유 UUID.
    private final UUID uuid;
    // 플레이어 닉네임.
    private final String name;
    // 현재 접속 중인 서버 유형.
    private ServerType serverType;

    public PlayerContext(UUID uuid, String name, ServerType serverType) {
        this.uuid = uuid;
        this.name = name;
        this.serverType = serverType;
    }

    // 플레이어 UUID를 반환한다.
    public UUID getUuid() { return uuid; }
    // 플레이어 이름을 반환한다.
    public String getName() { return name; }

    // 현재 서버 유형을 반환하거나 변경한다.
    public ServerType getServerType() { return serverType; }
    public void setServerType(ServerType serverType) { this.serverType = serverType; }
}