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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Util {
	/**
	 * 
	 * @param driver
	 * @param browser
	 * @return
	 */
	public static WebDriver launchBrowser(WebDriver driver, String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
	}
		//driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	/**
	 * 
	 * @param prop
	 * @return
	 */
	public static Properties propertyFile(Properties prop) {
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
		return prop;
	}
	
	public static void selectDropdownByVisibletext(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	
	
	
}
