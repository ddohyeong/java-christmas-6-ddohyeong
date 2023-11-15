package message;

public enum RegexMessage {
	ORDER_MENUS_REGEX("^[^,-]+-[^,-]+(,[^,-]+-[^,-]+)*$"),
	ORDER_MENU_REGEX("^[가-힣]+-\\d+$"),
	DIGIT("^[0-9]+$"),
	COMMA(","),
	HYPHEN("-");

	private final String regex;

	RegexMessage(String regex) {
		this.regex = regex;
	}

	public String getRegex() {
		return regex;
	}
}
