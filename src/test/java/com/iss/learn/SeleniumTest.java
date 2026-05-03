package com.iss.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Quotes;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {

    private static final WebDriver driver = new ChromeDriver();
    private static final String baseUrl = "http://localhost:3000";


    @BeforeClass
    public void setUp() {}

    @BeforeMethod
    public void prepareTest() {}

    @AfterMethod
    public void tearDown() {}

    @AfterClass
    public void shutDown() {
        driver.quit();
    }

//    @FindBy

    @Test
    public void basicTest() {

        driver.get(baseUrl);

        try {
            WebElement dropDown = driver.findElement(By.xpath("myDropdown"));
            Select dropdownSelect = new Select(dropDown);
//            dropdownSelect.se
            Quotes quotes = new Quotes();

            System.out.println("Element found" + dropdownSelect.getOptions());

            driver.switchTo().alert();

            Actions action = new Actions(driver);
            action.moveToElement(dropDown).clickAndHold().release().build().perform();

            driver.switchTo().frame(0);


        } catch (NoSuchElementException e) {
            System.out.println("Element not found" + e);
        }



        String title = driver.getTitle();
        System.out.println("Title is: " + title);


    }

}
