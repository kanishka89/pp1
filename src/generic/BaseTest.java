package generic;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;




public class BaseTest implements IAutoconst
{
	
	 public WebDriver driver;
	 
	
	  static
	  {
		  System.setProperty(CHROME_KEY, CHROME_VALUE);
		  System.setProperty(GECKO_KEY, GECKO_VALUE);
		  
	  }
	  
	  @BeforeMethod(alwaysRun=true)
	  public void openApplication() throws Exception
	  {
	       driver = new ChromeDriver();
		 // driver = new FirefoxDriver();
		 String strITO = Property.getValue(SETTINGS_PATH,"ITO");
 	    long ito = Long.parseLong(strITO);
 	  //  log.info("set ITO : "+ito+" sec");
 	    driver.manage().timeouts().implicitlyWait(ito,TimeUnit.SECONDS);
 	    String url = Property.getValue(SETTINGS_PATH,"URL");
 	//    log.info("Enter the URL: "+url);
 	    driver.get(url);  
	  }
	  
	  @AfterMethod(alwaysRun=true)
	  public void closeBrowser()
	  {
		  driver.quit();
	  }
	  
}
