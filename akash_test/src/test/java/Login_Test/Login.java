package Login_Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Base_Package.Base_Class;
import Excel_Utilities.Excel_Data;
import Page_Object.Login_Object;

public class Login extends Base_Class {
	Login_Object LoginObject;

@BeforeMethod
@Parameters("Browser")

public void Initial_Login(String Browser) throws Throwable {
	
	Intialization(Browser);
	LoginObject = new Login_Object();
	
}
	
@DataProvider (name = "LoginData")
public Object[][] ExlData() throws IOException{
	
	Object obj[][] = Excel_Data.ExcelData("Sheet1");
	return obj;
}

	
@Test (priority = 1, dataProvider= "LoginData")
public void TC_Login_01(String Username, String Password) throws InterruptedException {
	LoginObject.Login(Username, Password);
	
}


/*
 * @AfterTest public void teardown_Method() { driver.close(); }
 */
	
}
