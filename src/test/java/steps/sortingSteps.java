package steps;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import utilities.hooks;

public class sortingSteps {
	
	hooks hooks = new hooks();
	SoftAssert sa = new SoftAssert();
	
	By dropdown = By.className("product_sort_container");
	By productNames = By.xpath("//*[@class='inventory_list']//div[@class='inventory_item_name ']");
	By productPrice = By.className("inventory_item_price");
	
	String sort;
	List<WebElement> names=hooks.webElementsList(productNames);
	String[] beforesort = new String[names.size()];
	String[] reversort = new String[names.size()];
	
	public void selectsortingtype(String type) {
		for(int i=0; i<names.size();i++) {
			beforesort[i]=hooks.getText(names.get(i)).trim();
		}
		for (int i=0; i<beforesort.length;i++) {
			Arrays.sort(beforesort);
			sort=beforesort[i];
		}
		
		int j=0;
		for(int i=beforesort.length-1;i>=0;i--) {
			reversort[j]=beforesort[i];
			j++;
		}
		
		hooks.selectByText(dropdown, type);
	}
	
	public void verifyproductaresortedornot(String type) {
		if(type=="a-z") {
			List<WebElement> names=hooks.webElementsList(productNames);
			String[] aftersort = new String[names.size()];
			for(int i=0; i<names.size();i++) {
				aftersort[i] = hooks.getText(names.get(i)).trim();
			}
			sa.assertEquals(beforesort, aftersort);
			sa.assertAll();
		}else if(type=="z-a") {
			List<WebElement> names=hooks.webElementsList(productNames);
			String[] aftersort = new String[names.size()];
			for(int i=0; i<names.size();i++) {
				aftersort[i] = hooks.getText(names.get(i)).trim();
			}
			sa.assertEquals(reversort, aftersort);
			sa.assertAll();
		}else if(type=="low-high") {
			List<WebElement> prices = hooks.webElementsList(productPrice);
			String[] price = new String[prices.size()];
			for(int i=0; i<prices.size();i++) {
				price[i] = hooks.getText(prices.get(i)).replace("$", "").trim();
			}
			System.out.println(price);
			for(int i = 0; i<prices.size(); i++) {
				for(int j = i+1; j<price.length; j++) {
					if(Double.parseDouble(hooks.getText(prices.get(i)).replace("$", "").trim())<=Double.parseDouble(price[j])) {
						sa.assertTrue(true);
					}else {
						sa.assertTrue(false);
					}
				}
			}
			sa.assertAll();
		}else if(type=="high-low") {
			List<WebElement> prices = hooks.webElementsList(productPrice);
			String[] price = new String[prices.size()];
			for(int i=0; i<prices.size();i++) {
				price[i] = hooks.getText(prices.get(i)).replace("$", "").trim();
			}
			for(int i = 0; i<prices.size(); i++) {
				for(int j = i+1; j<price.length; j++) {
					if(Double.parseDouble(hooks.getText(prices.get(i)).replace("$", "").trim())>=Double.parseDouble(price[j])) {
						sa.assertTrue(true);
					}else {
						sa.assertTrue(false);
					}
				}
			}
			sa.assertAll();
		}else {
			
		}
	}
}
