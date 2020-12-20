package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	//PageFactory or Object repository 
	
	@FindBy(xpath ="//td[contains(text(), 'Contacts')]")
	WebElement contactsText;
	
	@FindBy(id= "first_name")
	WebElement firstName;
	
	@FindBy(id= "surname")
	WebElement lastName;
	
	@FindBy(name= "client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//input[@type='submit' and @value= 'Save']")
	WebElement saveBtn;
	
	//Initlization
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public boolean contactsText() {
		return contactsText.isDisplayed();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]//parent::td/preceding-sibling::td//input[@type='checkbox']")).click();
	}
	
	public void createNewContact(String title, String ftname, String ltname, String cname) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		companyName.sendKeys(cname);
		saveBtn.click();
		
	}
	
}
