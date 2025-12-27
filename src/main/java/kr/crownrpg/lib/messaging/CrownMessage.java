package kr.crownrpg.lib.messaging;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class CrownMessage {

    private final String messageId;
    private final String sourceNodeId;
    private final long createdAt;

    private final CrownMessageType type;
    private final Map<String, String> payload;

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
        this.payload = Collections.unmodifiableMap(new HashMap<>(payload)); // SAFETY FIX
    }

    /* ---------- factory ---------- */

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
