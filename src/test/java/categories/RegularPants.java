package categories;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Elements;
import utilities.Functions;
import utilities.Moves;

public class RegularPants extends BaseTest {

	@Test
	public static void regularPants() throws InterruptedException, IOException {
		Elements.acceptCookies();
		Elements.ruhazat();
		Elements.nadragok();
		Elements.nadragmeret();
		Elements.rendezes();
		Moves.scrollHome();
		Functions.fetchProducts(6000);
	}

}
