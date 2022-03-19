package com.seleniumPractice;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenImagesInWebPage_Method_1 {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/broken_images");
		
		Integer iBrokenImageCount = 0;
		
		 List <WebElement> image_list  = driver.findElements(By.tagName("img"));
		 System.out.println("Total Images on the WebPage is: "+image_list.size());

		 for(WebElement img : image_list) {
			 
				 if (img != null)
	                {
	                    if (img.getAttribute("naturalWidth").equals("0"))
	                    {
	                        System.out.println(img.getAttribute("outerHTML") + " is broken.");
	                        iBrokenImageCount++;
	                    }
	              }
		
		 }
		 
		 driver.quit();
		 
	}

}
