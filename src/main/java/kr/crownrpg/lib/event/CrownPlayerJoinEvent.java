package kr.crownrpg.lib.event;

import kr.crownrpg.lib.context.PlayerContext;
import org.bukkit.event.HandlerList;

public class CrownPlayerJoinEvent extends CrownEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final PlayerContext context;

    public CrownPlayerJoinEvent(PlayerContext context) {
        this.context = context;
    }

    public PlayerContext getContext() {
        return context;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
