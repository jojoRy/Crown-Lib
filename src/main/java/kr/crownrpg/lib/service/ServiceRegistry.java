package kr.crownrpg.lib.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 런타임에 사용할 서비스 인스턴스를 등록·조회하는 간단한 레지스트리.
public final class ServiceRegistry {

    private static final Map<Class<?>, Object> SERVICES = new ConcurrentHashMap<>();

    private ServiceRegistry() {}

    // 레지스트리 초기화: 기존 등록된 모든 서비스를 제거한다.
    public static void init() {
        SERVICES.clear();
    }

    // 서비스 구현체를 타입 키와 함께 등록한다.
    public static <T> void register(Class<T> type, T service) {
        SERVICES.put(type, service);
    }

    // 등록된 서비스를 타입으로 조회한다. 형 변환 경고를 억제한다.
    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> type) {
        return (T) SERVICES.get(type);
    }

    // 특정 타입의 서비스가 등록되어 있는지 확인한다.
    public static boolean has(Class<?> type) {
        return SERVICES.containsKey(type);
    }

    // 모든 서비스 등록을 해제한다.
    public static void clear() {
        SERVICES.clear();
    }
}