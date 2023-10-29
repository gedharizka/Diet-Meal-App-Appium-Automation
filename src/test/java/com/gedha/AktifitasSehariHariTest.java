package com.gedha;

import com.gedha.screen.AktifitasSehariHari;
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

public class AktifitasSehariHariTest {

    private static AndroidDriver<MobileElement> driver;
    private Welcome home;
    private AktifitasSehariHari aktifitasSehariHari;

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
        aktifitasSehariHari = new AktifitasSehariHari(driver);
        ;
    }

    @Test
    public void testInputAktifitas() {
            home.quicInput();
            aktifitasSehariHari.changeInputMenulis();
            aktifitasSehariHari.handleBtnFinish();
            String strValidation= aktifitasSehariHari.getTextDashboard();
            Assert.assertEquals(strValidation,"Home");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }


}
