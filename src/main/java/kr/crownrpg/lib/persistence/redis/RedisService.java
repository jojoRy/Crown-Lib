package kr.crownrpg.lib.persistence.redis;

import java.util.concurrent.CompletableFuture;

public interface RedisService {
    CompletableFuture<Void> connect();
    CompletableFuture<Void> disconnect();
    CompletableFuture<Void> publish(String channel, String message);
    CompletableFuture<Void> subscribe(String channel);
}
