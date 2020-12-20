package com.crm.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class myntraTest {

	@Test
	public void loginMyntra() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\My Laptop\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class]/child::button[contains(text(), '3')]")).click();
		
		driver.findElement(By.xpath("//img[contains(@src, 'Nike')]")).click();
		driver.findElement(By.xpath("//h4 [@class='atsa-title' and contains(text(), 'Size')]")).click();
		driver.findElement(By.xpath("//label[@class='common-customCheckbox' and contains(text(), '200-220 ml')]/child::div[@class='common-checkboxIndicator']")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='sort-sortBy']"))).build().perform();
		driver.findElement(By.xpath("//label[contains(text(), 'Price: Low to High')]")).click();
		/*action.moveToElement(driver.findElement(By.className("desktop-userTitle"))).build().perform();
		driver.findElement(By.className("desktop-linkButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("9393397933");
		driver.findElement(By.className("submitBottomOption")).click();
		driver.findElement(By.xpath("//div[@class='bottomeLink']/child::span[contains(text(), 'Password')]")).click();
		
		*/
	}
	
	
}
