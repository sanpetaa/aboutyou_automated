package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new EdgeDriver();
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
