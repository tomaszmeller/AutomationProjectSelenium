package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestUtilities
{
    public WebDriver driver;
    private static final Logger logger = LogManager.getLogger(TestUtilities.class);
    @Before
    public void testSetUp()
    {
        logger.info("Setting up test environment...");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");

        logger.info("Setting up test environment...DONE!");
    }

    @After
    public void cleanUpAfterTest()
    {
        logger.info("Cleaning up after test...");

        driver.quit();

        logger.info("Cleaning up after test...DONE!");
    }
}
