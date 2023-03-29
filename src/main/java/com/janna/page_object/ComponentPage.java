package com.janna.page_object;

import com.janna.framework.AbstractBasePage;
import com.janna.framework.DriverManager;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.janna.page_object.CatalogPage.CATALOG_ONLINER_LINK;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class ComponentPage extends AbstractBasePage {
    public static final String COMPUTER_AND_NETWORK_CATEGORY_NAME = "Компьютеры";
    public static final String ACCESSORIES_CATEGORY_NAME = "Комплектующие";
    public static final String CATALOG_ACCESSORIES_DROPDOWN_LIST_ITEMS_DESCRIPTION =
            "//div[contains(@style,'block')]//div[./div[contains(text(),'Комплектующие')]]" +
                    "//span[contains(@class,'description')]";
    public static final String CATALOG_ACCESSORIES_DROPDOWN_LIST_ITEMS_TITLE =
            "//div[contains(@style,'block')]//div[./div[contains(text(),'Комплектующие')]]" +
                    "//span[contains(@class,'title')]";
    public static final String CATALOG_COMPUTER_AND_NETWORK_LIST_ASIDE_ITEM_LINK_PATTERN =
            "//div[@data-id=2]//div[contains(text(),'%s')]";


    public ComponentPage() {
        DriverManager.getDriver().get(CATALOG_ONLINER_LINK);
    }

    public static List<WebElement> getAccessoriesCategorySideListItemsTitle() {
        return waitForElementsVisible(xpath(CATALOG_ACCESSORIES_DROPDOWN_LIST_ITEMS_TITLE));
    }

    public static List<WebElement> getAccessoriesCategorySideListItemsDescription() {
        return waitForElementsVisible(xpath(CATALOG_ACCESSORIES_DROPDOWN_LIST_ITEMS_DESCRIPTION));
    }

    public void clickOnComputerAndNetworksCategoryLink(String categoryName) {
        ComputerAndNetworkPage.clickOnCatalogClassifierLink(COMPUTER_AND_NETWORK_CATEGORY_NAME);
        waitForElementVisible(xpath(format(CATALOG_COMPUTER_AND_NETWORK_LIST_ASIDE_ITEM_LINK_PATTERN, categoryName)))
                .click();
    }

    public void clickOnAccessoriesCategoryButton() {
        clickOnComputerAndNetworksCategoryLink(ACCESSORIES_CATEGORY_NAME);
    }
}
