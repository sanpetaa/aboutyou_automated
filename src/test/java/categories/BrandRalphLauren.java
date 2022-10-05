package categories;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import elements.Elements;
import elements.ElementsBrandSearch;
import functions.FunctionsBrandSearch;
import utilities.ConsoleOutput;

public class BrandRalphLauren  extends BaseTest{

	@Test
	public static void brandRalphLauren() throws InterruptedException, IOException {
		Elements.acceptCookies();
		Elements.markak();
		ElementsBrandSearch.poloRalphLauren();
		ElementsBrandSearch.brandSearchMeret();
		ElementsBrandSearch.brandSearchM();
		ElementsBrandSearch.brandSearchCipoMeret();
		ElementsBrandSearch.brandSearchRendezes();
		ElementsBrandSearch.brandSearchAr();
		ElementsBrandSearch.brandSearchAkcios();
		ConsoleOutput.consoleOutputOLD();
		ConsoleOutput.consoleOutputNEW();
		FunctionsBrandSearch.fetchProductsBrandSearch(12000);
		ConsoleOutput.consoleOutputParse();
		ConsoleOutput.consoleOutputCopy();
	}
}