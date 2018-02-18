import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Test1 {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("https://www.phptravels.net/admin");


    }


    @Test
    public void TestElementInput() {
        WebElement input = driver.findElement(By.xpath("//input[@type=\'text\']"));
        assertEquals("email", input.getAttribute("name"));
        String position = input.getCssValue("position");
        assertEquals("relative", position);

    }


    @After
    public void tearDown() {
        driver.close();
    }
}

