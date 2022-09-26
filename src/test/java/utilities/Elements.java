package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class Elements extends BaseTest {
	
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public static void acceptCookies() throws InterruptedException {
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("AcceptCookies"))));
	element.click();
	}
	
	public static void premium() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("premium"))));
		element.click();
	}

	public static void poloingek() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("poloingek"))));
		element.click();
	}

	public static void meret() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("meret"))));
		element.click();
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("M"))));
		element2.click();
	}

	public static void rendezes() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("rendezes"))));
		element.click();
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("legalacsonyabb_ar"))));
		element2.click();
	}

}