package com.seleniumPractice;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4_Feature_MockGeoLocation {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Map<String,Object> coordinatesMap = new HashMap<String, Object>();
		
		coordinatesMap.put("latitude",30.3079823);
		coordinatesMap.put("longitude",-97.893803);
	    coordinatesMap.put("accuracy",1);
		
	    ((ChromiumDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinatesMap);

	    driver.navigate().to("https://oldnavy.gap.com/stores");
	    
	    WebElement geoMap = driver.findElement(By.id("gmap"));
	    Actions action = new Actions(driver);
	    action.moveToElement(geoMap).build().perform();
	    Thread.sleep(3000);
	 //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    takeScreeshot(geoMap,"geoMap");
	    
	    driver.quit();
		
		

	}
	
	
	public static void takeScreeshot(WebElement element, String fileName) {

		File srcFile = element.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(srcFile, new File("./target/screenshots/"+fileName+".png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
