
package functions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class FetchProductPriceforBrands extends BaseTest {

	public static void fetchProductPriceforBrands(int price) throws InterruptedException, IOException {

		SoftAssert softassert = new SoftAssert();

		// thread sleep in order to see all the data
		Thread.sleep(2000);

		// get elements into a list
		List<WebElement> list_of_products = driver.findElements(By.xpath(loc.getProperty("brandSearcbrandName")));
		List<WebElement> list_of_products_price = driver
				.findElements(By.xpath(loc.getProperty("brandSearcfinalPrice")));
		List<WebElement> list_of_products_link = driver.findElements(By.xpath(loc.getProperty("ProductTile")));
		List<WebElement> list_of_products_images = driver.findElements(By.xpath(loc.getProperty("ProductImage")));
		// create variables
		String product_name;
		String product_price;
		String product_link;
		String product_image;
		int int_product_price;
		// counter for the result from 0
		int counter = 1;
		// boolean for the test final result
		boolean found_product = true;

		// get all item from the list one by one
		for (int i = 0; i < list_of_products.size(); i++) {
			product_name = list_of_products.get(i).getText();// Iterate and fetch product name
			product_price = list_of_products_price.get(i).getText();// Iterate and fetch product price
			// get product link one by one
			product_link = list_of_products_link.get(i).getAttribute("href");
			String href_product_link = product_link;

			// get product prices
			product_price = product_price.replaceAll("[^0-9]", "");// Replace anything will space other than numbers
			int_product_price = Integer.parseInt(product_price);// Convert to Integer

			// try to find product below the price was given
			if (int_product_price <= price) {

				if (found_product == true) {
					System.out.println("We found product(s) below: " + price + ",-HUF" + "\n");
				}

				Reporter.log(counter + ". " + product_name + " Price: " + int_product_price + ",-HUF," + "\n"
						+ "The product link is: " + href_product_link + "\n", true);

				// get product images one by one
				product_image = list_of_products_images.get(i).getAttribute("srcset");
				String srcset = product_image;

				URL imageURL = new URL(srcset);
				BufferedImage saveImage = ImageIO.read(imageURL);
				ImageIO.write(saveImage, "png", new File(System.getProperty("user.dir") + "\\screenshots\\" + counter
						+ "._" + product_name + "_" + int_product_price + ".png"));

				counter++;
				found_product = false;
			}

		}

		if (counter == 1) {
			System.out.println("We didn't find product(s) anymore for you below " + price + ",-HUF" + "\n");
			softassert.assertNotEquals(counter, 1);
		}

		softassert.assertAll();
	}
}
