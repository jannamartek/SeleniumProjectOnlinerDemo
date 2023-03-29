package com.janna.page_object;

import com.janna.framework.AbstractBasePage;
import com.janna.framework.DriverManager;
import org.openqa.selenium.By;

public class OnlinerHomePage extends AbstractBasePage {
    public static final String ONLINER_LINK = "https://www.onliner.by/";
    public static final String ONLINER_CATALOG_PATTERN = "//*[@class='b-top-menu']//a[contains(@href,'catalog')]";


    public OnlinerHomePage() {
        DriverManager.getDriver().get(ONLINER_LINK);
    }

    public CatalogPage clickOnCatalogLink() {
        waitForElementVisible(By.xpath(ONLINER_CATALOG_PATTERN)).click();
        return new CatalogPage();
    }
}
