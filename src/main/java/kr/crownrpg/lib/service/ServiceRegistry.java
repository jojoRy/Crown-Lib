package kr.crownrpg.lib.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ServiceRegistry {

    private static final Map<Class<?>, Object> SERVICES = new ConcurrentHashMap<>();

    private ServiceRegistry() {}

    public static void init() {
        SERVICES.clear();
    }

    public static <T> void register(Class<T> type, T service) {
        SERVICES.put(type, service);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> type) {
        return (T) SERVICES.get(type);
    }

    public static boolean has(Class<?> type) {
        return SERVICES.containsKey(type);
    }

    public static void clear() {
        SERVICES.clear();
    }
}
