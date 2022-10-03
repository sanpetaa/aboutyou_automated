package utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class Functions extends BaseTest {

	public static void fetchProducts(int price) throws InterruptedException, IOException {

		SoftAssert softassert = new SoftAssert();

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

			// write out all the products we found
			// Reporter.log("\nAll the prices and products we found: " +
			// map_final_products.toString(), true);

			// Get all the keys from Hash Map
			Set<Integer> allkeys = map_final_products.keySet();
			ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);

			// this will sort in ascending order lowest at the top and highest at the bottom
			Collections.sort(array_list_values_product_prices);

			// Highest Product is
			// int high_price =
			// array_list_values_product_prices.get(array_list_values_product_prices.size()
			// - 1);

			// Low price is
			// int low_price = array_list_values_product_prices.get(0);

			// Reporter.log("\nHighest price: " + high_price + ",-HUF. " + " Product: " +
			// map_final_products.get(high_price),true);
			// Reporter.log("Lowest price: " + low_price + ",-HUF. " + " Product: " +
			// map_final_products.get(low_price) + "\n",true);
			
			int count = 0;
			int href_count = 1;
			for (int i = 0; array_list_values_product_prices.get(i) < array_list_values_product_prices
					.get(array_list_values_product_prices.size() - 1); i++) {
				if (array_list_values_product_prices.get(i) <= price) {
					WebElement product_link = driver.findElement(By.xpath(".//*[@aria-label='Term\u00E9kek']/div/ul/li[" + href_count + "]/a"));
					String href = product_link.getAttribute("href");
					Reporter.log(
							"We found a product for less than " + price + ",-HUF. " + " which is: "
									+ map_final_products.get(array_list_values_product_prices.get(i))
									+ " Price: " + array_list_values_product_prices.get(i) + ",-HUF," + "\n" + "The product link is: " + href +  "\n",
							true);

					count++;
					href_count++;
				} else
					;
			}

			if (count == 0) {
				System.out.println("\nWe didn't find any product anymore for you below " + price + ",-HUF\n");
				softassert.assertNotEquals(count, 0);

			} else {
				//save the jpg
				for (int row = 1; row <= count; row++) {

					WebElement product_image = driver.findElement(
							By.xpath(".//*[@aria-label='Term\u00E9kek']/div/ul/li[" + row + "]/a/div/img"));
					String srcset = product_image.getAttribute("srcset");
					URL imageURL = new URL(srcset);
					BufferedImage saveImage = ImageIO.read(imageURL);
					ImageIO.write(saveImage, "png",
							new File(System.getProperty("user.dir") + "\\screenshots\\screenshot_" + row + ".png"));
				}
			}
			ConsoleOutput.assertAll();
		}
		
		//take a screenshot//old part of the code 
		/*
		  			if (count == 0) {
				System.out.println("\nWe didn't find any product anymore for you below " + price + ",-HUF\n");
				softassert.assertNotEquals(count,0);
				
			} else {
				for (int row = 1; row <= count; row++) {

					// WebElement element =
					// driver.findElement(By.xpath("//*[@aria-label='Term\u00E9kek']/div/ul/li[" + row + "]/a"));
					WebElement element = driver.findElement(
							By.xpath("//*[@aria-label='Term\u00E9kek']/div/ul/li[" + row + "]"));
					////*[@aria-label='Term\u00E9kek']/div/ul/li[" + row + "]
					Screenshot Screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
							.takeScreenshot(driver, element);
					ImageIO.write(Screenshot.getImage(), "png",
							new File(System.getProperty("user.dir") + "\\screenshots\\Screenshot_" + row + ".png"));
				}
			}
			ConsoleOutput.assertAll();
		}
		*/
	}
}
