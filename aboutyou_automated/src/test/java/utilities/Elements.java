package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.BaseTest;

public class Elements extends BaseTest {

	public static void premium() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("premium"))).click();
		Thread.sleep(500);
	}

	public static void poloingek() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("poloingek"))).click();
		Thread.sleep(500);
	}

	public static void meret() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("meret"))).click();
		driver.findElement(By.xpath(loc.getProperty("M"))).click();
	}

	public static void rendezes() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("rendezes"))).click();
		driver.findElement(By.xpath(loc.getProperty("legalacsonyabb_ar"))).click();
		Thread.sleep(200);
	}

	public static void scrollDown() throws InterruptedException {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Thread.sleep(2000);
	}
}
