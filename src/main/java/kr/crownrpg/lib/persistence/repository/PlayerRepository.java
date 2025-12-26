package kr.crownrpg.lib.persistence.repository;

import kr.crownrpg.lib.persistence.model.PlayerSnapshot;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PlayerRepository {
    CompletableFuture<Void> save(PlayerSnapshot snapshot);
    CompletableFuture<Optional<PlayerSnapshot>> find(UUID uuid);
    CompletableFuture<Void> delete(UUID uuid);
}
