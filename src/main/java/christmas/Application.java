package christmas;

import controller.ChristmasEventPlannerController;

public class Application {
	public static void main(String[] args) {
		ChristmasEventPlannerController christmasEventPlannerController = new ChristmasEventPlannerController();
		christmasEventPlannerController.run();
	}
}
