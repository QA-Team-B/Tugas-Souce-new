package com.zein.sauce;

import com.zein.pageObject.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class verifyItemList {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }
     @Test
    public void positifCase2() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        String priceItemChart = loginPage.getPriceItemChart();
        String titleItemChart = loginPage.getTitleItemChart();
        loginPage.clickItemChart();
        loginPage.clickShoppingChart();
        String shoppingchart = loginPage.getPriceItemShopping();
        String titleShoppingchart = loginPage.getTitleShoppingchart();
        System.out.println(priceItemChart +" "+ titleItemChart );
        System.out.println(shoppingchart +" "+ titleShoppingchart);
        Assert.assertEquals(priceItemChart,shoppingchart);
        Assert.assertEquals(titleItemChart,titleShoppingchart);
    }
}
