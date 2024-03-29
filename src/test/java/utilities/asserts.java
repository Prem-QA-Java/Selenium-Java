package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class asserts extends base{
	
	SoftAssert sa = new SoftAssert();
	
	public void aTrue(By locator, String string) {
		sa.assertTrue(getText(locator).contains(string));
	}
	
	public void aTrue(String string, By locator) {
		sa.assertTrue(string.contains(getText(locator)));
	}

	public void aTrue(WebElement element, String string) {
		sa.assertTrue(getText(element).contains(string));
	}
	
	public void aTrue(String string, WebElement element) {
		sa.assertTrue(string.contains(getText(element)));
	}

	public void aTrue(By locator, String s, String string) {
		sa.assertTrue(getAtt(locator, s).contains(string));
	}

	public void aTrue(By locator, String s, String string, String strin) {
		sa.assertTrue(getAttCss(locator, s).contains(string));
	}

	public void aTrue(By locator) {
		sa.assertTrue(find(locator).isDisplayed());
	}

	public void aTrue(boolean b) {
		sa.assertTrue(b);
	}

	public void aFalse(By locator, String string) {
		sa.assertFalse(getText(locator).contains(string));
	}
	
	public void aFalse(String string, By locator) {
		sa.assertFalse(string.contains(getText(locator)));
	}

	public void aFalse(WebElement element, String string) {
		sa.assertFalse(getText(element).contains(string));
	}
	
	public void aFalse(String string, WebElement element) {
		sa.assertFalse(string.contains(getText(element)));
	}

	public void aFalse(By locator, String s, String string) {
		sa.assertFalse(getAtt(locator, s).contains(string));
	}

	public void aFalse(By locator, String s, String string, String strin) {
		sa.assertFalse(getAttCss(locator, s).contains(string));
	}

	public void aFalse(By locator) {
		sa.assertFalse(find(locator).isDisplayed());
	}

	public void aFalse(boolean b) {
		sa.assertFalse(b);
	}
	
	public void aFalse(String prop, String js) {
		sa.assertFalse(prop.contains(js));
	}
	
	public void equal(By locator, String string) {
		sa.assertEquals(getText(locator), string);
	}

	public void equal(WebElement web, String string) {
		sa.assertEquals(getText(web), string);
	}

	public void equal(By locator, int number) {
		sa.assertEquals(Integer.parseInt(getText(locator)), number);
	}

	public void equal(String actual, String expected) {
		sa.assertEquals(actual, expected);
	}
	
	
	public void equal(String[] beforesort, String[] aftersort) {
		sa.assertEquals(beforesort, aftersort);
	}

	public void all() {
		sa.assertAll();
	}
}
