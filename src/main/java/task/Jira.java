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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jira {
	
	WebDriver driver;
	//String text;
	Properties prop;
	
	
	@BeforeMethod
	public void setUp() {
		prop = Util.propertyFile(prop);
		driver = Util.launchBrowser(driver, prop.getProperty("browser"));
	}
	
	@Test
	public void bugcapture() {
		
		prop = Util.propertyFile(prop);
		
		driver.get(prop.getProperty("jira_URL"));
		driver.findElement(By.id(prop.getProperty("jira_email"))).sendKeys(prop.getProperty("jira_emailvalue"));
		driver.findElement(By.xpath(prop.getProperty("jira_continuebutton"))).click();
		driver.findElement(By.id(prop.getProperty("jira_pswd"))).sendKeys(prop.getProperty("jira_pswdvalue"));
		driver.findElement(By.xpath(prop.getProperty("jira_loginbutton"))).click();
		driver.findElement(By.xpath(prop.getProperty("jira_sofwareIcon"))).click();
		driver.findElement(By.xpath(prop.getProperty("jira_createbuttton"))).click();
		driver.findElement(By.xpath(prop.getProperty("jira_issueTypeDropdown"))).click();
		
		Actions action = new Actions(driver); 
		WebElement selectBug= driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]"));
		action.moveToElement(selectBug).click().build().perform();
		
		
		
		
		/*
		 * List<WebElement> issuetype =driver.findElements(By.xpath("//input[@id='issuetype-field']"));
		 * System.out.println(issuetype.size()); for(int i=0;i<issuetype.size();i++){
		 * text = issuetype.get(0).getText(); 
		 * System.out.println(text); 
		 * String text =issuetype.get(i).getText(); 
		 * if(text.equals("Bug")) {
		 * issuetype.get(i).click(); break; } }
		 */
		
		
		
	}

}
