package kr.crownrpg.lib.persistence.redis;

import java.util.concurrent.CompletableFuture;

// Redis와의 연결 및 Pub/Sub 기능을 추상화한 서비스 인터페이스.
public interface RedisService {
    CompletableFuture<Void> connect();
    CompletableFuture<Void> disconnect();
    CompletableFuture<Void> publish(String channel, String message);
    CompletableFuture<Void> subscribe(String channel);
}
