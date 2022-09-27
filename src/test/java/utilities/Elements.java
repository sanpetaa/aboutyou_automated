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
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("AcceptCookies"))));
		element.click();
	}

	public static void premium() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("premium"))));
		element.click();
	}

	public static void ruhazat() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ruhazat"))));
		element.click();
	}

	public static void poloingek() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("poloingek"))));
		element.click();
	}

	public static void nadragok() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("nadragok"))));
		element.click();
	}

	public static void polomeret() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("meret"))));
		element.click();
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("M"))));
		element2.click();
	}

	public static void nadragmeret() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("meret"))));
		element.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("huvelyk31"))));
		element2.click();
		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("huvelyk32"))));
		element3.click();
		WebElement element4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("szarhossz30"))));
		element4.click();
		WebElement element5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("szarhossz31"))));
		element5.click();
		WebElement element6 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("szarhossz32"))));
		element6.click();
	}

	public static void rendezes() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("rendezes"))));
		element.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("legalacsonyabb_ar"))));
		element2.click();
	}

}