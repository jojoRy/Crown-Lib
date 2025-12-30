package kr.crownrpg.lib.persistence.repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

// 문자열 기반 키-값 저장소에 대한 비동기 접근 인터페이스.
public interface KeyValueRepository {
    CompletableFuture<Void> put(String key, String value);
    CompletableFuture<Optional<String>> get(String key);
    CompletableFuture<Void> delete(String key);
}
