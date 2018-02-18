package com.infoshare;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://demoqa.com/registration/");
    }

    @Test
    public void fillRegistrationForm() {
        WebElement firstName = driver.findElement(By.xpath("//input[@id='name_3_firstname']"));
        firstName.clear();
        firstName.sendKeys("Mateusz");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='name_3_lastname']"));
        lastName.clear();
        lastName.sendKeys("Iksiński");


        if (!driver.findElement(By.xpath("//input[@value='married']")).isSelected()) {
            driver.findElement(By.xpath("//input[@value='married']")).click();

        }
        if (!driver.findElement(By.xpath("//input[@value='dance']")).isSelected()) {
            driver.findElement(By.xpath("//input[@value='dance']")).click();
        }

        Select selectCounry = new Select(driver.findElement(By.id("dropdown_7")));
        selectCounry.selectByVisibleText("Poland");

        Select selectMonth = new Select(driver.findElement(By.id("mm_date_8")));
        selectMonth.selectByVisibleText("8");
        Select selectDay = new Select(driver.findElement(By.id("dd_date_8")));
        selectDay.selectByVisibleText("20");
        Select selectYear = new Select(driver.findElement(By.id("yy_date_8")));
        selectYear.selectByVisibleText("1987");

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='phone_9']"));
        phoneNumber.clear();
        phoneNumber.sendKeys("0123456788");

        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.clear();
        userName.sendKeys("MateuszIks");

        WebElement email = driver.findElement(By.xpath("//input[@id='email_1']"));
        email.clear();
        email.sendKeys("mateusz@iks.pl");

        WebElement aboutYourself = driver.findElement(By.xpath("//textarea[@id='description']"));
        aboutYourself.clear();
        aboutYourself.sendKeys("ankdjhncnckmckjfkvkcj");

        WebElement password = driver.findElement(By.xpath("//input[@id='password_2']"));
        password.clear();
        password.sendKeys("123abc456def789#");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='confirm_password_password_2']"));
        confirmPassword.clear();
        confirmPassword.sendKeys("123abc456def789#");

        if (!driver.findElement(By.xpath("//input[@name='pie_submit']")).isSelected()) {
            driver.findElement(By.xpath("//input[@name='pie_submit']")).click();

        }
        WebElement positiveRegistration = driver.findElement(By.className("piereg_message"));
        assertEquals("Thank you for your registration", positiveRegistration.getText());


    }

    @After
    public void tearDown() {
        driver.close();
    }
}
