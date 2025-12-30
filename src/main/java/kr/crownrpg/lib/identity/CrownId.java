package kr.crownrpg.lib.identity;

// 라이브러리에서 공통적으로 사용하는 식별자 타입의 인터페이스.
public interface CrownId {
    // 실제 식별자 문자열을 반환한다.
    String value();
}