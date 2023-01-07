package categories;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import elements.Elements;
import functions.FetchProductLast30Days;
import utilities.ConsoleOutput;

public class AnyProductsLast30Days extends BaseTest{

	@Test
	public static void anyProductsLast30Days() throws InterruptedException, IOException {
		Elements.acceptCookies();
		Elements.ferfi();
		Elements.ruhazat();
		//Elements.nadragok();
		Elements.meret();
		Elements.nadragmeret();
		Elements.akcios();
		Elements.rendezesLegnagyobbAkciok();
		ConsoleOutput.consoleOutputOLD();
		ConsoleOutput.consoleOutputNEW();
		FetchProductLast30Days.fetchProductLast30Days(20000,0); //price, last30daysdiscount percentage
		ConsoleOutput.consoleOutputParse();
		ConsoleOutput.consoleOutputCopy();
	}

}
