package com.janna.page_object_ui_tests;

import com.janna.annotation.AnnotationTest;
import com.janna.page_object.ComputerAndNetworkPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerAndNetworkTest extends AnnotationTest {
    public static final String EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_1 = "Ноутбуки, компьютеры, мониторы";
    public static final String EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_2 = "Комплектующие";
    public static final String EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_3 = "Хранение данных";
    public static final String EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_4 = "Сетевое оборудование";

    private List<String> getExpectedComputerAndNetworksCategoryList() {
        List<String> computerAndNetworkName = new ArrayList<>();
        computerAndNetworkName.add(EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_1);
        computerAndNetworkName.add(EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_2);
        computerAndNetworkName.add(EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_3);
        computerAndNetworkName.add(EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_4);
        return computerAndNetworkName;
    }

    @Test
    public void testCheckCatalogSectionComputerAndNetwork() {
        ComputerAndNetworkPage computerAndNetworkPage = new ComputerAndNetworkPage();
        Assertions.assertThat(computerAndNetworkPage.getComputerAndNetworksCategoryItemsList())
                .as("The vertical list of section items does not appear or the item(s) " +
                        EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_1 +
                        EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_2 +
                        EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_3 +
                        EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS_NAME_4 + "are missing.")
                .map(WebElement::getText)
                .containsAll(getExpectedComputerAndNetworksCategoryList());
    }
}
