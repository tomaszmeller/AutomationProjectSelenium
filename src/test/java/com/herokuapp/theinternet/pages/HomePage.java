package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private final String XPATH_BASE = "//li/a[contains(text(),'%s')]";
    public final String XPATH_FOR_BASIC_AUTH = String.format(XPATH_BASE,"Basic Auth");

    public HomePage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void chooseComponentSite(String xpath) {
        driver.findElement(By.xpath(xpath));
    }
}
