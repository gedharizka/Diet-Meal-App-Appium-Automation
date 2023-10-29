package com.gedha;

import com.gedha.screen.Welcome;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class WelcomeTest {

    private static AndroidDriver<MobileElement> driver;
    private Welcome home;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "HUAWEI YAL-21");
        capabilities.setCapability("udid", "SDEDU20110000794");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.fghilmany.dietmealapp");
        capabilities.setCapability("appActivity", "com.fghilmany.dietmealapp.ui.main.MainActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By elementLocator = By.id("com.fghilmany.dietmealapp:id/header_welcome");

        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    @BeforeMethod
    public void pageObject() {
        home = new Welcome(driver);
    }

    @Test
    public void testInputWelcome() {
            home.changeInputName("Sigit Ramdhani");
            home.changeInputWeight("80");
            home.changeInputHeight("175");
            home.changeInputGender();
            home.handleBtnNext();
            String strValidation = home.getText();
            Assert.assertEquals(strValidation,"Isi formulir untuk membuat/menambahkan user");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }


}
