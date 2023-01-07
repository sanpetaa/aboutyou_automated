package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;

	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;

	@BeforeTest
	public void setUp() throws IOException, InterruptedException {
		// declare path and properties
		if (driver == null) {
			System.out.println("The path is: " + System.getProperty("user.dir"));
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties");

			FileReader fr1 = new FileReader(
					System.getProperty("user.dir") + "/src/test/resources/configfiles/locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}

		// open browsers
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			// run as headless edge
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
				"--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");

			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));

		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();

			// run as headless edge
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");

			 options.addArguments("--headless", "--disable-gpu",
			 "--window-size=1920,1200",
			 "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox",
			 "--disable-dev-shm-usage");
			driver = new EdgeDriver(options);
			driver.get(prop.getProperty("url"));

		}

		// To maximize the browser window
		driver.manage().window().maximize();

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}