package kr.crownrpg.lib.event.input;

import kr.crownrpg.lib.event.CrownEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * 클라이언트 입력 계열 이벤트의 공통 베이스 이벤트.
 *
 * - Crown-PacketHandler가 발생시키는 모든 입력 이벤트는
 *   이 클래스를 상속해야 한다.
 *
 * - 이 이벤트는 "입력"이라는 범주만 표현하며
 *   입력의 의미/처리는 Feature Plugin 책임이다.
 */
public abstract class CrownPlayerInputEvent extends CrownEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    protected final Player player;

    protected CrownPlayerInputEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
