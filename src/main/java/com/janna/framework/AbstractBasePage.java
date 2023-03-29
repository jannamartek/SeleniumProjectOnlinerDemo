package com.janna.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class AbstractBasePage {
    public static WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 60);
        return wait.until(visibilityOfElementLocated(by));
    }

    public static List<WebElement> waitForElementsVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 60);
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (RuntimeException timeoutException) {
            System.out.println("Failed attempt to get visibility of elements.");
        }
        return Collections.emptyList();
    }
}