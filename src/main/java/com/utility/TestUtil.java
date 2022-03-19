package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.pages.BasePage;

public class TestUtil extends BasePage {
	
	public static String getTitle() {
		return driver.getTitle();
	}
	
	public static boolean isElementPresent(WebElement ele) {
		return ele.isDisplayed();
	}
	
	public static void enterValues(WebElement ele, String txt) {
		ele.sendKeys(txt);
	}
	
     public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
     
     public static void clickElement(WebElement ele) {
    	 ele.click();
     }
	
     public static void clearText(WebElement ele) {
    	 ele.clear();
     }
     
     
	public static void selectDropdownValue(By locator, String type, String value) {
		Select select = new Select(getElement(locator));
		
		switch (type) {
		
		case "index":
			select.selectByIndex(Integer.parseInt(value)); // Converts String to Integer -> "10" -> 10 // Integer to String Conversion  -> String.valueOf(10) -> "10"
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		 
	   default :
		   System.out.println("Pls Pass the correct selection criteria");
		   break;
			
     	}
	}
	
	public static void takeScreenShot(String fileName){
		Date d=new Date();
	    fileName=fileName+d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath="./target/screenshots/"+fileName+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
