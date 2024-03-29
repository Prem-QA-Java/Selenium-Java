package runner;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.service.ExtentService;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import utilities.base;
import utilities.driverManager;
import utilities.hooks;

public class testNGRunner {

	public static String headLess = System.getProperty("headLess");

	@CucumberOptions(features = { "src/test/resources/featuresPage" }, glue = { "pages", "utilities" }, plugin = {
			"html:target/index.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"pretty" })
	public class TestNGRunner extends AbstractTestNGCucumberTests {

		private ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<TestNGCucumberRunner>();

		@BeforeSuite
		public void testNGCR() {
			setTest(new TestNGCucumberRunner(this.getClass()));
		}

		public TestNGCucumberRunner getTest() {
			return testNGCucumberRunner.get();
		}

		public void setTest(TestNGCucumberRunner testNGCucumberRunner1) {
			testNGCucumberRunner.set(testNGCucumberRunner1);
		}

		@BeforeSuite
		public void mood() throws Throwable {
			Logger log = Logger.getLogger(driverManager.class.getName());
			if (Boolean.parseBoolean(headLess)) {
				log.info("@@@@@@@@@@@@@@@@@@@@@@@@@ Running Drivers in headless mode");
				ExtentService.getInstance()
						.addTestRunnerOutput("@@@@@@@@@@@@@@@@@@@@@@@@@ Running Drivers in headless mode\t");
			} else {
				log.info("@@@@@@@@@@@@@@@@@@@@@@@@@ Running Driver in normal mode");
				ExtentService.getInstance()
						.addTestRunnerOutput("@@@@@@@@@@@@@@@@@@@@@@@@@ Running Driver in normal mode\t");
			}
			ExtentService.getInstance().setSystemInfo("OS", System.getProperty("os.name"));
			ExtentService.getInstance().setSystemInfo("OS Version", System.getProperty("os.version"));
			ExtentService.getInstance().setSystemInfo("User Name", System.getProperty("user.name"));
			ExtentService.getInstance().setSystemInfo("Java Version", System.getProperty("java.version"));
			try {
				ExtentService.getInstance().setSystemInfo("System Name / IP", InetAddress.getLocalHost().toString());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}

		@Parameters({ "Browser" })
		@BeforeMethod
		public void browser(@Optional("chrome") String Browser) throws Throwable {
			new base().lanch(Browser);
			driverManager.getDriver().manage().deleteAllCookies();
			driverManager.getDriver().manage().window().setSize(new Dimension(1600, 900));
		}

		@AfterClass
		public void logs() {

			Capabilities cap = ((RemoteWebDriver) driverManager.getDriver()).getCapabilities();
			String browsername = ((RemoteWebDriver) driverManager.getDriver()).getCapabilities().getBrowserName()
					.toUpperCase();

			ExtentService.getInstance().setSystemInfo("Browser name", cap.getBrowserName());
			ExtentService.getInstance().setSystemInfo("Browser version", cap.getBrowserVersion());
			ExtentService.getInstance()
					.addTestRunnerOutput("@@@@@@@@@@@@@@@@@@@@@@@@@ Runned in Browser: " + browsername);
		}

	}

}