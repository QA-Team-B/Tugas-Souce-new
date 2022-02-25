package pageObject;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;

import java.util.List;

public class InventoryPage {
    private static WebDriver resources;

    public InventoryPage(WebDriver resources) {
        PageFactory.initElements(resources, this);
        this.resources = resources;
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> itemsName;

    @FindBy(xpath = "//div[.='Test.allTheThings() T-Shirt (Red)']")
    private WebElement itemTshirt;

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    private WebElement clickItemTshirt;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']/parent::a")
    private WebElement itemCart;

    @FindBy(xpath = "//button[.='Add to cart']/preceding-sibling::div[.='$15.99']")
    private WebElement actual;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    private WebElement expected;


    public String isActual() {
        return actual.getText();
    }

    public String isExpected() {
        return expected.getText();
    }

    public boolean isPageDisplayed() {
        itemsName.get(0).isDisplayed();
        return true;
    }
    public void isPageclickable() {itemTshirt.click();}

    public void isItemTshirt(){clickItemTshirt.click();}

    public boolean isCartDisplayed() {
        itemCart.isDisplayed();
        return true;
    }



}
