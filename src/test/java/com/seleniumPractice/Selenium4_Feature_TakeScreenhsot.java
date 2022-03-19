package com.seleniumPractice;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4_Feature_TakeScreenhsot {

	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://bhuvaneswarisilkemporium.com/login?back=my-account");
		
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginButton = driver.findElement(By.id("submit-login"));
		
		email.sendKeys("rdinesh1979@gmail.com");
	    password.sendKeys("rdinu123");

		takeScreeshot(email,"email");
		takeScreeshot(password,"password");
		takeScreeshot(loginButton,"loginButton");
		
	
	    //WebElement loginButton = driver.findElement(By.id("loginBtn"));
	    driver.quit();
	    
	    //loginButton.click();
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
