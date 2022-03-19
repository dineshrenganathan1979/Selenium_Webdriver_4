package com.seleniumPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAuthenticationPopup_UsingNormalWay {

	public static void main(String[] args) {

       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       
       String userName ="admin";
       String password ="admin";
       String url ="the-internet.herokuapp.com/basic_auth";
     //  driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
       driver.get("https://"+userName+":"+password+"@"+url);

	}

}
