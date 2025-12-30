package kr.crownrpg.lib.server;

// Crown 네트워크에서 구분하는 서버 유형을 정의한다.
public enum ServerType {
    PROXY,   // 프록시 혹은 로비 서버
    VILLAGE, // 마을/도시 서버
    DUNGEON, // 던전 콘텐츠 서버
    WILD     // 야생 월드 서버
}
