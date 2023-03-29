package com.janna.page_object;

import com.janna.framework.AbstractBasePage;
import com.janna.framework.DriverManager;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class CatalogPage extends AbstractBasePage {
    public static final String CATALOG_ONLINER_LINK = "https://catalog.onliner.by/";
    public static final String CATALOG_CLASSIFIER_ITEMS_LINK =
            "//li[.//span[contains(@class,'icon_id')]]//span[contains(@class,'wrapper')]";

    public CatalogPage() {
        DriverManager.getDriver().get(CATALOG_ONLINER_LINK);
    }

    public List<WebElement> getCatalogClassifierItems() {
        return waitForElementsVisible(xpath(CATALOG_CLASSIFIER_ITEMS_LINK));
    }
}
