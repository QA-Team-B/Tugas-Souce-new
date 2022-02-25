package com.zein.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class    LoginPage { public static WebDriver driver;

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

    @FindBy(xpath =  "//button[@id='add-to-cart-sauce-labs-backpack']")
    private  WebElement addToChartItem;

    @FindBy(xpath =  "//div[@class='inventory_item_price']")
    private  WebElement priceItemChart;

    @FindBy(xpath =  "//div[@id='shopping_cart_container']/a")
    private  WebElement shoppingCartLink;

    @FindBy(xpath =  "//div[@class='inventory_item_price']")
    private  WebElement priceItemShopping;

    @FindBy(xpath = "//div[@class='inventory_list']/div[1]//div[@class='inventory_item_name']")
    private WebElement titleChartItem1;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement titleShoppingItem;

    public void setUsername(String user){
        username.sendKeys(user);
    }

    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public String getErrorMessage(){return errorMessage.getText();}

    public void clickItemChart(){
        addToChartItem.click();
    }

    public void clickShoppingChart(){
        shoppingCartLink.click();
    }

    public String getPriceItemChart(){return  priceItemChart.getText();}

    public String getPriceItemShopping(){return  priceItemShopping.getText();}

    public String getTitleItemChart(){return  titleChartItem1.getText();}

    public String getTitleShoppingchart(){return  titleShoppingItem.getText();}
}
