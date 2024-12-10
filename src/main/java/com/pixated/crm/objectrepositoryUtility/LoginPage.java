package com.pixated.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	/*   5 Steps to create Pom class
	 * Create a separate java class
	 * Object Creation
	 * Object Initialization
	 * Object Encapsulation
	 * Provide Action
	 */
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);//this indicates this class 
	}
     //Encapsulated store all the webelement
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement loginbutton;

	//Getter for Acess the element
	public WebElement getUsername() {
		return username;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginbutton() {
		return loginbutton;
	}


	public void loginOperation(String username,String password) {
		driver.manage().window().maximize();//In constructor we gave driver referenece so here we can Acess
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginbutton().click();
	}
}
