package kr.crownrpg.lib.service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class ServiceRegistry {

    private static final Map<Class<?>, Object> SERVICES = new ConcurrentHashMap<>();
    // SAFETY FIX
    private static volatile boolean initialized = false;

    // SAFETY FIX
    private static void ensureInitialized() {
        if (!initialized) {
            throw new IllegalStateException("ServiceRegistry.init() must be called before use");
        }
    }

    private ServiceRegistry() {}

    public static void init() {
        SERVICES.clear();
        // SAFETY FIX
        initialized = true;
    }

    public static <T> void register(Class<T> type, T service) {
        // SAFETY FIX
        ensureInitialized();
        Object previous = SERVICES.putIfAbsent(type, service); // SAFETY FIX
        if (previous != null) {
            throw new IllegalStateException("Service already registered: " + type.getName());
        }
    }

    // SAFETY FIX
    public static <T> void registerOnce(Class<T> type, T instance) {
        ensureInitialized();
        Object previous = SERVICES.putIfAbsent(type, instance); // SAFETY FIX
        if (previous != null) {
            throw new IllegalStateException("Service already registered: " + type.getName());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> type) {
        // SAFETY FIX
        ensureInitialized();
        T service = (T) SERVICES.get(type);
        if (service == null) {
            throw new IllegalStateException("Service not registered: " + type.getName());
        }
        return service;
    }

    // SAFETY FIX
    @SuppressWarnings("unchecked")
    public static <T> Optional<T> find(Class<T> type) {
        ensureInitialized();
        return Optional.ofNullable((T) SERVICES.get(type));
    }

    public static boolean has(Class<?> type) {
        ensureInitialized();
        return SERVICES.containsKey(type);
    }

    // SAFETY FIX
    public static boolean isRegistered(Class<?> type) {
        ensureInitialized();
        return SERVICES.containsKey(type);
    }

    public static void clear() {
        // SAFETY FIX
        initialized = false;
        SERVICES.clear();
    }
}
