package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName= "contacts";
	
public ContactsPageTest() {
	super();
}


@BeforeMethod
public void setUP() throws InterruptedException {
	initialization();
	testUtil= new  TestUtil();
	 loginPage= new LoginPage();
	 contactsPage = new ContactsPage();
	 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 testUtil.switchToFrame();
	 contactsPage= homePage.clickOnContactLink();
	
}

@Test(priority=1, enabled=false)
public void contactsTextTest() {
	Assert.assertTrue(contactsPage.contactsText(), "Contacts lable is missing on the page");
	
}

@Test(priority=2, enabled=false)
public void selectContactByNameTest() {
	contactsPage.selectContactByName("abhishek");
	
}

@Test(priority=3, enabled=false)
public void selectContacstByNameTest() {
	contactsPage.selectContactByName("abhishek");
	contactsPage.selectContactByName("4");
	
}

@DataProvider
public Object[][] getCRMTestData() {
	
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
}

@Test(priority=4, dataProvider="getCRMTestData")
public void createNewContactTest(String title, String firstName, String LastName, String company) {
	homePage.clickOnNewContactLink();
	//contactsPage.createNewContact("Mr.", "Lakshmidhar", "Ratnala", "Unimoni");
	contactsPage.createNewContact(title, firstName,LastName, company );
}

@AfterMethod
public void burnDown() {
	driver.quit();
}

}
