package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import base.BaseTest;

public class ElementsBrandSearch extends BaseTest {

	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	public static boolean isChecked;

	public static void poloRalphLauren() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("polo_ralph_lauren"))));
		element.click();
	}

	public static void brandSearchRendezesLegalacsonyabbAr() throws InterruptedException {
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
		isChecked = element1.findElement(By.xpath(loc.getProperty("brandSearch43"))).isSelected();

		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearch43.5"))));
		element2.click();
		isChecked = element2.findElement(By.xpath(loc.getProperty("brandSearch43.5"))).isSelected();
		Thread.sleep(1000);
		waitForPageLoad();
	}

	public static void brandSearchMeret() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearchmeret"))));
		element.click();
	}

	public static void brandSearchM() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearchM"))));
		element.click();
		isChecked = element.findElement(By.xpath(loc.getProperty("brandSearchM"))).isSelected();
	}

	public static void brandSearchAr() throws InterruptedException {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearchar"))));
		element.click();
	}

	public static void brandSearchAkcios() throws InterruptedException {
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearchar"))));
		element1.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("brandSearchakcios"))));
		element2.click();
		isChecked = element2.findElement(By.xpath(loc.getProperty("brandSearchakcios"))).isSelected();
		Thread.sleep(1000);
		waitForPageLoad();
	}

	public static void waitForPageLoad() {
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

}
