package com.appmetry.trash;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
    };

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverref) {
        threadDriver.set(driverref);
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void unloadDriver() {
        threadDriver.remove();
    }

}
