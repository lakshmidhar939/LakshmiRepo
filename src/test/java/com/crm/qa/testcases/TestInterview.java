package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestInterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\My Laptop\\\\Downloads\\\\geckodriver-v0.27.0-win64\\\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.myntra.com/");
		
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.className("desktop-userTitle"))).build().perform();
		
		driver.findElement(By.linkText("login / Signup")).click();
		
		
		
		
		
	}

}
