package task;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Appform {
	Properties prop;
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		prop = Util.propertyFile(prop);
		driver= Util.launchBrowser(driver,prop.getProperty("browser") );
	}
	
	@Test
	public void qaForm() {
		
		prop = Util.propertyFile(prop);
		driver.get(prop.getProperty("appform_URL"));
		driver.findElement(By.id(prop.getProperty("appform_firstname"))).sendKeys(prop.getProperty("appform_firstname_value"));
		driver.findElement(By.id(prop.getProperty("appform_lastname"))).sendKeys(prop.getProperty("appform_lastname_value"));
		driver.findElement(By.id(prop.getProperty("appform_email"))).sendKeys(prop.getProperty("appform_emailvalue"));
		
		driver.findElement(By.className("custom-control-label"));
		//driver.findElement(By.xpath("//input[@name = 'gender' and @id ='gender-radio-1']")).click();
		Actions action = new Actions(driver);
		WebElement male_button = driver.findElement(By.xpath("//input[@name = 'gender' and @id ='gender-radio-1']"));
		action.moveToElement(male_button).click().build().perform();
		driver.findElement(By.id(prop.getProperty("appform_mobileNo"))).sendKeys(prop.getProperty("appform_mobileNo_value"));
		
		driver.findElement(By.id(prop.getProperty("appform_DOB"))).clear();
		driver.findElement(By.id(prop.getProperty("appform_DOB"))).click();
		
		WebElement month = driver.findElement(By.className(prop.getProperty("appform_month")));
		WebElement year = driver.findElement(By.className(prop.getProperty("appform_year")));
		
	    action.moveToElement(month).click().build().perform();
		Util.selectDropdownByVisibletext(month, prop.getProperty("appform_month_value"));
		action.moveToElement(year).click().build().perform();
		Util.selectDropdownByVisibletext(year, prop.getProperty("appform_year_value"));
		driver.findElement(By.xpath(prop.getProperty("appform_Date"))).click();
		
		
		WebElement subjectText = driver.findElement(By.className("css-1g6gooi"));
		action.moveToElement(subjectText).sendKeys("maths").build().perform();
	    //WebElement subjectfield = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
		
		
		WebElement hobbies_sports= driver.findElement(By.xpath("//input[@type='checkbox' and @id='hobbies-checkbox-1'and @text()='Sports']")); 
		action.moveToElement(hobbies_sports).click().build().perform();
		 
		 
		
		
		

		
		
		//driver.findElement(By.id("//div[@id='subjectsContainer']"));
		
		/*
		Actions action = new Actions(driver);
		WebElement stateoptions = driver.findElement(By.xpath("//div[text()='Select State']"));
		action.moveToElement(stateoptions);*/
		
		/*List<WebEleemnt> 
		int optionstext = stateoptions.size();
		System.out.println(optionstext);
		for(int i=0;i<stateoptions.size();i++) {
			if(stateoptions.get(i).getText().equals("NCR")) {
				stateoptions.get(i).click();
				break;
			}*/
		
	}

}
