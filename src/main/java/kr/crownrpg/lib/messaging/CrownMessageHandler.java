package kr.crownrpg.lib.messaging;

public interface CrownMessageHandler {
    CrownMessageType getType();
    void handle(CrownMessage message);
}
