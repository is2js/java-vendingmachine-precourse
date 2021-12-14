package vendingmachine.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Util;
import vendingmachine.utils.Validators;

public class InputView {

	public static String getInput() {
		return Console.readLine();
	}

	public static String getMoney() {
		try {
			String inputValue = InputView.getInput();
			checkMoneyValidation(inputValue);
			return inputValue;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMoney();
		}
	}

	private static void checkMoneyValidation(String inputValue) {
		Validators.checkNullOrEmpty(inputValue);
		Validators.checkValidFormatOfMoney(inputValue);
		Validators.checkValidRangeMoney(inputValue);
		Validators.checkValidMoney(inputValue);
	}

	public static List<String> getProducts() {
		try {
			String inputValue = Util.removeSpace(InputView.getInput());
			checkProductsValidation(inputValue, Validators.DELIMETER);
			inputValue = inputValue.replaceAll("\\[|]", "");
			return Arrays.asList(inputValue.split(Validators.DELIMETER));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return InputView.getProducts();
		}
	}

	private static void checkProductsValidation(String inputValue, String delimeter) {
		Validators.checkNullOrEmpty(inputValue);
		Validators.checkValidFirstValue(inputValue, delimeter);
		Validators.checkPatternOfProduct(inputValue, delimeter, "\\[([가-힣]+),([0-9]+),([0-9]+)\\]");
	}

}
