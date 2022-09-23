package testcase;

import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Elements;
import utilities.Functions;

public class CheckPremiums extends BaseTest {

	@Test
	public static void checkPoloShirts() throws InterruptedException {
		Elements.premium();
		Elements.poloingek();
		Elements.meret();
		Elements.rendezes();
		Elements.scrollDown();
		Functions.fetchProducts(10000);
	}
}