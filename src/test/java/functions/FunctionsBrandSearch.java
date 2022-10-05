
package functions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class FunctionsBrandSearch extends BaseTest {

	public static void fetchProductsBrandSearch(int price) throws InterruptedException, IOException {

		SoftAssert softassert = new SoftAssert();

		// thread sleep in order to see all the data
		Thread.sleep(2000);

		// get elements into a list
		List<WebElement> list_of_products = driver.findElements(By.xpath(loc.getProperty("brandSearcbrandName")));
		List<WebElement> list_of_products_price = driver
				.findElements(By.xpath(loc.getProperty("brandSearcfinalPrice")));

		// create variables
		String product_name;
		String product_price;
		int int_product_price;
		// counter for the result from 0
		int counter = 1;
		// counter for the result from 1 to max 4
		int result_counter = 1;
		// line counter from 1 to max 4
		int line_counter = 1;
		// boolean found_product
		boolean found_product = true;

		// get all item from the list one by one
		for (int i = 0; i < list_of_products.size(); i++) {
			product_name = list_of_products.get(i).getText();// Iterate and fetch product name
			product_price = list_of_products_price.get(i).getText();// Iterate and fetch product price
			product_price = product_price.replaceAll("[^0-9]", "");// Replace anything will space other than numbers
			int_product_price = Integer.parseInt(product_price);// Convert to Integer

			// try to find product below the price was given
			if (int_product_price <= price) {
				// product link for the output
				if (result_counter > 4) {
					result_counter = 1;
					line_counter++;
				}

				// get the product link
				WebElement product_link = driver
						.findElement(By.xpath(".//html/body/main/div[1]/div[3]/section/div/div[4]/div/div["
								+ line_counter + "]/a[@data-testid=\"ProductTile\"][" + result_counter + "]"));
				String href_product_link = product_link.getAttribute("href");

				if (found_product == true) {
					System.out.println("We found product(s) below: " + price + ",-HUF" + "\n");
				}

				Reporter.log(counter + ". " + product_name + " Price: " + int_product_price + ",-HUF," + "\n"
						+ "The product link is: " + href_product_link + "\n", true);

				// get the images
				WebElement product_image = driver
						.findElement(By.xpath(".//html/body/main/div[1]/div[3]/section/div/div[4]/div/div["
								+ line_counter + "]/a[@data-testid=\"ProductTile\"][" + result_counter + "]/div/img"));

				String srcset = product_image.getAttribute("srcset");
				URL imageURL = new URL(srcset);
				BufferedImage saveImage = ImageIO.read(imageURL);
				ImageIO.write(saveImage, "png", new File(System.getProperty("user.dir") + "\\screenshots\\"
						+ counter + "._" + product_name + "_" + int_product_price + ".png"));

				counter++;
				result_counter++;
				found_product = false;
			}

		}

		if (counter == 1) {
			System.out.println("We didn't find product(s) anymore for you below " + price + ",-HUF" + "\n");
			softassert.assertNotEquals(counter, 1);
		}

		softassert.assertAll();
	}

	// take a screenshot//old part of the code
	/*
	 * if (count == 0) {
	 * System.out.println("\nWe didn't find any product anymore for you below " +
	 * price + ",-HUF\n"); softassert.assertNotEquals(count,0);
	 * 
	 * } else { for (int row = 1; row <= count; row++) {
	 * 
	 * // WebElement element = //
	 * driver.findElement(By.xpath("//*[@aria-label='Term\u00E9kek']/div/ul/li[" +
	 * row + "]/a")); WebElement element = driver.findElement(
	 * By.xpath("//*[@aria-label='Term\u00E9kek']/div/ul/li[" + row + "]"));
	 * ////*[@aria-label='Term\u00E9kek']/div/ul/li[" + row + "] Screenshot
	 * Screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
	 * .takeScreenshot(driver, element); ImageIO.write(Screenshot.getImage(), "png",
	 * new File(System.getProperty("user.dir") + "\\screenshots\\Screenshot_" + row
	 * + ".png")); } } ConsoleOutput.assertAll(); }
	 */
}
