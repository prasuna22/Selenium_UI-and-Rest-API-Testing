/**
 * @author Sai Prasuna
 */

package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	// Search field
	@FindBy(id="twotabsearchtextbox")
	WebElement searchField;
	
	//Search button
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Passing search parameters in search field
	public void searchItem(String str) {
	this.searchField.sendKeys(str);	
	}
	
	//Search for the item
	public void search()
	{
		this.searchButton.click();
	}
}
