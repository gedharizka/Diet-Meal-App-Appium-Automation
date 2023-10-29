package com.gedha.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Welcome {

    public AndroidDriver<MobileElement> driver;

    public Welcome(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.fghilmany.dietmealapp:id/et_name")
    private MobileElement inputName;
    @AndroidFindBy(id = "com.fghilmany.dietmealapp:id/et_weight")
    private MobileElement inputWeight;
    @AndroidFindBy(id = "com.fghilmany.dietmealapp:id/et_height")
    private MobileElement inputHeight;
    @AndroidFindBy(id = "com.fghilmany.dietmealapp:id/rb_male")
    private MobileElement inputGender;
    @AndroidFindBy(id = "com.fghilmany.dietmealapp:id/bt_next")
    private MobileElement btnNext;
    @AndroidFindBy(id = "com.fghilmany.dietmealapp:id/tv_header_desc")
    private MobileElement textActivity;


    //Method
    public void changeInputName(String name){
        this.inputName.sendKeys(name);
    }
    public void changeInputWeight(String weight){
        this.inputWeight.sendKeys(weight);
    }
    public void changeInputHeight(String height){
        this.inputHeight.sendKeys(height);
    }
    public void changeInputGender(){
        inputGender.click();
    }
    public void handleBtnNext(){
        btnNext.click();
    }

    public void quicInput(){
        inputName.sendKeys("Sigit Ramdhani");
        inputWeight.sendKeys("80");
        inputHeight.sendKeys("175");
        inputGender.click();
        btnNext.click();
    }

    public String getText(){
        return textActivity.getText();
    }


}
