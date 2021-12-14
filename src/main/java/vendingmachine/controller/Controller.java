package vendingmachine.controller;

import java.util.Arrays;

import vendingmachine.domain.Money;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
	public void runMachine() {
		//메인로직 시작
		VendingMachine vendingMachine = VendingMachine.getInstance();
		vendingMachine.init();

		OutputView.printInputMachineMoneyInstruction(); //자판기가 보유하고 있는 금액을 입력해 주세요.
		// Money money = Money.of(InputView.getMoney());
		Money machineMoney = Money.of("450");
		vendingMachine.insertMachineMoney(machineMoney);
		OutputView.printResultOfGenerateCoins(vendingMachine.generateCoins());

		OutputView.printInputProductsInstruction(); //상품명과 가격, 수량을 입력해 주세요.
		// Products products = Products.from(InputView.getProducts());//[콜라,1500,20];[사이다,1000,10]
		Products products = Products.from(Arrays.asList("콜라,1500,20", "사이다,1000,10"));
		vendingMachine.insertProducts(products);

		OutputView.printInputUserMoneyInstruction(); //투입 금액을 입력해 주세요.
		// Money userMoney = Money.of(InputView.getMoney());
		Money userMoney = Money.of("3000");
		OutputView.printResultOfInputUserMoney(userMoney);
		vendingMachine.insertUserMoney(userMoney);

		OutputView.printInputPurchaseProductNameInstruction(); //구매할 상품명을 입력해 주세요.
		InputView.getProductName();

	}
}
