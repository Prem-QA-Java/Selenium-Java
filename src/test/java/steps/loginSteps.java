package steps;

import org.openqa.selenium.By;

import utilities.*;

public class loginSteps {
	
	asserts asserts = new asserts();
	hooks hooks = new hooks();
	
	By username = By.cssSelector("[placeholder='Username']");
	By password = By.cssSelector("[placeholder='Password']");
	By loginButton = By.cssSelector("#login-button");
	By sideMenu = By.id("react-burger-menu-btn");
	By logout = By.id("logout_sidebar_link");
	By errormsgbutton = By.className("error-button");
	
	public void userandpassword(String user, String password) {
		hooks.sendKey(username, user);
		hooks.sendKey(this.password, password);
	}
	
	public void clickonloginbutton() {
		hooks.click(loginButton);
	}
	
	public void clickmenu() {
		hooks.click(sideMenu);
	}
	
	public void logoutvisiable() {
		asserts.aTrue(logout);
	}
	
	public void errormsg(String msg) {
		asserts.aTrue(errormsgbutton, msg);
	}
	
	public void clickcross() {
		asserts.click(errormsgbutton);
	}
}
