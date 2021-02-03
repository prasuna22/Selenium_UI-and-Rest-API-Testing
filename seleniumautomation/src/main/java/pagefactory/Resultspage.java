/**
 * @author Sai Prasuna
 */
package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resultspage {
	//First item in the results page
	@FindBy(xpath="(//img[@class='s-image'])[1]")
	WebElement item;
	
	//Ger price of the first item in the results page
	@FindBy(xpath="(//span[@class='a-price'])[1]")
	WebElement price;
	
	public Resultspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Get price of the first item in the results page
	public String getItemPrice() {
		return price.getText();
	}
	//Find and click on the first item in the results page
	public void clickFirstItemofResults() {
		this.item.click();
	}
	

}
