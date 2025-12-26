package kr.crownrpg.lib.persistence.repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface KeyValueRepository {
    CompletableFuture<Void> put(String key, String value);
    CompletableFuture<Optional<String>> get(String key);
    CompletableFuture<Void> delete(String key);
}
