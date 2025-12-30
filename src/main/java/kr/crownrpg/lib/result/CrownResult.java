package kr.crownrpg.lib.result;

// 성공 여부와 실패 사유를 함께 전달하는 결과 객체.
public record CrownResult(
        boolean success,
        String reason
) {

    // 성공 결과를 반환한다.(메시지 없음)
    public static CrownResult ok() {
        return new CrownResult(true, null);
    }

    // 성공 결과와 추가 메시지를 반환한다.
    public static CrownResult ok(String reason) {
        return new CrownResult(true, reason);
    }

    // 실패 결과와 실패 사유를 반환한다.
    public static CrownResult fail(String reason) {
        return new CrownResult(false, reason);
    }
}