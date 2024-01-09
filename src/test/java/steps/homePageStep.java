package steps;

import org.openqa.selenium.By;

import utilities.driverManager;
import utilities.hooks;

public class homePageStep {
	
	hooks hooks = new hooks();
	
	By logo = By.className("login_logo");
	By username = By.cssSelector("[placeholder='Username']");
	By password = By.cssSelector("[placeholder='Password']");
	By accpectedusers = By.id("login_credentials");
	By passwordforallusers = By.className("login_password");
	
	public void lunch_url(String url) {
		driverManager.getDriver().get(url);
	}
	
	public void vaildCompamyNmae() {
		hooks.aTrue(logo);
	}
	
	public void vaildusernamenadpassword() {
		hooks.aTrue(username);
		hooks.aTrue(password);
	}
	
	public void usersandpassword() {
		hooks.aTrue(accpectedusers);
		hooks.aTrue(passwordforallusers);
	}
}
