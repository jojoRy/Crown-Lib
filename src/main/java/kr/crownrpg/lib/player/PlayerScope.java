package kr.crownrpg.lib.player;

// 플레이어 조회나 작업 대상 범위를 나타내는 열거형.
public enum PlayerScope {
    ONLINE,  // 현재 접속 중인 플레이어
    OFFLINE, // 오프라인 상태의 플레이어
    ANY      // 상태와 관계없는 전체 플레이어
}
