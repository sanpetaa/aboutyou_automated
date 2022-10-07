package categories;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import elements.Elements;
import functions.FetchProductPrice;
import utilities.ConsoleOutput;

public class RegularPants extends BaseTest {

	@Test
	public static void regularPants() throws InterruptedException, IOException {
		Elements.acceptCookies();
		Elements.ferfi();
		Elements.ruhazat();
		Elements.nadragok();
		Elements.meret();
		Elements.nadragmeret();
		Elements.akcios();
		Elements.rendezesLegalacsonyabbAr();
		ConsoleOutput.consoleOutputOLD();
		ConsoleOutput.consoleOutputNEW();
		FetchProductPrice.fetchProductPrice(4000);
		ConsoleOutput.consoleOutputParse();
		ConsoleOutput.consoleOutputCopy();
	}
}