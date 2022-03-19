package com.seleniumPractice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4_Feature_CreateNewTab_Window {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://google.com");

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://amazon.com");

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://facebook.com");

		Set<String> handles = driver.getWindowHandles();

		List<String> ls = new ArrayList<String>(handles);

//	   String googleWindowID = ls.get(0);
//	   String amazonWindowID = ls.get(1);
//	   String facebookWindowID = ls.get(2);

		System.out.println("List size: " + ls.size());

		System.out.println(ls.get(0));
		System.out.println(ls.get(1));
		System.out.println(ls.get(2));

		int i = ls.size() - 1;

	 	do {
				System.out.println(driver.getTitle());
				driver.close();
				driver.switchTo().window(ls.get(i-1));
				i--;
			} while (i > 0);
			driver.switchTo().window(ls.get(0));
			System.out.println(driver.getTitle());
			driver.quit();
		

	}
}
