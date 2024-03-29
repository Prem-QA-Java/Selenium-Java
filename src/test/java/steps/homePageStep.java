package steps;

import org.openqa.selenium.By;

import utilities.asserts;
import utilities.driverManager;

public class homePageStep {
	
	asserts asserts = new asserts();
	
	By logo = By.className("login_logo");
	By username = By.cssSelector("[placeholder='Username']");
	By password = By.cssSelector("[placeholder='Password']");
	By accpectedusers = By.id("login_credentials");
	By passwordforallusers = By.className("login_password");
	
	public void lunch_url(String url) {
		driverManager.getDriver().get(url);
	}
	
	public void vaildCompamyNmae() {
		asserts.aTrue(logo);
	}
	
	public void vaildusernamenadpassword() {
		asserts.aTrue(username);
		asserts.aTrue(password);
	}
	
	public void usersandpassword() {
		asserts.aTrue(accpectedusers);
		asserts.aTrue(passwordforallusers);
	}
}
