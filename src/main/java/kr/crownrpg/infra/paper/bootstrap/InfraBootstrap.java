package kr.crownrpg.infra.paper.bootstrap;

import kr.crownrpg.lib.messaging.CrownMessageBus;
import kr.crownrpg.lib.persistence.repository.PlayerRepository;
import kr.crownrpg.lib.service.ServiceRegistry;
import org.jetbrains.annotations.NotNull;

/**
 * Bootstraps infrastructure services for the Paper runtime.
 * <p>
 * All service registrations must be explicit to keep type-safety and
 * to follow the CrownLib contract.
 */
public final class InfraBootstrap {

    private final CrownMessageBus messageBus;
    private final PlayerRepository playerRepository;

    public InfraBootstrap(@NotNull CrownMessageBus messageBus, @NotNull PlayerRepository playerRepository) {
        this.messageBus = messageBus;
        this.playerRepository = playerRepository;
    }

    public void registerServices() {
        ServiceRegistry.register(CrownMessageBus.class, messageBus);
        ServiceRegistry.register(PlayerRepository.class, playerRepository);
    }
}
