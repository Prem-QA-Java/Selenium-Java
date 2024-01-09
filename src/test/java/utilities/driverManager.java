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
import runner.Runner;

public class driverManager {

	private static ThreadLocal<WebDriver> d = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return d.get();
	}

	public void setDriver(WebDriver driver) {
		d.set(driver);
	}

	public void driver(String Browser) throws Throwable {
		WebDriver dr = null;
		if (Browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			if (Boolean.parseBoolean(Runner.headLess)) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("headLess");
				dr = new EdgeDriver(options);
			} else if (Boolean.parseBoolean(Runner.headLess)) {
				dr = new EdgeDriver();
			} else {
				dr = new EdgeDriver();
			}
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		}

		else if (Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (Boolean.parseBoolean("true")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("headLess");
				dr = new ChromeDriver(options);
			} else if (Boolean.parseBoolean(Runner.headLess)) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
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
			if (Boolean.parseBoolean(Runner.headLess)) {
				FirefoxOptions hl = new FirefoxOptions();
				hl.addArguments("--headLess");
				hl.setCapability("marionette", true);
				dr = new FirefoxDriver(hl);
			} else if (Boolean.parseBoolean(Runner.headLess)) {
				dr = new FirefoxDriver();
			} else {
				dr = new FirefoxDriver();
			}
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		}

		driverManager.d.set(dr);

	}

}
