package pages;

import io.cucumber.java.en.Then;

public class sorting {
	
	steps.sortingSteps sortingSteps = new steps.sortingSteps();
	
	@Then("click on sorting dropdown and select {string} sorting  value")
	public void click_on_sorting_dropdown_and_select_sorting_value(String string) {
		sortingSteps.selectsortingtype(string);
	}
	
	@Then("verify the products should order by a-z")
	public void verify_the_products_should_order_by_a_z() {
	    sortingSteps.verifyproductaresortedornot("a-z");
	}
	
	@Then("verify the products should order by z-a")
	public void verify_the_products_should_order_by_z_a() {
	    sortingSteps.verifyproductaresortedornot("z-a");
	}
	
	@Then("verify the products should order by price low-high")
	public void verify_the_products_should_order_by_price_low_high() {
	    sortingSteps.verifyproductaresortedornot("low-high");
	}

	@Then("verify the products should order by price high-low")
	public void verify_the_products_should_order_by_price_high_low() {
		sortingSteps.verifyproductaresortedornot("high-low");
	}
	
}
