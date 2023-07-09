package com.herokuapp.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestUtilities;

import java.util.concurrent.TimeUnit;

public class BasicAuthTest extends TestUtilities {
    private final String username = "admin";
    private final String password = "admin";
    private final String authUrl = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
    private final Logger logger = LogManager.getLogger(BasicAuthTest.class);
    @Override
    public void testSetUp() {
        logger.info("Setting up test environment...");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        logger.info("Setting up test environment...DONE!");
    }

    @Test
    public void basicAuthorisationSteps() {
        logger.info("Performing test steps...");

        driver.get(authUrl);
        Assert.assertTrue("Authorization failed!", checkIfAuthorizationSucceed());

        logger.info("Performing test steps...DONE!");
    }

    private boolean checkIfAuthorizationSucceed() {
        logger.info("Checking if authorization ends with success...");

        WebElement successText = driver.findElement(By.xpath("//div/p[contains(text(), 'Congratulations')]"));

        logger.info("Checking if authorization ends with success...DONE!");
        return successText.isDisplayed();
    }
}
