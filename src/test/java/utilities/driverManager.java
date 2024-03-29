package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import runner.testNGRunner;

public class driverManager {

	private static ThreadLocal<WebDriver> d = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return d.get();
	}

	public driverManager(String Browser) throws Throwable {
		WebDriver dr = null;
		if (Browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			if (Boolean.parseBoolean(testNGRunner.headLess)) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("headLess");
				dr = new EdgeDriver(options);
			} else {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--remote-allow-origins=*");
				dr = new EdgeDriver(options);
			}
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		}

		else if (Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (Boolean.parseBoolean(testNGRunner.headLess)) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("headLess");
				dr = new ChromeDriver(options);
			} else {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				dr = new ChromeDriver(options);
			}
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		}

		else if (Browser.equals("fire")) {
			WebDriverManager.firefoxdriver().setup();
			if (Boolean.parseBoolean(testNGRunner.headLess)) {
				FirefoxOptions hl = new FirefoxOptions();
				hl.addArguments("--headLess");
				hl.setCapability("marionette", true);
				dr = new FirefoxDriver(hl);
			} else {
				dr = new FirefoxDriver();
			}
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		}

		d.set(dr);

	}

}
