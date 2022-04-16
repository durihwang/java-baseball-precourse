package baseball;

import baseball.controller.NumberBaseballController;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 컨트롤러 실행
        new NumberBaseballController().run();
    }
}
