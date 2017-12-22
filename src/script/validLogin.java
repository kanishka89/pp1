package script;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;

public class validLogin extends BaseTest
{						
		 @Test(priority =1,groups= {"login"})
		   public void testvalidLogin() throws InterruptedException
		   {
			  String un = Excel.getCellValue(SCRIPT_PATH,"validLogin", 1, 0);
			  String pw= Excel.getCellValue(SCRIPT_PATH,"validLogin", 1, 1);
	       	  driver.findElement(By.name("uid")).sendKeys(un);							
	          driver.findElement(By.name("password")).sendKeys(pw);							
	          driver.findElement(By.name("btnLogin")).click();	
		      Reporter.log("valid login test run",true);
		      
		      String url = System.getProperty("url");
		      System.out.println("Url from jekins : "+url);
		      
		      String username = System.getProperty("username");
		      System.out.println("Username from jekins : "+username);
		      
		      String environment = System.getProperty("environment");
		      System.out.println("Environment from jekins : "+environment);
		
	}		
}
