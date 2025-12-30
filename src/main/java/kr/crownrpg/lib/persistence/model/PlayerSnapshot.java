package kr.crownrpg.lib.persistence.model;

import kr.crownrpg.lib.server.ServerType;

import java.util.UUID;

// 플레이어의 상태를 저장소에 기록하기 위한 스냅샷 모델.
public class PlayerSnapshot {

    private final UUID uuid;             // 플레이어 UUID
    private final String name;           // 플레이어 이름
    private final ServerType serverType; // 마지막으로 접속한 서버 유형
    private final long updatedAt;        // 정보가 업데이트된 시각(밀리초)

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
