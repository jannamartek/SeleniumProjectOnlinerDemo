package com.janna.page_object_ui_tests;

import com.janna.framework.DriverManager;
import com.janna.page_object.OnlinerHomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogPageTest {
    private static OnlinerHomePage onlinerHomePage;
    public static final String EXPECTED_SECTION_NAME_1 = "Onlíner Prime";
    public static final String EXPECTED_SECTION_NAME_2 = "Электроника";
    public static final String EXPECTED_SECTION_NAME_3 = "Компьютеры и сети";
    public static final String EXPECTED_SECTION_NAME_4 = "Бытовая техника";
    public static final String EXPECTED_SECTION_NAME_5 = "На каждый день";
    public static final String EXPECTED_SECTION_NAME_6 = "Стройка и ремонт";
    public static final String EXPECTED_SECTION_NAME_7 = "Дом и сад";
    public static final String EXPECTED_SECTION_NAME_8 = "Авто и мото";
    public static final String EXPECTED_SECTION_NAME_9 = "Красота и спорт";
    public static final String EXPECTED_SECTION_NAME_10 = "Детям и мамам";

    private List<String> getExpectedInCatalogSections() {
        List<String> expectedCatalogSectionName = new ArrayList<>();
        expectedCatalogSectionName.add(EXPECTED_SECTION_NAME_1);
        expectedCatalogSectionName.add(EXPECTED_SECTION_NAME_2);
        expectedCatalogSectionName.add(EXPECTED_SECTION_NAME_3);
        expectedCatalogSectionName.add(EXPECTED_SECTION_NAME_4);
        expectedCatalogSectionName.add(EXPECTED_SECTION_NAME_5);
        expectedCatalogSectionName.add(EXPECTED_SECTION_NAME_6);
        expectedCatalogSectionName.add(EXPECTED_SECTION_NAME_7);
        expectedCatalogSectionName.add(EXPECTED_SECTION_NAME_8);
        expectedCatalogSectionName.add(EXPECTED_SECTION_NAME_9);
        expectedCatalogSectionName.add(EXPECTED_SECTION_NAME_10);
        return expectedCatalogSectionName;
    }

    @BeforeClass
    public static void setup() {
        DriverManager.setDriver();
        onlinerHomePage = new OnlinerHomePage();
    }

    @Test
    public void testCheckInCatalogSections() {
        List<WebElement> catalogElements = onlinerHomePage
                .clickOnCatalogLink()
                .getCatalogClassifierItems();
        assertThat(catalogElements)
                .as("Some items were not found on the catalog page")
                .map(WebElement::getText)
                .containsExactlyElementsOf(getExpectedInCatalogSections());
    }

    @AfterClass
    public static void teardown() {
        DriverManager.closeDriver();
    }
}