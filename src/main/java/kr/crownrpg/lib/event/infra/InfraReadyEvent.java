package kr.crownrpg.lib.event.infra;

import kr.crownrpg.lib.event.CrownEvent;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * CrownInfra가 모든 인프라 서비스를
 * ServiceRegistry에 등록한 이후 발생하는 이벤트.
 */
public final class InfraReadyEvent extends CrownEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
