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

public class Functions extends BaseTest {


	public static void fetchProducts(int price) throws InterruptedException, IOException {

		SoftAssert softassert = new SoftAssert();
	
		//thread sleep in order to see all the data
		Thread.sleep(2000);
		
		//get elements into a list
		List<WebElement> list_of_products = driver.findElements(By.xpath(loc.getProperty("brandName")));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath(loc.getProperty("finalPrice")));

		//create variables
		String product_name;
		String product_price;
		int int_product_price;
		//counter for the result from 0
		int count = 0;
		//counter for the result from 1
		int result_count = 1;
		//image counter
		int image_counter = 1;
		//boolean found_product
		boolean found_product = true;

		//get all item from the list one by one
		for (int i = 0; i < list_of_products.size(); i++) {
			product_name = list_of_products.get(i).getText();// Iterate and fetch product name
			product_price = list_of_products_price.get(i).getText();// Iterate and fetch product price
			product_price = product_price.replaceAll("[^0-9]", "");// Replace anything will space other than numbers
			int_product_price = Integer.parseInt(product_price);// Convert to Integer
			
		//try to find product below the price was given 
			if (int_product_price <= price) {
				//product link for the output
				WebElement product_link = driver
						.findElement(By.xpath(".//*[@aria-label='Term\u00E9kek']/div/ul/li[" + result_count + "]/a"));
				String href_product_link = product_link.getAttribute("href");
				
					if (found_product ==  true) {
						System.out.println("We found product(s) below: " + price + ",-HUF" + "\n");
					}
				
				Reporter.log(result_count + ". " + product_name + " Price: " + int_product_price + ",-HUF," + "\n"
						+ "The product link is: " + href_product_link + "\n", true);

				WebElement product_image = driver
						.findElement(By.xpath(".//*[@aria-label='Term\u00E9kek']/div/ul/li[" + result_count + "]/a/div/img"));
				
				String srcset = product_image.getAttribute("srcset");
				URL imageURL = new URL(srcset);
				BufferedImage saveImage = ImageIO.read(imageURL);
				ImageIO.write(saveImage, "png", new File(System.getProperty("user.dir") + "\\screenshots\\"
						+ image_counter + "._" + product_name + "_" + int_product_price + ".png"));
				
				count++;
				result_count++;
				image_counter++;
				found_product = false;	
			} 

		}

		if (count == 0) {
			System.out.println("We didn't find product(s) anymore for you below " + price + ",-HUF"  + "\n");
			softassert.assertNotEquals(count, 0);
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
