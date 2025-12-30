package kr.crownrpg.lib.persistence.mysql;

import java.util.concurrent.CompletableFuture;

// MySQL 등 관계형 데이터베이스 연결을 관리하는 서비스 인터페이스.
public interface DatabaseService {
    CompletableFuture<Void> connect();
    CompletableFuture<Void> disconnect();
    boolean isConnected();
}
