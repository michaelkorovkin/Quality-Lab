package ru.korovkin.qualitylab.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.korovkin.qualitylab.test.exception.TestException;

public class MainPage extends Page {
	@FindBy(xpath = "//div[@class='b-toolbar__item']/a[@title='Написать письмо (N)']")
	WebElement createLetter;
	@FindBy(xpath = "//a[@id='PH_logoutLink']")
	WebElement logOut;	

	
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void createMessage() throws TestException {		
		try {
			createLetter.click();
		} catch (Exception e) {
			throw new TestException(e.getMessage());
		}
	}
	public void logout() throws TestException {
		try {
			logOut.click();
		} catch (Exception e) {
			throw new TestException(e.getMessage());
		}	
		
	}

}
