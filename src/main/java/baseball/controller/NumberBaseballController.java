package baseball.controller;

import baseball.model.NumberBaseballModel;
import baseball.view.NumberBaseballView;

public class NumberBaseballController {

    public void run() {

        NumberBaseballModel numberBaseballModel = new NumberBaseballModel();
        String computerNumber = numberBaseballModel.createComputerNumber();

        NumberBaseballView numberBaseballView = new NumberBaseballView();
        String userNumber = numberBaseballView.getUserNumber();

        System.out.println(userNumber);
        System.out.println(computerNumber);

    }
}
