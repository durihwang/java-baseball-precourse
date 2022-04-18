package baseball.controller;

import baseball.model.NumberBaseballModel;
import baseball.view.NumberBaseballView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class NumberBaseballController {

    public void run() {

        // model, view 초기화
        NumberBaseballModel numberBaseballModel = new NumberBaseballModel();
        NumberBaseballView numberBaseballView = new NumberBaseballView();

        // 입력값 가져오기
        String userNumber = numberBaseballView.getReadLine();

        // 컴퓨터, 사용자 숫자 세팅
        int[] computerNumberArray = numberBaseballModel.createComputerNumber();
        int[] userNumberArray = numberBaseballView.getUserNumber(userNumber);

        // 최초 판별
        int[] countArray = numberBaseballModel.verifyNumber(computerNumberArray, userNumberArray);
        int strike = countArray[0];
        int ball = countArray[1];
        numberBaseballView.sendResult(strike, ball);

        // 3스트라이크 나올 때 까지 판별
        while (strike != 3) {

            // 입력값 가져오기
            userNumber = numberBaseballView.getReadLine();

            int[] nextCountArray = numberBaseballModel.verifyNumber(computerNumberArray, numberBaseballView.getUserNumber(userNumber));
            strike = nextCountArray[0];
            ball = nextCountArray[1];
            numberBaseballView.sendResult(strike, ball);
        }
    }
}
