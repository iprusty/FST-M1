package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	private By usernamefield = By.id("user_name");
	private By passwordfield = By.id("username_password");
	private By loginbtn = By.id("bigbutton");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void enterUsename(String username) {
		driver.findElement(usernamefield).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(passwordfield).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(loginbtn).click();
	}

}
