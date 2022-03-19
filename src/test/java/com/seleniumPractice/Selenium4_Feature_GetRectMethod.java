package com.seleniumPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4_Feature_GetRectMethod {

	public static void main(String[] args) throws InterruptedException {

         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         
         driver.get("https://qaprodautomation.nxgen.cloud/auth/login");
         
         Thread.sleep(5000);
         WebElement loginButton = driver.findElement(By.cssSelector(".mat-focus-indicator.mat-raised-button.mat-button-base.mat-accent:nth-child(2)"));
         
         
         //Selenium 3 Method
         
         Dimension dim = loginButton.getSize();
         
         Point point = loginButton.getLocation();
         
         System.out.println("The Height of the Button is: " +dim.getHeight());
         System.out.println("The Width of the Button is: " +dim.getWidth());
         
         System.out.println("The X Co-ordinate of the Button is: " +point.getX());
         System.out.println("The Y Co-ordinate of the Button is: " +point.getY());
      
         //Selenium 4 Method
         
         Rectangle loginButtonRect = loginButton.getRect();
                
         System.out.println("The Height of the Button is: " +loginButtonRect.getHeight());
         System.out.println("The Width of the Button is: " +loginButtonRect.getWidth());
         System.out.println("The X Co-ordinate of the Button is: " +loginButtonRect.getX());
         System.out.println("The Y Co-ordinate of the Button is: " +loginButtonRect.getY());
		

         driver.quit();
	}

}
