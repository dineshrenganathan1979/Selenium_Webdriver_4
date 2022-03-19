package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties prop;
	public void Setup() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WebDriverManager.chromedriver().setup();
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")){
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
				
		
	}
	
	
	
	private void BasePage(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}



	public void tearDown() {
		driver.quit();
	}
	
	

}
