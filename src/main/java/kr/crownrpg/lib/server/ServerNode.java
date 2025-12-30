package kr.crownrpg.lib.server;

// 서버 식별자와 유형을 함께 담는 불변 레코드.
public record ServerNode(String nodeId, ServerType type) {}
