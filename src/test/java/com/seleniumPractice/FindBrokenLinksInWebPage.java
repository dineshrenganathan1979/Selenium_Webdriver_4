package com.seleniumPractice;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLinksInWebPage {
	
	static int iBrokenLinksCount = 0;
	static int ivalidLinksCount = 0;
	static int iTotalLinksCount = 0;

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		
		
		//Storing the links in a list and traversing through the links
		 List <WebElement> links   = driver.findElements(By.tagName("a"));
		 
		// This line will print the number of links and the count of links.
		 iTotalLinksCount = links.size();
		 System.out.println("Total Links on the WebPage is: "+links.size());
	
		//checking the links fetched.
		 for(int i=0;i<links.size();i++)
	        {
	            WebElement E1= links.get(i);
	            String url= E1.getAttribute("href");
	            verifyLinks(url);
	        }
	       
		     System.out.println("Total Number of Links in the Web Page is: "+iTotalLinksCount);
		     System.out.println("Total Number of Valid Links in the Web Page is: "+ivalidLinksCount);
		     System.out.println("Total Number of Broken Links in the Web Page is: "+iBrokenLinksCount);
		     
		 
	        driver.quit();
	}

	private static void verifyLinks(String linkUrl) throws Exception  {
		
		try {
			URL url = new URL(linkUrl);
			
			 //Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()>=400)
            {
              System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
              iBrokenLinksCount++;
            }    
       
            //Fetching and Printing the response code obtained
            else{
               // System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            	ivalidLinksCount++;
            }
			
		}catch (Exception e) {
	      
		e.printStackTrace();
		}
		
	}

}
