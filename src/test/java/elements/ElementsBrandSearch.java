package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class ElementsBrandSearch extends BaseTest{
	
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public static void poloRalphLauren() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("polo_ralph_lauren"))));
		element.click();
	}
	
	public static void brandSearchRendezes() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearchrendezes"))));
		element.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("legalacsonyabb_ar"))));
		element2.click();
	}
	
	public static void brandSearchCipoMeret() throws InterruptedException {
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearch43"))));
		element1.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearch43.5"))));
		element2.click();
	}
	
	
	public static void brandSearchMeret() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearchmeret"))));
		element.click();
	}
	
	public static void brandSearchM() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearchM"))));
		element.click();
	}
	
	public static void brandSearchAr() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearchar"))));
		element.click();
	}
	
	public static void brandSearchAkcios() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearchakcios"))));
		element.click();
	}

}
