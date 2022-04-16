package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballModel {

    public String createComputerNumber() {

        // 3개의 숫자 생성
        String number1 = String.valueOf(Randoms.pickNumberInRange(1, 9));
        String number2 = String.valueOf(Randoms.pickNumberInRange(1, 9));
        String number3 = String.valueOf(Randoms.pickNumberInRange(1, 9));

        return number1 + number2 + number3;
    }

    public void verifyNumber(String computerNumber, String userNumber) {

    }
}
