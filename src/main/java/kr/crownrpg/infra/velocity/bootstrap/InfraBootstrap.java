package kr.crownrpg.infra.velocity.bootstrap;

import kr.crownrpg.lib.messaging.CrownMessageBus;
import kr.crownrpg.lib.persistence.repository.PlayerRepository;
import org.jetbrains.annotations.NotNull;

/**
 * Bootstraps infrastructure services for the Velocity runtime.
 * <p>
 * Velocity manages its infrastructure services directly without delegating to
 * the CrownLib {@code ServiceRegistry}. The runtime can obtain the prepared
 * services via the provided accessors.
 */
public final class InfraBootstrap {

    private final CrownMessageBus messageBus;
    private final PlayerRepository playerRepository;

    public InfraBootstrap(@NotNull CrownMessageBus messageBus, @NotNull PlayerRepository playerRepository) {
        this.messageBus = messageBus;
        this.playerRepository = playerRepository;
    }

    public CrownMessageBus messageBus() {
        return messageBus;
    }

    public PlayerRepository playerRepository() {
        return playerRepository;
    }
}
