package categories.premiumPoloShirts;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import elements.Elements;
import functions.FetchProductLast30Days;

public class PremiumPoloShirtsHighestDiscount extends BaseTest {

@Test
	public static void premiumPoloShirtsHighestDiscount() throws InterruptedException, IOException {
		Elements.acceptCookies();
		Elements.ferfi();
		Elements.premium();
		Elements.poloingek();
		Elements.meret();
		Elements.M();
		Elements.akcios();
		Elements.rendezesLegnagyobbAkciok();
		//ConsoleOutput.consoleOutputOLD();
		//ConsoleOutput.consoleOutputNEW();
		FetchProductLast30Days.fetchProductLast30Days(20000, -20); // price, last30daysdiscount percentage
		//ConsoleOutput.consoleOutputParse();
		//ConsoleOutput.consoleOutputCopy();
	}
}