package kr.crownrpg.lib.persistence.repository;

import kr.crownrpg.lib.persistence.model.PlayerSnapshot;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

// 플레이어 데이터를 영속화/조회하기 위한 비동기 저장소 인터페이스.
public interface PlayerRepository {
    CompletableFuture<Void> save(PlayerSnapshot snapshot);
    CompletableFuture<Optional<PlayerSnapshot>> find(UUID uuid);
    CompletableFuture<Void> delete(UUID uuid);
}
