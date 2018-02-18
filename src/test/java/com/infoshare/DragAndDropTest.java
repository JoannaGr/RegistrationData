package com.infoshare;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class DragAndDropTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://demoqa.com/droppable/");
    }
    @Test
    public void DragAndDrop(){
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggableview']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppableview']"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(drag, drop).build().perform();

        String actualText=driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]")).getText();
        assertEquals(actualText, "Dropped!");
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
