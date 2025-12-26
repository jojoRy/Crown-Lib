package kr.crownrpg.lib.result;

public record CrownResult(
        boolean success,
        String reason
) {

    public static CrownResult ok() {
        return new CrownResult(true, null);
    }

    public static CrownResult ok(String reason) {
        return new CrownResult(true, reason);
    }

    public static CrownResult fail(String reason) {
        return new CrownResult(false, reason);
    }
}
