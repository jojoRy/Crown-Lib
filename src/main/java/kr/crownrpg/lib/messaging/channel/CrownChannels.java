package kr.crownrpg.lib.messaging.channel;

// 메시지 버스에서 사용하는 채널 이름 상수 모음.
public final class CrownChannels {

    private CrownChannels() {}

    public static final String GLOBAL = "crown:s2:global"; // 전체 서버에 전파되는 채널
    public static final String PARTY  = "crown:s2:party";  // 파티 관련 메시지 채널
    public static final String GUILD  = "crown:s2:guild";  // 길드 관련 메시지 채널
}
