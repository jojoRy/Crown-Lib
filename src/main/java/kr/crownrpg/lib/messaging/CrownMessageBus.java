package kr.crownrpg.lib.messaging;

public interface CrownMessageBus {

    /** 기본 채널 (GLOBAL) */
    void publish(CrownMessage message);

    /** 명시적 채널 지정 */
    void publish(String channel, CrownMessage message);

    /** 핸들러 등록 */
    void registerHandler(CrownMessageHandler handler);
}
