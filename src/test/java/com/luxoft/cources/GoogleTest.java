package com.luxoft.cources;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    void testSearch() {
        driver.get("http://google.ru");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Selenium 3.0");
//        WebElement btn = driver.findElement(By.name("btnG"));
        WebElement btn = driver.findElements(By.name("btnK")).get(0);
        btn.click();
    }

//    @AfterAll
//    public static void tearDown() {
//        driver.quit();
//    }

}
