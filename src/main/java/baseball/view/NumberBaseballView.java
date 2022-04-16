package baseball.view;

import baseball.controller.NumberBaseballController;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {

    public String getReadLine() {

        System.out.print("숫자를 입력해 주세요: ");
        String userNumber = Console.readLine();
        System.out.println(userNumber);

        return userNumber;
    }

    public int[] getUserNumber(String userNumber) {

        int[] userNumberArray = new int[3];

        // 3자리 이상인지 체크
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        // 숫자인지 체크
        if (!userNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        char[] charArray = userNumber.toCharArray();
        userNumberArray[0] = charArray[0] - '0';
        userNumberArray[1] = charArray[1] - '0';
        userNumberArray[2] = charArray[2] - '0';

        return userNumberArray;
    }

    public void sendResult(int resultStrike, int resultBall) {

        if (resultStrike == 3) {
            sendResultSuccess();
            return;
        }

        if (resultStrike > 0 && resultBall == 0) {
            System.out.println(resultStrike + "스트라이크");
        }

        if (resultBall > 0 && resultStrike == 0) {
            System.out.println(resultBall + "볼");
        }

        if (resultStrike > 0 && resultBall > 0) {
            System.out.println(resultBall + "볼 " + resultStrike + "스트라이크");
        }

        if (resultStrike == 0 && resultBall == 0) {
            System.out.println("낫싱");
        }
    }

    public void sendResultSuccess() {

        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());

        if (choice == 1) {
            NumberBaseballController numberBaseballController = new NumberBaseballController();
            numberBaseballController.run();
        }
    }
}
