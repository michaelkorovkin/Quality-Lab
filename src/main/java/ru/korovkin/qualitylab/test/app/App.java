package ru.korovkin.qualitylab.test.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.korovkin.qualitylab.test.exception.TestException;
import ru.korovkin.qualitylab.test.pages.LoginPage;
import ru.korovkin.qualitylab.test.pages.MainPage;
import ru.korovkin.qualitylab.test.pages.MessagePage;


public class App 
{
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private MessagePage messagePage;

    public App () {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        messagePage = new MessagePage(driver);
    }
    public void sendLetter (String userName, String userPassword, String domain) throws TestException {
    	loginPage.open(userName, userPassword, domain);
    	mainPage.createMessage();
    	messagePage.sendMessage();
    	mainPage.logout();
    }
    public void quit () {
        driver.quit();
        driver = null;
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App application = new App();
        try {
			application.sendLetter("qualitylabtesting", "Fghtkm2012", "mail.ru");			
			application.quit();
		} catch (TestException e) {
			System.out.println(e.getMessage());
		}
       
    }
}
