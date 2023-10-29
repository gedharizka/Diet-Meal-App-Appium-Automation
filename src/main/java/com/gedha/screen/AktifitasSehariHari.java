package com.gedha.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AktifitasSehariHari {

    public AndroidDriver<MobileElement> driver;

    public AktifitasSehariHari(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.fghilmany.dietmealapp:id/rb_very_very_low")
    private MobileElement inputMenulis;
    @AndroidFindBy(id = "com.fghilmany.dietmealapp:id/bt_finish")
    private MobileElement btnFinish;
    @AndroidFindBy(id = "com.fghilmany.dietmealapp:id/navigation_bar_item_large_label_view")
    private MobileElement txtReady;

    //Method
    public void changeInputMenulis(){
        inputMenulis.click();
    }
    public void handleBtnFinish(){
        btnFinish.click();
    }
    public String getTextDashboard(){
        return txtReady.getText();
    }

}
