package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


        public class LoginPage {
            public static WebDriver driver;

            public LoginPage(WebDriver driver){
                PageFactory.initElements(driver, this);
                this.driver = driver;
            }

            @FindBy(id = "user-name")
            private WebElement username;

            @FindBy(xpath = "//input[@id='password']")
            private WebElement password;

            @FindBy(xpath = "//h3")
            private WebElement errorMessage;

            @FindBy(id = "login-button")
            private WebElement loginButton;

            @FindBy(id = "react-burger-menu-btn")
            private WebElement menu;

            @FindBy(id = "logout_sidebar_link")
            private static WebElement logout;

            public void setUsername(String user){
                username.sendKeys(user);
            }

            public void setPassword(String pwd){
                password.sendKeys(pwd);
            }

            public void clickLogin(){
                loginButton.click();
            }

            public void clickMenu() {
                menu.click();
            }

            public void clickLogout() {
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].click();",logout);
            }

        }