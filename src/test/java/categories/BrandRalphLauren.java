package categories;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import elements.Elements;
import elements.ElementsBrandSearch;
import functions.FetchProductPriceforBrands;
import utilities.ConsoleOutput;

public class BrandRalphLauren extends BaseTest {

	@Test
	public static void brandRalphLauren() throws InterruptedException, IOException {
		Elements.acceptCookies();
		Elements.ferfi();
		Elements.markak();
		Elements.clickAway();
		ElementsBrandSearch.poloRalphLauren();
		ElementsBrandSearch.brandSearchMeret();
		ElementsBrandSearch.brandSearchM();
		ElementsBrandSearch.brandSearchCipoMeret();
		ElementsBrandSearch.brandSearchAkcios();
		ElementsBrandSearch.brandSearchRendezesLegalacsonyabbAr();
		ConsoleOutput.consoleOutputOLD();
		ConsoleOutput.consoleOutputNEW();
		FetchProductPriceforBrands.fetchProductPriceforBrands(12500);
		ConsoleOutput.consoleOutputParse();
		ConsoleOutput.consoleOutputCopy();
	}
}
