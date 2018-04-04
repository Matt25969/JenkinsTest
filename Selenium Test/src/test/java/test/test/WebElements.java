package test.test;

public enum WebElements {

	ADDAUSER(
			"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"), testUsernameField(
					"body > table > tbody > tr > td.auto-style1 > form > div > center > table >tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1)> td:nth-child(2) > p > input"), testPasswordField(
							"body > table > tbody > tr > td.auto-style1> form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2)> td:nth-child(2) > p > input[type=\"password\"]"), testButton(
									"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"), login(
											"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"), loginUsernameField(
													"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p "
															+ "> input"), loginPasswordField(
																	"body > table > tbody > tr > td.auto-style1 > form > div "
																			+ "> center > table > tbody"
																			+ " > tr > td:nth-child(1) > table > tbody > tr:nth-child(2)"
																			+ " > td:nth-child(2) > p "
																			+ "> input[type=\"password\"]"), loginButton(
																					"body > table > tbody > tr > td.auto-style1 > form "
																							+ "> div > center > table > tbody >"
																							+ " tr > td:nth-child(1) > table > tbody > tr:nth-child(3) "
																							+ "> td:nth-child(2) > p >"
																							+ " input[type=\"button\"]"), loginMessage(
																									"body > table > tbody > tr > td.auto-style1 > big > blockquote "
																											+ "> blockquote > font"
																											+ " > center > b");

	final String value;

	WebElements(String value) {

		this.value = value;
	}

}
