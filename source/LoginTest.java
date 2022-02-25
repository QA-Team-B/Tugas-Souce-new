package source;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.InventoryPage;
import pageObject.LoginPage;
import pageObject.LogoutPage;

import java.util.HashMap;
import java.util.Map;

    public class LoginTest {

        private WebDriver driver;
        private Map<String, Object> vars;
        JavascriptExecutor js;

        @Before
        public void setUp() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            js = (JavascriptExecutor) driver;
            vars = new HashMap<String, Object>();
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);
        }

        @After
        public void tearDown() {
            driver.quit();
        }

        @Test
        public void negativeCase1() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsername("admin");
            loginPage.setPassword("password");
            loginPage.clickLogin();
            //String error = loginPage.getErrorMessage();
            //Assert.assertTrue(error.contains("Username and password do not match any user in this service"));
        }

        @Test
        public void negativeCase2() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsername("admin");
            loginPage.setPassword("");
            loginPage.clickLogin();
            //String error = loginPage.getErrorMessage();
            //Assert.assertTrue(error.contains("Password is required"));
        }

        @Test
        public void negativeCase3() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsername("");
            loginPage.setPassword("password");
            loginPage.clickLogin();
            //String error = loginPage.getErrorMessage();
            //Assert.assertTrue(error.contains("Username is required"));
        }

        @Test
        public void positiveCase() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLogin();

            InventoryPage inventoryPage = new InventoryPage(driver);
            Assert.assertTrue(inventoryPage.isPageDisplayed());
        }

        @Test
        public void AddtoChart() throws InterruptedException{
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLogin();
            Thread.sleep(3000);
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.isPageclickable();
            Thread.sleep(3000);
            String Actual = inventoryPage.isActual();
            Thread.sleep(3000);
            String Expected = inventoryPage.isExpected();
            Thread.sleep(5000);
            Assert.assertEquals(Expected, Actual);
        }


        @Test
        public void successfullyLogout() throws InterruptedException{
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLogin();
            loginPage.clickMenu();
            Thread.sleep(3000);
            loginPage.clickLogout();
            Thread.sleep(3000);
        }

    }


