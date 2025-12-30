package kr.crownrpg.lib.messaging;

// 메시지를 처리하는 핸들러 인터페이스. 타입별로 구현체를 등록한다.
public interface CrownMessageHandler {
    // 이 핸들러가 처리할 메시지 타입을 반환한다.
    CrownMessageType getType();
    // 전달된 메시지를 처리한다.
    void handle(CrownMessage message);
}