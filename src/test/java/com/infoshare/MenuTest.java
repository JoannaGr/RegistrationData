package com.infoshare;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class MenuTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://demoqa.com/menu/");
    }

    @Test
    public void menuElements() {
        List<WebElement> allElements = driver.findElements(By.xpath("//html//div[@id='tabs-1']//li"));
        List<String> expectedMenuElements = Arrays.asList("Home", "About", "Contact", "FAQ", "News");

        List<String> menuElements = allElements.stream().map(WebElement::getText).collect(Collectors.toList());

        assertTrue(menuElements.containsAll(expectedMenuElements));

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
