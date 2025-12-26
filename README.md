# CrownLib

CrownLib는 **CrownRPG 서버에서 제작되는 모든 플러그인의 공통 기반(Core / Contract Layer)** 입니다.  
이 플러그인은 기능을 제공하지 않으며, **규약·모델·인터페이스**만을 정의합니다.

> ❗ CrownLib는 Redis, MySQL, 패킷, 게임 로직을 포함하지 않습니다.  
> ❗ 모든 구현은 별도의 플러그인(infra / feature plugins)에서 이루어집니다.

---

## 🎯 목적

- 파티, 길드, 도감, 우편, 스탯, 스킬, 경제 등  
  **모든 커스텀 플러그인이 공통으로 사용하는 “언어” 제공**
- 서버 간 통신, 저장, 식별, 결과 처리의 **규약 통일**
- 구현 실수로 인한 구조 붕괴 방지
- 1인 개발 환경에서도 **장기 운영 가능한 안정성 확보**

---

## 📦 포함하는 것 / 포함하지 않는 것

### 포함하는 것 (Contracts)
- Player / Server 공통 모델
- 서비스 레지스트리
- 메시징(PubSub) 인터페이스
- 저장소(Repository) 인터페이스
- ID / Result / Scope 공통 규약
- 시간 / 로그 유틸

### ❌ 포함하지 않는 것
- Redis / MySQL 구현
- JSON 직렬화
- Bukkit / Velocity 분기 로직
- 패킷 처리
- 게임 로직 (파티, 길드, 스킬 등)

---

## 🧱 핵심 구조 개요

```text
CrownLib (this plugin)
 ├─ contracts (interfaces)
 ├─ models
 ├─ messaging rules
 └─ shared conventions

CrownInfra (separate plugin)
 ├─ Redis (Lettuce)
 ├─ MySQL (Hikari)
 └─ MessageBus implementation

Feature Plugins
 ├─ Party
 ├─ Guild
 ├─ Mail
 ├─ Codex
 └─ etc...
````

---

## 🔌 의존성

* Java 21
* Paper 1.21.8+
* 다른 플러그인에서 `depend: [CrownLib]` 설정 필수

---

## 🧩 ServiceRegistry 사용

CrownLib는 **플러그인 간 직접 참조를 금지**합니다.
모든 공통 서비스는 `ServiceRegistry`를 통해 접근합니다.

### 서비스 등록 (구현 플러그인)

```java
ServiceRegistry.register(CrownMessageBus.class, messageBus);
ServiceRegistry.register(PlayerRepository.class, playerRepository);
```

### 서비스 사용 (기능 플러그인)

```java
CrownMessageBus bus = ServiceRegistry.get(CrownMessageBus.class);
```

---

## 📡 메시징 시스템 (CrownMessage)

CrownLib는 서버 간 통신을 위해 **안전한 메시지 계약**을 제공합니다.

### 메시지 메타데이터 (강제)

* `messageId` : 중복 처리 방지
* `sourceNodeId` : 발신 서버 식별
* `createdAt` : 생성 시각

### 메시지 생성

```java
CrownMessage message = CrownMessage.create(
    localNodeId,
    CrownMessageType.PARTY_SYNC,
    Map.of("partyId", partyId)
);
```

### 메시지 발행

```java
bus.publish(CrownChannels.PARTY, message);
```

### 메시지 수신

```java
bus.registerHandler(new CrownMessageHandler() {
    @Override
    public CrownMessageType getType() {
        return CrownMessageType.PARTY_SYNC;
    }

    @Override
    public void handle(CrownMessage message) {
        // handle sync
    }
});
```

---

## 🆔 Global ID 규약

모든 도메인 ID는 동일한 규칙을 사용하는 것을 권장합니다.

```java
String partyId = CrownIds.random();
```

* 파티 ID
* 길드 ID
* 퀘스트 ID
* 도감 항목 ID
* 우편 ID 등

---

## ✅ 공통 Result 계약

강화, 제작, 보상, 우편 등 **결과 표현을 통일**합니다.

```java
return CrownResult.ok("강화에 성공했습니다");
return CrownResult.fail("재료가 부족합니다");
```

---

## 👤 PlayerScope

온라인 / 오프라인 처리 범위를 명확히 표현합니다.

```java
sendMail(targetUuid, PlayerScope.ANY, mailContent);
```

```java
public enum PlayerScope {
    ONLINE,
    OFFLINE,
    ANY
}
```

---

## 💾 저장소 계약 (Repository)

CrownLib는 **비동기 저장 계약만 정의**합니다.

```java
CompletableFuture<Optional<PlayerSnapshot>> find(UUID uuid);
CompletableFuture<Void> save(PlayerSnapshot snapshot);
```

구현은 infra 플러그인의 책임입니다.

---

## ⚠️ 설계 원칙 (중요)

* CrownLib는 **수정 빈도가 매우 낮아야 합니다**
* 기능 요구가 생기면:

    * ❌ CrownLib 수정
    * ✅ Feature Plugin에서 해결
* CrownLib는 “편의”보다 **안정성**을 우선합니다

---

## 📌 플러그인 로딩 순서

```yaml
depend:
  - CrownLib
```

CrownLib는 항상 **가장 먼저 로드**되어야 합니다.

---

## 🧪 정상 동작 확인

* CrownLib 단독으로 서버 부팅 가능
* 콘솔에 `CrownLib enabled` 출력
* 오류 없이 종료 가능

---

## 🏁 마무리

CrownLib는
**“파티 라이브러리”가 아니라 “모든 플러그인이 공유하는 공통 언어”**입니다.

이 플러그인을 기반으로:

* 도감
* 우편
* 스탯
* 스킬
* 경제
* 퀘스트

모두 **느슨하게 연결된 구조**로 개발할 수 있습니다.
