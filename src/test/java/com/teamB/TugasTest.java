package com.teamB;
import com.teamB.Page.Login;
import com.teamB.Page.Pagedown;
import io.appium.java_client.functions.ExpectedCondition;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TugasTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {

        driver.quit();
    }



    @Test
    public void pagedownall() {
        Login login = new Login(driver);
        login.setUsername("standard_user");
        login.setPassword("secret_sauce");
        login.clickLogin();
        Pagedown pagedown = new Pagedown(driver);
        pagedown.dropdownAtoZ();
        pagedown.dropdownZtoA();
        pagedown.dropdownlowtohigh();
        pagedown.dropdownhightolow();
    }
}

