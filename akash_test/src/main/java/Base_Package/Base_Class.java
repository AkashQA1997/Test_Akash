package Base_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;



public class Base_Class {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream file;
	
 public void Intialization(String Browser) throws Throwable {
	
		/*
		 * prop = new Properties(); try { file = new FileInputStream(
		 * "C:\\Users\\Sakas\\eclipse-workspace\\akash_test\\src\\test\\resources\\Config_file.properties"
		 * ); } catch (FileNotFoundException e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * prop.load(file);
		 */
	 
	    System.out.print(Browser);
	    
	    if(Browser.contentEquals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
	    }else if(Browser.contentEquals("Chrome")) {
	    	
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new ChromeDriver();
	    }


		driver.get("https://ui.cogmento.com/");

	}
 
 
 public void failedScreenshot() throws IOException {
	 
	File SSfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(SSfile, new File("C:\\Users\\Sakas\\eclipse-workspace\\akash_test\\Failed_Screenshot"));
 }

}
