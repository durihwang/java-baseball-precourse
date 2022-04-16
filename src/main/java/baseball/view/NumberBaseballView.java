package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {

    public String getUserNumber() {

        System.out.print("숫자를 입력해 주세요: ");
        String userNumber = Console.readLine();

        // 3자리 이상인지 체크
        if (userNumber.length() > 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        // 숫자인지 체크
        if (!userNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        return userNumber;
    }

    public String sendResultFail() {
        return "";
    }

    public String sendResultSuccess() {
        return "";
    }
}
