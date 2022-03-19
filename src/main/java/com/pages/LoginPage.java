package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.TestUtil;

public class LoginPage extends BasePage {
	
	//Page Factory - OR:
		@FindBy(name="username")
		private WebElement userNameElement;
		
		@FindBy(name="password")
		private WebElement passwordElement;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement loginBtn;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		private WebElement signUpBtn;
		
		@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		private WebElement logoImage;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return TestUtil.getTitle();
		}
		
		public boolean validateLogoImage(){
			return TestUtil.isElementPresent(logoImage);
		}
		
		public HomePage doLogin(String userID, String password){
			TestUtil.enterValues(userNameElement, userID);
			TestUtil.enterValues(passwordElement, password);
			//loginBtn.click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
         	js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage();
		}

}
