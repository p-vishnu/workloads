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
	String text;
	Properties prop;
	
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.get("https://id.atlassian.com/login");
	}
	
	@Test
	public void bugcapture() {
		
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
		
		driver.get(prop.getProperty("jira_URL"));
		driver.findElement(By.id(prop.getProperty("jira_email"))).sendKeys(prop.getProperty("jira_emailvalue"));
		driver.findElement(By.xpath(prop.getProperty("jira_continuebutton"))).click();
		driver.findElement(By.id(prop.getProperty("jira_pswd"))).sendKeys(prop.getProperty("jira_pswdvalue"));
		driver.findElement(By.xpath(prop.getProperty("jira_loginbutton"))).click();
		driver.findElement(By.xpath(prop.getProperty("jira_sofwareIcon"))).click();
		driver.findElement(By.xpath(prop.getProperty("jira_createbuttton"))).click();
		//driver.findElement(By.xpath(prop.getProperty("jira_issueTypeDropdown"))).click();
		
		
		Actions action = new Actions(driver);
		WebElement issuetype = driver.findElement(By.xpath(prop.getProperty("jira_issueTypeDropdown")));
		action.moveToElement(issuetype);
		
		//driver.findElement(By.xpath("(//div/div/div/div/div/ul/li[contains(@id,'bug')])[1]")).click();
		
		
		
		
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
