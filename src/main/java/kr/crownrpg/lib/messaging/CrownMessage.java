package kr.crownrpg.lib.messaging;

import java.util.Map;
import java.util.UUID;

// 노드 간 통신에 사용되는 메시지 객체. 식별자, 발신자, 생성 시각, 타입, 페이로드를 포함한다.
public final class CrownMessage {

    private final String messageId;      // 메시지 고유 ID
    private final String sourceNodeId;;   // 메시지를 보낸 서버 노드 ID
    private final long createdAt;        // 메시지 생성 시각(밀리초)

    private final CrownMessageType type; // 메시지 목적을 나타내는 타입
    private final Map<String, String> payload; // 전달할 데이터 본문

    private CrownMessage(
            String messageId,
            String sourceNodeId,
            long createdAt,
            CrownMessageType type,
            Map<String, String> payload
    ) {
        this.messageId = messageId;
        this.sourceNodeId = sourceNodeId;
        this.createdAt = createdAt;
        this.type = type;
        this.payload = payload;
    }

    /* ---------- factory ---------- */
    // 새로운 메시지를 생성하고 UUID로 고유 ID를 부여한다.
    public static CrownMessage create(
            String sourceNodeId,
            CrownMessageType type,
            Map<String, String> payload
    ) {
        return new CrownMessage(
                UUID.randomUUID().toString(),
                sourceNodeId,
                System.currentTimeMillis(),
                type,
                payload
        );
    }

    /* ---------- getters ---------- */

    public String getMessageId() {
        return messageId;
    }

    public String getSourceNodeId() {
        return sourceNodeId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public CrownMessageType getType() {
        return type;
    }

    public Map<String, String> getPayload() {
        return payload;
    }
}
