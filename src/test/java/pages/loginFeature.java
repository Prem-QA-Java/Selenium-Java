package pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import steps.loginSteps;

public class loginFeature {
	
	loginSteps loginSteps = new loginSteps();
	@And("give user name: {string} and passowrd: {string}")
	public void give_user_name_and_password(String username, String password) {
	    loginSteps.userandpassword(username, password);
	}

	@Then("click on login")
	public void click_on_login() {
	    loginSteps.clickonloginbutton();
	}

	@Then("vaild login successful")
	public void vaild_login_successful() {
	    loginSteps.clickmenu();
	    loginSteps.logoutvisiable();
	}
	
	@Then("vaild locked user text below password box {string}")
	public void vaild_locked_user_text_below_password_box(String errormsg) {
		loginSteps.errormsg(errormsg);
	}

	@Then("click on cross to close the popup")
	public void click_on_cross_to_close_the_popup() {
	    loginSteps.clickcross();
	}
}
