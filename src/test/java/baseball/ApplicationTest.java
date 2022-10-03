package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_3개_매칭_테스트() {
        assertEquals(123, 123);
    }

    @Test
    void Randoms_pickNumberInRange_사용_테스트() {
        // give
        final int startInclusive = 1;
        final int endInclusive = 9;
        final int gameNumbersLen = 3;
        final Set<Integer> gameNumberSet = new HashSet<>();

        // when
        do {
            gameNumberSet.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
        } while (gameNumberSet.size() < gameNumbersLen);

        // then
        assertEquals(gameNumbersLen, gameNumberSet.size());
        System.out.println(gameNumberSet);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
