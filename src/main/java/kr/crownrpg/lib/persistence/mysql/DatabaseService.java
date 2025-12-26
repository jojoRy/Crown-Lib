package kr.crownrpg.lib.persistence.mysql;

import java.util.concurrent.CompletableFuture;

public interface DatabaseService {
    CompletableFuture<Void> connect();
    CompletableFuture<Void> disconnect();
    boolean isConnected();
}
