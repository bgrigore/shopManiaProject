package com.endava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
/**
 * Created by bgrigore on 8/11/2015.
 */
public class SearchPage {

    private WebDriver webDriver;

    @FindBy(id="autocomplete_prod")
    private WebElement searchField;


    @FindBy(xpath = "//*[@id='main_search']/div/span[2]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='main_col']/div/ul[1]/li[4]/a")
    private WebElement menu;

    @FindBy(css = "a[href*='p-samsung-galaxy-s5-g900']")
    private WebElement mobilePhone;

    @FindBy(xpath = "//li[@itemprop='offers']")
    List<WebElement> storeList = new ArrayList<WebElement>();

    @FindBy(xpath = "//ul[1]/li/div[2]/div[3]/p[1]/a")
    private WebElement lowPrice;

    @FindBy(xpath = "//*[@id='offers_sort']/option[2]")
    private WebElement sortingSelectBox;

    @FindBy(xpath = "//ul[1]/li/div[2]/div[2]/p[1]/a[@class='inline-block']")
    private WebElement storeLowPrice;

    @FindBy(xpath = "//ul[55]/li/div[2]/div[3]/meta[1]")
    private WebElement highPrice;

    @FindBy(xpath = "//ul[55]/li/div[2]/div[2]/p/a/img")
    private WebElement storeHighPrice;


    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://www.shopmania.ro/");
    }



    /**
     * search for: Samsung Galaxy S5 G900
     */
    public void searchForProduct(String product){
        searchField.sendKeys(product);
        searchButton.submit();
        menu.click();
        mobilePhone.click();



    }




    /**
     * number of shops for: Samsung Galaxy S5 G900
     */
    public void countingNoOfShops(){
        System.out.println("The number of available shops is: " + storeList.size());
    }


    /**
     * highest price for: Samsung Galaxy S5 G900 + the name of the shop
     */
    public void checkForLowestPrice(){

        // System.out.println("The minimum price is: " + sortPriceAscending().get(0) + "\r\n");

        sortingSelectBox.click();
        System.out.println("The lowest prices is: " + lowPrice.getText());
        System.out.println("The name of the store with lowest price is: " + storeLowPrice.getAttribute("title"));
    }

    /**
     *
     *detects the heighest price and shows the price and the store name
     * @return true
     */
    public void checkForHighestPrice(String price) {



        sortingSelectBox.click();
        System.out.println("The highest price is: " + highPrice.getAttribute("content"));
        System.out.println("The store name is: " + storeHighPrice.getAttribute("alt"));

    }



}



