package com.thetestingacademy.pages.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM {

    WebDriver driver;

    public LoginPage_POM(WebDriver driver){

        this.driver = driver;
        //default constructors are created for encapsulating the data

    }

    //page locators

    //using private because of encapsulation, so that noone can use this username& passwd outside
    private By username = By.id("login-username");
    private By passwd = By.id("login-password");
    private By signBtn = By.id("js-login-btn");
    private By errorMsg = By.id("js-notification-box-msg");



    //page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd){

        driver.findElement(username).sendKeys(user);
        driver.findElement(passwd).sendKeys(pwd);
        driver.findElement(signBtn).click();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

      String error_msg_text =  driver.findElement(errorMsg).getText();
        return error_msg_text;
    }


    public void loginToVWOLoginValidCreds(String user, String pwd) {

        driver.findElement(username).sendKeys(user);
        driver.findElement(passwd).sendKeys(pwd);
        driver.findElement(signBtn).click();

    }


}
