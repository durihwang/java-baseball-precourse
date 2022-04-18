package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballModel {

    public int[] createComputerNumber() {

        // 3개의 숫자 생성
        int[] computerNumberArray = new int[3];
        computerNumberArray[0] = Randoms.pickNumberInRange(1, 9);

        computerNumberArray[1] = Randoms.pickNumberInRange(1, 9);
        while (computerNumberArray[0] == computerNumberArray[1]) {
            computerNumberArray[1] = Randoms.pickNumberInRange(1, 9);
        }

        computerNumberArray[2] = Randoms.pickNumberInRange(1, 9);
        while (computerNumberArray[0] == computerNumberArray[2]
                || computerNumberArray[1] == computerNumberArray[2]) {
            computerNumberArray[2] = Randoms.pickNumberInRange(1, 9);
        }

        return computerNumberArray;
    }

    public int[] verifyNumber(int[] computerNumberArray, int[] userNumberArray) {

        if (computerNumberArray.length != 3 || userNumberArray.length != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        // 같은 숫자인지 체크
        if (userNumberArray[0] == userNumberArray[1]
                || userNumberArray[0] == userNumberArray[2]
                || userNumberArray[1] == userNumberArray[2]) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        // 같은 숫자인지 체크
        if (computerNumberArray[0] == computerNumberArray[1]
                || computerNumberArray[0] == computerNumberArray[2]
                || computerNumberArray[1] == computerNumberArray[2]) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        int[] countArray = new int[2];
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < userNumberArray.length; i++) {
            strikeCount += checkStrike(userNumberArray[i], computerNumberArray[i]);
            ballCount += checkBall(computerNumberArray, userNumberArray[i], i);
        }

        countArray[0] = strikeCount;
        countArray[1] = ballCount;

        return countArray;
    }

    private int checkStrike(int computerNumber, int userNumber) {

        if (computerNumber == userNumber) {
            return 1;
        }

        return 0;
    }

    private int checkBall(int[] computerNumberArray, int userNumber, int index) {

        int checkBallCount = 0;

        for (int i = 0; i < computerNumberArray.length; i++) {
            checkBallCount += isBall(computerNumberArray[i], userNumber, i, index);
        }

        return checkBallCount;
    }

    private int isBall(int computerNumber, int userNumber, int computerIndex, int userIndex) {
        if (computerIndex != userIndex && computerNumber == userNumber) {
            return 1;
        }

        return 0;
    }
}
