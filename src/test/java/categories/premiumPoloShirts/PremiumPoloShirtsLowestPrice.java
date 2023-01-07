package categories.premiumPoloShirts;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import elements.Elements;
import functions.FetchProductPrice;
import utilities.ConsoleOutput;

public class PremiumPoloShirtsLowestPrice extends BaseTest {

@Test
	public static void premiumPoloShirtsLowestPrice() throws InterruptedException, IOException {
		Elements.acceptCookies();
		Elements.ferfi();
		Elements.premium();
		Elements.poloingek();
		Elements.meret();
		Elements.M();
		Elements.akcios();
		Elements.rendezesLegalacsonyabbAr();
		ConsoleOutput.consoleOutputOLD();
		ConsoleOutput.consoleOutputNEW();
		FetchProductPrice.fetchProductPrice(10000);
		ConsoleOutput.consoleOutputParse();
		ConsoleOutput.consoleOutputCopy();
	}
}