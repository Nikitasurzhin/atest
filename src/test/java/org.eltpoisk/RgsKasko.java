package org.eltpoisk;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RgsKasko {
    WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static KaskoPage kaskoPage;
    String textConverter( String in){
        try {
            return new String (in.getBytes("UTF-8" ),  Charset.forName("windows-1251"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return in;
    }
    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        kaskoPage = new KaskoPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
    @Test
    public void RgsKaskoTest() throws InterruptedException {

        //Arrange
        // подготовительный действия
        //Act - действия
        driver.get(ConfProperties.getProperty("loginpageAvilon"));
        final String title = driver.getTitle();
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("loginAvilon"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("passwordAvilon"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        profilePage.clickButtonKasko();
        Thread.sleep(1000);

        kaskoPage.RegionInputField();
        kaskoPage.RegionMoscow();
        kaskoPage.FIOInputField();
        kaskoPage.DOBInputField();
        kaskoPage.MarkGeelyChoice();
        Thread.sleep(1500);
        kaskoPage.ModelAtlasProChoice();
        kaskoPage.YearChoice();
        kaskoPage.ItsNewTrue();
        kaskoPage.EngineDisplacementChoice();
        kaskoPage.AutoGearboxChoice();
        kaskoPage.CrossoverType();
        kaskoPage.FiveDoors();
        kaskoPage.CarPowerChoice();
        kaskoPage.CarMileageChoice();
        kaskoPage.CarPriceChoice();
        kaskoPage.DriverAgeChoice();
        kaskoPage.DrivingExperienceChoice();
        kaskoPage.DrivingSexChoice();
        kaskoPage.BtnNextPageClick();
        //System.out.println(textConverter(kaskoPage.RgsInfoBlock.getText()));
        //kaskoPage.RgsHullInsuranceClick();
        String RgsPriceText = kaskoPage.RgsPrice.getText();
        if (RgsPriceText == "0 руб."){
           System.out.println(kaskoPage.RgsInfoBlock.getText());
        } else {
            kaskoPage.RgsHullInsuranceClick();
        }
        kaskoPage.Surname3page();
        kaskoPage.Name3page();
        kaskoPage.MiddleName3page();
        kaskoPage.DOB3page();
        kaskoPage.DocSeria3page();
        kaskoPage.DocNumber3page();
        kaskoPage.DatePTS3page();


    }

}