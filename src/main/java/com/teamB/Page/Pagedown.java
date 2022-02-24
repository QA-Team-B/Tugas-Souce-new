package com.teamB.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Pagedown {
    public static WebDriver driver;

    public Pagedown(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebElement search;

    public void dropdownAtoZ(){
        Select select = new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        select.selectByVisibleText("Name (A to Z)");
    }

    public void dropdownZtoA(){
        Select select = new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        select.selectByVisibleText("Name (Z to A)");
    }

    public void dropdownlowtohigh(){
        Select select = new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        select.selectByVisibleText("Price (low to high)");
    }

    public void dropdownhightolow(){
        Select select = new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        select.selectByVisibleText("Price (high to low)");
    }
}
