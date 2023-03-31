package Page_Object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import Base_Package.Base_Class;

public class Login_Object extends Base_Class {

@FindBy (xpath = "//input[@name='email']")
WebElement Username;

@FindBy (xpath= "//input[@name='password']")
WebElement Password;
@FindBy (xpath= "//div[contains(text(),'Login')]" )
WebElement LoginButton;
@FindBy (xpath = "//i[@class='home icon']")
WebElement HomeTab;

public Login_Object() {
	
	PageFactory.initElements(driver, this);
}

public void Login(String UserName, String PassWord) throws InterruptedException {
	
	Username.sendKeys(UserName);
	Password.sendKeys(PassWord);
	Thread.sleep(2000);
	LoginButton.click();
	Thread.sleep(2000);
	Actions Hover_Home = new Actions(driver);
	Hover_Home.moveToElement(HomeTab).build().perform();
	List<WebElement> Tabs = driver.findElements(By.xpath("//div[@class='menu-item-wrapper']/a/span"));
	for(WebElement tab : Tabs) {
		
		String Tab_Names = tab.getText();
		System.out.println(Tab_Names);
		
		
		if(Tab_Names.equalsIgnoreCase("Calendar")) {
			tab.click();
		}
	}
	
	
	
    
	
}
	
	

}
