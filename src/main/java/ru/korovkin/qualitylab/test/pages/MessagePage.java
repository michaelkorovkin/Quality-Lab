package ru.korovkin.qualitylab.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import ru.korovkin.qualitylab.test.exception.TestException;

public class MessagePage extends Page {
	@FindBy(xpath = "//textarea[@data-original-name='To']")
	WebElement messageTo;
	@FindBy(xpath = "//input[@name='Subject']")
	WebElement messageSubject;
	@FindBy(xpath = "//iframe[contains(@id,'composeEditor_ifr')]")
	WebElement iframe;
	@FindBy(xpath = "//div[@data-name='send']")
	WebElement messageSend;
	
	public MessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void sendMessage() throws TestException {
		try {
			messageTo.sendKeys("kormichael@mail.ru");
			messageSubject.sendKeys("Тестовое сообщение");
			driver.switchTo().frame(iframe);
			driver.findElement(By.id("tinymce")).click();
			driver.findElement(By.id("tinymce")).clear();
			driver.findElement(By.id("tinymce")).sendKeys("Тестовое письмо.");
			driver.switchTo().defaultContent();
			messageSend.click();
		} catch (Exception e) {
			throw new TestException(e.getMessage());
		}
	}

}
