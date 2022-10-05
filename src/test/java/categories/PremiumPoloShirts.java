package categories;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ConsoleOutput;
import utilities.Elements;
import utilities.Functions;

public class PremiumPoloShirts extends BaseTest {

	@Test
	public static void premiumPoloShirts() throws InterruptedException, IOException {
		Elements.acceptCookies();
		Elements.premium();
		Elements.poloingek();
		Elements.meret();
		Elements.M();
		Elements.akcios();
		Elements.rendezes();
		ConsoleOutput.consoleOutputOLD();
		ConsoleOutput.consoleOutputNEW();
		Functions.fetchProducts(10000);
		ConsoleOutput.consoleOutputParse();
		ConsoleOutput.consoleOutputCopy();
	}
}