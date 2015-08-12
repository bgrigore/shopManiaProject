package com.endava;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;
/**
 * Created by bgrigore on 8/11/2015.
 */
public class ShopManiaTest {

    static WebDriver driver;
    SearchPage searchPage;
   // ProductPage productPage;

    @Before
    public  void setUp() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        searchPage =  PageFactory.initElements(driver, SearchPage.class);
    }

    @After
    public void tearDown(){

        driver.close();
    }

    @Test
    public void searchForPhoneTest(){

      searchPage.searchForProduct("galaxy s5");

        searchPage.countingNoOfShops();
        searchPage.checkForLowestPrice();
        searchPage.checkForHighestPrice("2.108,63");

    }

}

