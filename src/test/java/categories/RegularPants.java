package categories;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ConsoleOutput;
import utilities.Elements;
import utilities.Functions;

public class RegularPants extends BaseTest {

	@Test
	public static void regularPants() throws InterruptedException, IOException {
		Elements.acceptCookies();
		Elements.ruhazat();
		Elements.nadragok();
		Elements.meret();
		Elements.nadragmeret();
		Elements.akcios();
		Elements.rendezes();
		ConsoleOutput.consoleOutputOLD();
		ConsoleOutput.consoleOutputNEW();
		Functions.fetchProducts(5000);
		ConsoleOutput.consoleOutputParse();
		ConsoleOutput.consoleOutputCopy();
	}
}