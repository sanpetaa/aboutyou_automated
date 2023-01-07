package functions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class FetchProductLast30Days extends BaseTest {
	
	public static void hooverOverBrandName() {
		
		WebElement ele = driver.findElement(By.xpath(loc.getProperty("brandName")));
		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		
	}

	public static void fetchProductLast30Days(int price, int last30daysdiscount)
			throws InterruptedException, IOException {

		SoftAssert softassert = new SoftAssert();
		hooverOverBrandName();
		
		// thread sleep in order to see all the data
		Thread.sleep(2000);

		// get elements into a list
		List<WebElement> list_of_products = driver.findElements(By.xpath(loc.getProperty("brandName")));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath(loc.getProperty("finalPrice")));
		// List<WebElement> list_of_last_30_days = driver.findElements(By.xpath(loc.getProperty("last30days")));
		List<WebElement> list_of_products_link = driver.findElements(By.xpath(loc.getProperty("productTile")));
		List<WebElement> list_of_products_images = driver.findElements(By.xpath(loc.getProperty("productImage")));


		
		// create variables
		String product_name;
		String product_price;
		String last_30_days;
		String product_link;
		String product_image;
		int int_product_price;
		int int_last_30_days_product_price;
		// counter for the result from 0
		int counter = 1;
		// boolean found_product
		boolean found_product = true;
		int o = 1;
		// get all item from the list one by one
		for (int i = 0; i < list_of_products.size(); i++) {
			for(o=1; o < list_of_products.size(); o++) {
			// test new 30 days price checker
			List<WebElement> list_of_last_30_days = driver.findElements(By.xpath(
					"//*[@aria-label='Term\\u00E9kek']//*[contains(@class, 'sc-1fzzxqb-0')]/li[" +o+"]/a/div[4]/div/div[3]"));
			
			last_30_days = list_of_last_30_days.get(i).getText();
			System.out.println("SYSOUTTEXT" + last_30_days);// Iterate and fetch product price
			String[] first = last_30_days.split("\\(");
			String[] then = first[1].split("%");
			String toGet = then[0].trim();
			toGet.matches("(-?|\\+?)\\d+");
			int_last_30_days_product_price = Integer.parseInt(toGet);
			
			

			product_name = list_of_products.get(i).getText();// Iterate and fetch product name

			// get product prices
			product_price = list_of_products_price.get(i).getText();// Iterate and fetch product price
			product_price = product_price.replaceAll("[^0-9]", "");// Replace anything will space other than numbers
			int_product_price = Integer.parseInt(product_price);// Convert to Integer

			// get last30days product prices
			/*
			 * if(list_of_last_30_days.get(i) == null) { System.out.
			 * println("We have a problem. We didn't find last30days data for the "
			 * +i+".index" + "\n"); softassert.assertFalse(true); }
			 * 
			 * last_30_days = list_of_last_30_days.get(i).getText();// Iterate and fetch
			 * product price String[] first = last_30_days.split("\\("); String[] then =
			 * first[1].split("%"); String toGet = then[0].trim();
			 * toGet.matches("(-?|\\+?)\\d+"); int_last_30_days_product_price =
			 * Integer.parseInt(toGet);
			 */

			// get product link one by one
			product_link = list_of_products_link.get(i).getAttribute("href");
			String href_product_link = product_link;

			// try to find product below the price was given
			if (int_product_price <= price && int_last_30_days_product_price <= last30daysdiscount) {

				if (found_product == true) {
					System.out.println("We found product(s) below: " + price + ",-HUF and below: " + last30daysdiscount
							+ "%" + "\n");
				}

				Reporter.log(counter + ". " + product_name + " Price: " + int_product_price + ",-HUF," + "\n"
						+ "The product link is: " + href_product_link + "\n" + "Discount is lower with: "
						+ int_last_30_days_product_price + "%.	", true);

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
			System.out.println("We didn't find product(s) anymore for you below " + price + ",-HUF and below "
					+ last30daysdiscount + "%" + "\n");
			softassert.assertNotEquals(counter, 1);
		}

		softassert.assertAll();
	}
}
}
