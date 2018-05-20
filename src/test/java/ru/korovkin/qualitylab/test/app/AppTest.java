package ru.korovkin.qualitylab.test.app;

import org.junit.*;
/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testApp()
    {
    	try {
    		App application = new App();
    		application.sendLetter("qualitylabtesting", "Fghtkm2012", "mail.ru");
    		application.quit();
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		Assert.assertFalse(true);
    	}
        Assert.assertTrue( true );
    }
}
