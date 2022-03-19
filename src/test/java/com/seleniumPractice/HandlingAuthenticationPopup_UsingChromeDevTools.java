//package com.seleniumPractice;
//
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v95.network.Network;
//import org.openqa.selenium.devtools.v95.network.model.Headers;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//
//public class HandlingAuthenticationPopup_UsingChromeDevTools {
//	
//	private ChromeDriver driver;
//	
//	@BeforeMethod
//    public void setup() {
//        // Setup Chrome driver
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//        // Authentication username & password
//        String username = "admin";
//        String password = "admin";
//
//        // Get the devtools from the running driver and create a session
//        DevTools devTools = driver.getDevTools();
//        devTools.createSession();
//
//        // Enable the Network domain of devtools
//        devTools.send(Network.enable(Optional.of(100000), Optional.of(100000), Optional.of(100000)));
//        String auth = username + ":" + password;
//
//        // Encoding the username and password using Base64 (java.util)
//        String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());
//
//        // Pass the network header -> Authorization : Basic <encoded String>
//        Map<String, Object> headers = new HashMap<String, Object>();
//        headers.put("Authorization", "Basic " + encodeToString);
//        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
//
//        // Load the application url
//        driver.get("https://the-internet.herokuapp.com/basic_auth");
//    }
//	 
//	 @Test
//	    public void testValidLogin() {
//	        String successFullyLoggedInText = driver.findElement(By.xpath("//p")).getText();
//	        Assert.assertEquals(successFullyLoggedInText, "Congratulations! You must have the proper credentials.");
//	    }
//	 
//	 @AfterMethod
//	    public void tearDown() {
//	        //driver.quit();
//	    
//	 }
//}
