package kr.crownrpg.lib.event;

import kr.crownrpg.lib.context.PlayerContext;
import org.bukkit.event.HandlerList;

// 플레이어가 서버에 접속했을 때 발생하는 커스텀 이벤트.
public class CrownPlayerJoinEvent extends CrownEvent {

    // Bukkit 이벤트 시스템이 요구하는 핸들러 리스트.
    private static final HandlerList HANDLERS = new HandlerList();

    // 접속한 플레이어의 컨텍스트 정보를 담는다.
    private final PlayerContext context;

    public CrownPlayerJoinEvent(PlayerContext context) {
        this.context = context;
    }

    // 이벤트에 포함된 플레이어 컨텍스트를 반환한다.
    public PlayerContext getContext() {
        return context;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    // 정적 방식으로 핸들러 리스트를 제공한다.
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}