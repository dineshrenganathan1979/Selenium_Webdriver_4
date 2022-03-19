package com.seleniumPractice;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenImagesInWebPage_Method_2 {

	public static void main(String[] args) throws ClientProtocolException, IOException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/broken_images");
		
		Integer iBrokenImageCount = 0;
		
		 List <WebElement> image_list  = driver.findElements(By.tagName("img"));
		 System.out.println("Total Images on the WebPage is: "+image_list.size());
		 
		 for(WebElement img : image_list) {
			 
			 if(img != null) {
				 
				 HttpClient client = HttpClientBuilder.create().build();
				 HttpGet request = new HttpGet(img.getAttribute("src"));
				 HttpResponse response = client.execute(request);
				 /* For valid images, the HttpStatus will be 200 */
                 if (response.getStatusLine().getStatusCode() != 200)
                 {
                     System.out.println(img.getAttribute("outerHTML") + " is broken.");
                     iBrokenImageCount++;
                 }
			 }
		 }

	}

}
