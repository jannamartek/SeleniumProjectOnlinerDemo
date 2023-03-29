package com.janna.page_object;

import com.janna.framework.AbstractBasePage;
import com.janna.framework.DriverManager;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.janna.page_object.CatalogPage.CATALOG_ONLINER_LINK;
import static com.janna.page_object.ComponentPage.COMPUTER_AND_NETWORK_CATEGORY_NAME;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class ComputerAndNetworkPage extends AbstractBasePage {
    public static final String CATALOG_COMPUTER_AND_NETWORK_LIST_ASIDE_ITEMS =
            "//div[@data-id=2]//div[contains(@class,'aside-title')]";
    public static final String CATALOG_CLASSIFIER_ITEM_LINK_PATTERN = "//li[.//span[contains(text(),'%s')]]";

    public ComputerAndNetworkPage() {
        DriverManager.getDriver().get(CATALOG_ONLINER_LINK);
    }

    public static void clickOnCatalogClassifierLink(String categoryName) {
        waitForElementVisible(xpath(format(CATALOG_CLASSIFIER_ITEM_LINK_PATTERN, categoryName))).click();
    }

    public static List<WebElement> getComputerAndNetworksCategoryItemsList() {
        clickOnCatalogClassifierLink(COMPUTER_AND_NETWORK_CATEGORY_NAME);
        return waitForElementsVisible(xpath(CATALOG_COMPUTER_AND_NETWORK_LIST_ASIDE_ITEMS
        ));
    }
}


