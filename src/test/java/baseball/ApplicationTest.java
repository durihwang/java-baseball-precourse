package baseball;

import baseball.model.NumberBaseballModel;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 검증_테스트_성공() {

        // 1볼 1스트라이크 테스트
        int[] computerNumberArray = {5, 3, 7};
        int[] userNumberArray = {5, 1, 3};

        NumberBaseballModel numberBaseballModel = new NumberBaseballModel();
        int[] ints = numberBaseballModel.verifyNumber(computerNumberArray, userNumberArray);

        Assertions.assertThat(ints[0]).isEqualTo(1);
        Assertions.assertThat(ints[1]).isEqualTo(1);
    }

    @Test
    void 검증_테스트_예외() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            int[] computerNumberArray = {5, 3, 7, 2};
            int[] userNumberArray = {5, 1, 3};

            NumberBaseballModel numberBaseballModel = new NumberBaseballModel();
            int[] ints = numberBaseballModel.verifyNumber(computerNumberArray, userNumberArray);
        });
    }
}
