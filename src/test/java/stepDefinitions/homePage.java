package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import steps.homePageStep;

public class homePage {
	homePageStep homePageStep = new homePageStep();
	@Given("Lunch URL {string}")
	public void lunch_url(String url) {
		homePageStep.lunch_url(url);
	}

	@Then("Verify Company name")
	public void verify_company_name() {
	    homePageStep.vaildCompamyNmae();
	}

	@Then("Verify login and password text boxes")
	public void verify_login_and_password_text_boxes() {
	    homePageStep.vaildusernamenadpassword();
	}

	@Then("verify accepted users and password")
	public void verify_accepted_users_and_password() {
		homePageStep.usersandpassword();
	}
	
}
