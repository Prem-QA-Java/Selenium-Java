package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

//import base.steps;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class base extends hooks {
	
	public void lanch(String Browser) throws Throwable {
		new driverManager().driver(Browser);
	}
	
	public static String prop(String Key) {

		Properties pp = new Properties();
		FileInputStream fil = null;
		try {
			fil = new FileInputStream("src/test/resources/data.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pp.load(fil);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pp.getProperty(Key);
	}

	@Before
	public void browserName() throws ClassNotFoundException {
		String browsername = ((RemoteWebDriver) driverManager.getDriver()).getCapabilities().getBrowserName()
				.toUpperCase();
		
		ExtentCucumberAdapter.getCurrentScenario().log(Status.INFO, "Browser Name: " + browsername);
	}

	@AfterStep
	public void afterScenario(Scenario s) {
		if (s.isFailed()) {
			byte[] ts = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			s.attach(ts, "image/png", null);
		}
	}

	@After
	public void close() throws FileNotFoundException {
		driverManager.getDriver().quit();
		PrintStream out = new PrintStream(new FileOutputStream(System.getProperty("user.dir") + "output.txt"));
		System.setOut(out);
	}
	
	// This methods converts the date from 2023-Nov-20 to 2023-11-20
	public String dateConvert(String D) {
		SimpleDateFormat format2 = new SimpleDateFormat("yyy-MM-dd");
		Date output = null;
		try {
			output = (Date) new SimpleDateFormat("yyyy-MMM-dd").parse(D);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dateString = format2.format(output);
		return dateString;
	}
}
