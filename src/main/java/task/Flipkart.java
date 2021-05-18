package task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
			
		public WebDriver driver;
		public static Properties prop;
		
		@BeforeTest
		public void setup(){
		 WebDriverManager.chromedriver().setup(); 
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
		@Test
		public void mobile(){
					
			try {
				FileInputStream f = new FileInputStream("C:\\Users\\ACER\\eclipse-workspace\\mvnTest\\src\\main\\java\\config\\config.properties");
				prop = new Properties();
				prop.load(f);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				System.out.println(e1);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
			
			driver.get(prop.getProperty("Flip_url"));
			driver.findElement(By.xpath(prop.getProperty("Flip_unpath"))).sendKeys(prop.getProperty("Flip_mobile"));
			driver.findElement(By.xpath(prop.getProperty("Flip_pwdpath"))).sendKeys(prop.getProperty("Flip_password"));
			driver.findElement(By.xpath(prop.getProperty("Flip_loginbutton"))).click();
			driver.findElement(By.xpath(prop.getProperty("Flip_search"))).sendKeys(prop.getProperty("Flip_searchvalue"));
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			/*
			 * WebElement electronics = driver.findElement(By.className("xtXmba")); Actions
			 * action = new Actions(driver);
			 * action.moveToElement(electronics).build().perform();
			 * action.click(electronics);
			 */
	          	
			}
		
			
			  @AfterTest public void teardown(){ 
			  driver.quit(); 
			  }
			 

}
