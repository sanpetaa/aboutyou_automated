package utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;

public class Functions extends BaseTest {

	public static void fetchProducts(int price) {

		List<WebElement> list_of_products = driver.findElements(By.xpath("//p[@data-testid='brandName']"));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath("//span[@data-testid='finalPrice']"));

		// Use of HashMaop to store Products and Their prices(after conversion to
		// Integer)
		String product_name;
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products = new HashMap<Integer, String>();
		{

			for (int i = 0; i < list_of_products.size(); i++) {

				product_name = list_of_products.get(i).getText();// Iterate and fetch product name
				product_price = list_of_products_price.get(i).getText();// Iterate and fetch product price
				product_price = product_price.replaceAll("[^0-9]", "");// Replace anything will space other than numbers
				int_product_price = Integer.parseInt(product_price);// Convert to Integer
				map_final_products.put(int_product_price, product_name);// Add product and price in HashMap
			}

			Reporter.log("\n\nÁr/ termék: " + map_final_products.toString(), true);

			// Get all the keys from Hash Map
			Set<Integer> allkeys = map_final_products.keySet();
			ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);

			// this will sort in ascending order lowest at the top and highest at the bottom
			Collections.sort(array_list_values_product_prices);

			// Highest Product is
			int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size() - 1);

			// Low price is
			int low_price = array_list_values_product_prices.get(0);

			Reporter.log("\nLegmagasabb ár: " + high_price + " Termék:" + map_final_products.get(high_price), true);
			Reporter.log("Legalacsonyabb ár: " + low_price + " Termék: " + map_final_products.get(low_price), true);

			int count = 0;
			for (int i = 0; array_list_values_product_prices.get(i) < array_list_values_product_prices
					.get(array_list_values_product_prices.size() - 1); i++) {
				if (array_list_values_product_prices.get(i) <= price) {
					Reporter.log(
							"\nVan termék " + price + " HUF alatt: " + array_list_values_product_prices.get(i) + " HUF,"
									+ " Termék: " + map_final_products.get(array_list_values_product_prices.get(i)) + "\n\n",
							true);
					count++;
				} else;
			}
			if (count == 0) {
				System.out.println("\nNem találtunk " +price+ " alatt terméket.\n\n");
				Assert.fail();
			}

		}

	}

}
