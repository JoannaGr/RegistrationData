package com.infoshare;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class DateTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://demoqa.com/datepicker/");
    }

    @Test
    public void chooseDate() {
        final String EXAMPLE_DATE = "May 28, 2018";

        WebElement dateTable = driver.findElement(By.xpath("//input[@id='datepicker1']"));
        dateTable.clear();
        dateTable.sendKeys(EXAMPLE_DATE);

        WebElement dateValue = driver.findElement(By.xpath("//input[@id='datepicker1']"));
        assertEquals(EXAMPLE_DATE, dateValue.getAttribute("value"));

    }
    @After
    public void tearDown(){
        driver.close();
    }
}

