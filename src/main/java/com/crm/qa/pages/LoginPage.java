package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page factory or Object repository 
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(xpath= "//input[contains(@class, 'btn btn-small')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Up')]")
	WebElement signUpLink;
	
	@FindBy(xpath= "//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	//initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException  {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginBtn.click();
		return new HomePage();
		
	}

}
