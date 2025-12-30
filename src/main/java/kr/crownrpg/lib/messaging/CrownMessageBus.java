package kr.crownrpg.lib.messaging;

// 서버 간 메시지를 전달하고 처리 핸들러를 관리하는 메시지 버스 인터페이스.
public interface CrownMessageBus {

    /** 기본 채널 (GLOBAL) */
    void publish(CrownMessage message);

    /** 명시적 채널 지정 */
    void publish(String channel, CrownMessage message);

    /** 핸들러 등록 */
    void registerHandler(CrownMessageHandler handler);
}
