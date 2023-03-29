package com.janna.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {
    protected static final Logger LOG = LoggerFactory.getLogger(DriverManager.class);
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
            driver.get().manage().window().maximize();
        } else {
            System.out.println("Driver has been set: " + Thread.currentThread().getId());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        try {
            driver.get().quit();
            driver.remove();
        } catch (Exception e) {
            LOG.error("CLOSE DRIVER ERROR: {}", e.getMessage(), e);
        }
    }
}