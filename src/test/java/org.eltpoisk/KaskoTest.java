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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class KaskoTest {
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
        Thread.sleep(1000);
        kaskoPage.DepartmentRGS();
        Thread.sleep(1000);
        kaskoPage.changeUserDepartmentCombo();
        kaskoPage.SubmitDepartment();
        Thread.sleep(1000);
        kaskoPage.SubmitDepartmentTwo();
        Thread.sleep(5000);
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
       // kaskoPage.RgsHullInsuranceClick();

        String RgsPriceText = (kaskoPage.Price.getText());
        if (RgsPriceText.trim().equals("0 руб."))
               {
          System.out.println(textConverter(kaskoPage.InfoBlock.getText()));
        }
               else
        {
            kaskoPage.HullInsuranceClick();

        }
        kaskoPage.Surname3page();
        kaskoPage.Name3page();
        kaskoPage.MiddleName3page();
        kaskoPage.DOB3page();
        kaskoPage.DocSeria3page();
        kaskoPage.DocNumber3page();
        kaskoPage.DatePTS3page();
        kaskoPage.PageNext3page();
        kaskoPage.NumberVIN4page();
        kaskoPage.SeriaPTS4page();
        kaskoPage.NumberPTS4page();
        kaskoPage.ClickInsurerClientCardButton();
        kaskoPage.EnterSurnameClientCard();
        kaskoPage.EnterNameClientCard();
        kaskoPage.ClickSearchButtonClientCard();
        kaskoPage.SelectPerson();
        Actions actions = new Actions(driver);
        actions.doubleClick(kaskoPage.PersonKK).perform();
        Thread.sleep(5000);
        kaskoPage.ClickSelectButtonKK();
        Thread.sleep(5000);
        kaskoPage.KeyCount();
        kaskoPage.FaceClick();
        kaskoPage.USER_1_FULL_NAME();
        kaskoPage.USER_1_EXP_DATE();
        kaskoPage.USER_1_BIRTH_DATE();
        kaskoPage.USER_1_DOC_SERIA();
        kaskoPage.USER_1_DOC_NUMBER();
        kaskoPage.ClickButtonNext4page();
        //kaskoPage.SavePreliminaryKaskoPolice();
        Thread.sleep(5000);
        driver.get("https://dashboard.elt-poisk.com:443/units/184f5a89//print/pkg_print.php?file_to_print=print/RGS/policy_kasko.php&amp;product=KASKO&amp;insurer=RGS&amp;pf_id=0&amp;session184f5a89=ac0hic1gfno2qbk5n1ch1ofbj6&amp;nocache=1717164675");
        kaskoPage.ButtonSave();
        kaskoPage.ClickCONTRACT_DOUBLE_SAVE();
        kaskoPage.ButtonSave();
        Thread.sleep(5000);

    }
    @Test
    public void ResoKaskoTest() throws InterruptedException {
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
        Thread.sleep(1000);
        kaskoPage.DepartmentRESO();
        Thread.sleep(1000);
        kaskoPage.changeUserDepartmentCombo();
        kaskoPage.SubmitDepartment();
        Thread.sleep(1000);
        kaskoPage.SubmitDepartmentTwo();
        Thread.sleep(5000);
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

        String PriceText = (kaskoPage.Price.getText());
        if (PriceText.trim().equals("0 руб."))
        {
            System.out.println(textConverter(kaskoPage.InfoBlock.getText()));
        }
        else
        {
            kaskoPage.HullInsuranceClick();

        }
        kaskoPage.ResoGarantijaDateBuyTS();
        kaskoPage.NumberVIN4page();
        kaskoPage.ResoGarantijaSeats();
        kaskoPage.ContractBeginDate();
        kaskoPage.PageNext3page();
        kaskoPage.SeriaPTS4page();
        kaskoPage.NumberPTS4page();
        kaskoPage.DatePTS3page();
        kaskoPage.KeyCount();
        kaskoPage.ClickInsurerClientCardButton();
        kaskoPage.EnterSurnameClientCard();
        kaskoPage.EnterNameClientCard();
        kaskoPage.ClickSearchButtonClientCard();
        kaskoPage.SelectPerson();
        Actions actions = new Actions(driver);
        actions.doubleClick(kaskoPage.PersonKK).perform();
        Thread.sleep(10000);
        kaskoPage.ClickSelectButtonKK();
        Thread.sleep(5000);
        kaskoPage.FaceClick();
        kaskoPage.USER_1_FULL_NAME();
        kaskoPage.USER_1_EXP_DATE();
        kaskoPage.USER_1_BIRTH_DATE();
        kaskoPage.USER_1_DOC_SERIA();
        kaskoPage.USER_1_DOC_NUMBER();
        kaskoPage.InsuranceObjectColour();
        kaskoPage.ClickButtonNext4page();
        kaskoPage.ResoPolic();

        Thread.sleep(7000);

            }
    @Test
    public void RensinsKaskoTest() throws InterruptedException {
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
        Thread.sleep(1000);
        kaskoPage.DepartmentRenins();
        Thread.sleep(1000);
        kaskoPage.changeUserDepartmentCombo();
        kaskoPage.SubmitDepartment();
        Thread.sleep(1000);
        kaskoPage.SubmitDepartmentTwo();
        Thread.sleep(5000);
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

        String PriceText = (kaskoPage.Price.getText());
        if (PriceText.trim().equals("0 руб."))
        {
            System.out.println(textConverter(kaskoPage.InfoBlock.getText()));
        }
        else
        {
            kaskoPage.HullInsuranceClick();

        }


}
    @Test
    public void SovcomKaskoTest() throws InterruptedException {
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
        Thread.sleep(1000);
        kaskoPage.DepartmentSovcom();
        Thread.sleep(1000);
        kaskoPage.changeUserDepartmentCombo();
        kaskoPage.SubmitDepartment();
        Thread.sleep(1000);
        kaskoPage.SubmitDepartmentTwo();
        Thread.sleep(5000);
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
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div[4]/div/div/div/div/div/span")));
        String PriceText = (kaskoPage.Price.getText());
        if (PriceText.trim().equals("0 руб."))
        {
            System.out.println(textConverter(kaskoPage.InfoBlock.getText()));
        }
        else
        {
            kaskoPage.HullInsuranceClick();

        }
        Thread.sleep(10000);
        kaskoPage.ContractBeginDate();
        kaskoPage.SovkomBank77DateBuy();
        kaskoPage.PageNext3page();
        kaskoPage.NumberVIN4page();
        kaskoPage.SeriaPTS4page();
        kaskoPage.NumberPTS4page();
        kaskoPage.DatePTS3page();
        kaskoPage.KeyCount();
        kaskoPage.ClickInsurerClientCardButton();
        kaskoPage.EnterSurnameClientCard();
        kaskoPage.EnterNameClientCard();
        kaskoPage.ClickSearchButtonClientCard();
        kaskoPage.SelectPerson();
        Actions actions = new Actions(driver);
        actions.doubleClick(kaskoPage.PersonKK).perform();
        Thread.sleep(10000);
        kaskoPage.ClickSelectButtonKK();
        Thread.sleep(5000);
        kaskoPage.FaceClick();
        kaskoPage.USER_1_FULL_NAME();
        kaskoPage.USER_1_EXP_DATE();
        kaskoPage.USER_1_BIRTH_DATE();
        kaskoPage.USER_1_DOC_SERIA();
        kaskoPage.USER_1_DOC_NUMBER();
        kaskoPage.USER_1_DOC_DATE();
        kaskoPage.ClickButtonNext4page();

    }
    @Test
    public void EnergoKaskoTest() throws InterruptedException {
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
        Thread.sleep(1000);
        kaskoPage.DepartmentEnergo();
        Thread.sleep(1000);
        kaskoPage.changeUserDepartmentCombo();
        kaskoPage.SubmitDepartment();
        Thread.sleep(1000);
        kaskoPage.SubmitDepartmentTwo();
        Thread.sleep(5000);
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
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div[4]/div/div/div/div/div/span")));
        String PriceText = (kaskoPage.Price.getText());
        if (PriceText.trim().equals("0 руб."))
        {
            System.out.println(textConverter(kaskoPage.InfoBlock.getText()));
        }
        else
        {
            kaskoPage.HullInsuranceClick();

        }
        kaskoPage.ContractBeginDate();
        kaskoPage.NumberVIN4page();
        kaskoPage.PageNext3page();
        kaskoPage.NumberPTS4page();
        kaskoPage.SeriaPTS4page();
        kaskoPage.DatePTS3page();
        kaskoPage.InsuranceObjectKuzov();
        kaskoPage.InsuranceObjectColor();
        kaskoPage.InsuranceObjectChangeDocTs();
        kaskoPage.InsuranceObjectPtsRegion();
        kaskoPage.INSURANCE_OBJECT_PTS_BY_KZ();
        kaskoPage.INSURANCE_OBJECT_PTS_GIBDD();
        kaskoPage.INSURANCE_OBJECT_OWNER_COUNT();
        kaskoPage.INSURANCE_OBJECT_FINDED_TS();
        kaskoPage.INSURANCE_OBJECT_CHANGE_VIN();
        kaskoPage.INSURANCE_OBJECT_BU_TS();
        kaskoPage.INSURANCE_OBJECT_MOLDING();
        kaskoPage.INSURANCE_OBJECT_TOTAL_REPAIR();
        kaskoPage.INSURANCE_OBJECT_EXHIBITION();
        kaskoPage.ClickInsurerClientCardButton();
        kaskoPage.EnterSurnameClientCard();
        kaskoPage.EnterNameClientCard();
        kaskoPage.ClickSearchButtonClientCard();
        kaskoPage.SelectPerson();
        Actions actions = new Actions(driver);
        actions.doubleClick(kaskoPage.PersonKK).perform();
        Thread.sleep(10000);
        kaskoPage.ClickSelectButtonKK();
        Thread.sleep(5000);
        kaskoPage.FaceClick();
        kaskoPage.USER_1_FULL_NAME();
        kaskoPage.USER_1_EXP_DATE();
        kaskoPage.USER_1_BIRTH_DATE();
        kaskoPage.USER_1_DOC_SERIA();
        kaskoPage.USER_1_DOC_NUMBER();
        kaskoPage.USER_1_DOC_DATE();
        kaskoPage.ClickButtonNext4page();


    }

}