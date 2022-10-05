package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import base.BaseTest;

public class Moves extends BaseTest {

	public static void scrollDown() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	
	public static void scrollUp() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)");
	}

	public static void scrollEnd() throws InterruptedException {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
	}

	public static void scrollHome() throws InterruptedException {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
	}
	public static void zoomOut() throws InterruptedException {
	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	 executor.executeScript("document.body.style.zoom = '95%'");
	}
}
