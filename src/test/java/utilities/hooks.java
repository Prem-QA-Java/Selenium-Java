
package utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class hooks {

	asserts asserts = new asserts();
	public static final String VALUE = "value";

	private WebDriver d = driverManager.getDriver();
	SoftAssert sa = new SoftAssert();

	public List<WebElement> webElementsList(By locator) {
		List<WebElement> dd = d.findElements(locator);
		return dd;
	}

	public WebElement find(By locator) {
		return d.findElement(locator);
	}

	public void sendKey(By locator, String data) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(data);
	}

	public void sendKey(By locator, String Data, Keys key) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(Data);
		elm.sendKeys(key);
	}

	public void sendKey(By locator, Keys enter) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(enter);
	}

	public void visibilityofElementLocated(By locator) {
		webElementWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void click(By string) {
		WebElement elm = waitForClickable(string);
		elm.click();
	}

	public WebElement waitForClickable(By locator) {
		return webElementWait().until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebDriverWait webElementWait() {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(50));
		return wait;
	}
	
	
	public  void alertpresent() {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void pause(long a) {
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public WebElement waitForVisible(By locator) {
		try {
			return webElementWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			return null;
		}
	}

	public WebElement waitForVisible(WebElement web) {
		try {
			return webElementWait().until(ExpectedConditions.visibilityOfElementLocated((By) web));
		} catch (Exception e) {
			return null;
		}
	}

	public boolean scrollingToElementofAPage(By locator) {
		pause(5000);
		WebElement element = d.findElement(locator);
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView();", element);
		return true;
	}

	public void selectByIndex(By locator, int index) {
		Select sel = new Select(waitForVisible(locator));
		sel.selectByIndex(index);
	}

	public void selectByValue(By locator, String value) {
		Select sel = new Select(waitForVisible(locator));
		sel.selectByValue(value);
	}

	public void selectByText(By locator, String value) {
		try {
			Select sel = new Select(waitForVisible(locator));
			sel.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean clearInput(By locator) {
		WebElement element = waitForVisible(locator);
		element.clear();
		element = waitForVisible(locator);
		return element.getAttribute(VALUE).isEmpty();
	}

	public String getAtt(By locator, String value) {
		WebElement elm = waitForVisible(locator);
		String e = elm.getAttribute(value);
		return e;
	}

	public String getAttCss(By locator, String value) {
		WebElement elm = waitForVisible(locator);
		String e = elm.getCssValue(value);
		return e;
	}

	public String getText(By locator) {
		WebElement elm = waitForVisible(locator);
		String e = elm.getText();
		return e;
	}

	public String getText(WebElement web) {
		waitForVisible(web);
		String e = web.getText();
		return e;
	}

	public String getValue(By locator) {
		WebElement elm = waitForVisible(locator);
		String e = elm.getAttribute(VALUE);
		return e;
	}

	public boolean isClickable(By webe) {
		try {
			webElementWait().until(ExpectedConditions.elementToBeClickable(webe));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void windows(String name) {
		d.switchTo().frame(name);
	}

	public void refresh() {
		d.navigate().refresh();
	}
	
	public void back() {
		d.navigate().back();
	}
	
	public void forward() {
		d.navigate().forward();
	}
	public void log(String string) {
		Logger log = Logger.getLogger(driverManager.class.getName());
		log.info(string);
	}
	
	public void info(String message) {
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.WHITE));
	}
	
	public void pass(String message) {
		ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.WHITE));
	}
	
	public void fail(String message) {
		ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.WHITE));
	}
	
	public void skip(String message) {
		ExtentCucumberAdapter.getCurrentStep().log(Status.SKIP, MarkupHelper.createLabel(message, ExtentColor.WHITE));
	}

	public void newtab() {
		d.switchTo().newWindow(WindowType.TAB);
	}

	public void url(String string) {
		d.get(string);
	}

	public String js(String string) {
		JavascriptExecutor j = (JavascriptExecutor) d;
		return (String) j.executeScript(string);
	}
	
	public void jsClick(By string) {
		JavascriptExecutor j = (JavascriptExecutor) d;
		j.executeScript("arguments[0].click();",find(string));
	}

	public void js(String string, WebElement ff) {
		JavascriptExecutor j = (JavascriptExecutor) d;
		j.executeScript(string, ff);
	}
	

	public void upload1(String filepath) throws Throwable {
		pause(1000);
		StringSelection ss = new StringSelection(System.getProperty("user.dir") + filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void upload(String filePath) {
		Process process;
		try {
			process = Runtime.getRuntime().exec("src/test/resources/upload.exe"+" "+"\""+System.getProperty("user.dir")+filePath+"\"");
			try {
				process.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void alert(boolean value) {
		if (value) {
			d.switchTo().alert().accept();
		} else {
			d.switchTo().alert().dismiss();
		}
	}
	
	public String alertText() {
		String text = d.switchTo().alert().getText();
		return text;
	}
	public void switchToAlert(String value1) {
		d.switchTo().activeElement().sendKeys("C:\\Users\\Premsai P\\Downloads\\Images\\Images\\CoverPoster\\JERSEY.jpg");
		System.out.println(System.getProperty("user.dir") +value1);
	}

}
