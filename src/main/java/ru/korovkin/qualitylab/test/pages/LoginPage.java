package ru.korovkin.qualitylab.test.pages;



import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ru.korovkin.qualitylab.test.exception.TestException;

public class LoginPage extends Page {
    @FindBy(xpath = "//input[@id='mailbox:login']")
    WebElement login;
    @FindBy(xpath = "//select[@id='mailbox:domain']")
    WebElement domainWE;
    Select domain;
    @FindBy(xpath = "//input[@id='mailbox:password']")
    WebElement password;
    @FindBy(xpath = "//label[@id='mailbox:submit']")
    WebElement submit;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
    public void open(String userName, String password, String domain) throws TestException {
        try {
            driver.get("https://mail.ru/");
            this.login.sendKeys(userName);
            domainWE.click();
            domainWE.findElement(By.xpath("option[contains(text(),'"+domain+"')]")).click();
            this.password.sendKeys(password);
            this.submit.click();
            wait.until(presenceOfElementLocated(By.xpath("//div[@class='b-toolbar__item']/a[@title='Написать письмо (N)']")));
        } catch (Exception e) {
            throw new TestException(e.getMessage());
        }
    }

}
