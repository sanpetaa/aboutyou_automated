package utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class Functions extends BaseTest {


	public static void fetchProducts(int price) throws InterruptedException, IOException {

		Thread.sleep(1500);
		List<WebElement> list_of_products = driver.findElements(By.xpath(loc.getProperty("brandName")));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath(loc.getProperty("finalPrice")));

		// Use of HashMaop to store Products and Their prices(after conversion to
		// Integer)
		String product_name;
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products = new HashMap<>();
		{

			for (int i = 0; i < list_of_products.size(); i++) {

				product_name = list_of_products.get(i).getText();// Iterate and fetch product name
				product_price = list_of_products_price.get(i).getText();// Iterate and fetch product price
				product_price = product_price.replaceAll("[^0-9]", "");// Replace anything will space other than numbers
				int_product_price = Integer.parseInt(product_price);// Convert to Integer
				map_final_products.put(int_product_price, product_name);// Add product and price in HashMap
			}

			Reporter.log("\nAll the prices and products we found: " + map_final_products.toString(), true);

			// Get all the keys from Hash Map
			Set<Integer> allkeys = map_final_products.keySet();
			ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);

			// this will sort in ascending order lowest at the top and highest at the bottom
			Collections.sort(array_list_values_product_prices);

			// Highest Product is
			int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size() - 1);

			// Low price is
			int low_price = array_list_values_product_prices.get(0);

			Reporter.log(
					"\nHighest price: " + high_price + ",-HUF. " + " Product: " + map_final_products.get(high_price),
					true);
			Reporter.log(
					"Lowest price: " + low_price + ",-HUF. " + " Product: " + map_final_products.get(low_price) + "\n",
					true);

			int count = 0;
			for (int i = 0; array_list_values_product_prices.get(i) < array_list_values_product_prices
					.get(array_list_values_product_prices.size() - 1); i++) {
				if (array_list_values_product_prices.get(i) <= price) {
					Reporter.log("We found a product for " + price + ",-HUF. " + " The product is: "
							+ map_final_products.get(array_list_values_product_prices.get(i)) + " Actual Price: "
							+ array_list_values_product_prices.get(i) + ",-HUF,"+ "\n", true);

					count++;
				} else
					;
			}

			if (count == 0) {
				System.out.println("\nWe didn't find any product below " + price + ",-HUF\n");

				Assert.fail();
			} else {
				for (int row = 1; row <= count; row++) {

					// WebElement element =
					// driver.findElement(By.xpath("//*[@aria-label='Term\u00E9kek']/div/ul/li[" +
					// row + "]/a"));
					WebElement element = driver.findElement(By.xpath(
							"//html/body/main/div[2]/div[3]/section/div[2]/section/section[2]/div[1]/ul/li["+ row + "]/a/div[1]/img"));
					Screenshot Screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
							.takeScreenshot(driver, element);
					ImageIO.write(Screenshot.getImage(), "png",
							new File(System.getProperty("user.dir") + "\\screenshots\\Screenshot_" + row + ".png"));
				}
			}
		}
	}
}
