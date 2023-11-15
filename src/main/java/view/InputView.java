package view;

import static message.InputMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public String enterReservationDate() {
		System.out.println(INPUT_RESERVATION_DATE.getMessage());
		return Console.readLine();
	}

	public String enterOrderMenus() {
		System.out.println(INPUT_ORDER_MENUS.getMessage());
		return Console.readLine();
	}
}
