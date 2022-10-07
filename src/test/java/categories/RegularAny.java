package categories;

import java.io.IOException;

import org.testng.annotations.Test;


import base.BaseTest;
import elements.Elements;
import functions.FetchProductLast30DaysPrice;
import utilities.ConsoleOutput;

public class RegularAny extends BaseTest{

	@Test
	public static void regularAny() throws InterruptedException, IOException {
		
		Elements.acceptCookies();
		Elements.ferfi();
		Elements.ruhazat();
		Elements.meret();
		Elements.M();
		Elements.nadragmeret();
		Elements.akcios();
		Elements.rendezesLegnagyobbAkciok();
		ConsoleOutput.consoleOutputOLD();
		ConsoleOutput.consoleOutputNEW();
		FetchProductLast30DaysPrice.fetchProductLast30DaysPrice(20000);
		ConsoleOutput.consoleOutputParse();
		ConsoleOutput.consoleOutputCopy();
	}
	
}
