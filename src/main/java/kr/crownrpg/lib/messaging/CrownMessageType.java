package kr.crownrpg.lib.messaging;

// 메시지 버스에서 통신할 때 사용되는 표준 메시지 종류를 정의한다.
public enum CrownMessageType {
    PLAYER_SERVER_SWITCH,
    PARTY_SYNC,
    GUILD_SYNC,
    PLAYER_STATUS_UPDATE,
    CUSTOM
}