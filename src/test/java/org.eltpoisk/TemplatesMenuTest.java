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

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplatesMenuTest {
    WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

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
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void navigationMenuTest() throws InterruptedException {

        //Arrange
        // подготовительный действия
        //Act - действия
        driver.get(ConfProperties.getProperty("loginpage"));
        final String title = driver.getTitle();
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("passwd"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        profilePage.Template();

        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/table/tbody/tr[1]/td/a/img")).isDisplayed()));
        assertEquals("Фамилия154646 И.О.", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span[1]")).getText()));
        assertEquals("0", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span[2]/strong")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]")).isDisplayed()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[1]/input[1]")).isDisplayed()));
        profilePage.clickCheckboxAll();
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[1]/input[1]")).isSelected()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"to_del_all\"]")).isDisplayed()));
        profilePage.CheckDelAll();
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"to_del_all\"]")).isSelected()));
        assertEquals("с ", textConverter(driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[2]/table/tbody/tr/td[1]")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"date_from\"]")).isDisplayed()));
        profilePage.clickDateFieldsForm();
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"calendarDiv\"]")).isDisplayed()));
        assertEquals(" по ", textConverter(driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[2]/table/tbody/tr/td[3]")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"date_to\"]")).isDisplayed()));
        profilePage.clickDateFieldsTo();
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"calendarDiv\"]")).isDisplayed()));
        profilePage.clickExitCalendare();
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[3]/select")).isDisplayed()));
        profilePage.clickFilterUsername();
        Thread.sleep(3000);







}
}