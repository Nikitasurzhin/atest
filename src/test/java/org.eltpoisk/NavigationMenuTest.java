package org.eltpoisk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationMenuTest {
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
    public void loginTest() throws InterruptedException, UnsupportedEncodingException {

        //Arrange
        // подготовительный действия
        //Act - действия
        driver.get("https://rolf-master.elt-poisk.com/");
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
        Thread.sleep(2000);
        assertEquals("Продажа страховых продуктов", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/div/a/span")).getText()));
        assertEquals("Шаблоны", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/ul/li[1]/div/a/span")).getText()));
        assertEquals("Быстрая регистрация", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen394\"]/li[2]/div/a/span")).getText()));
        assertEquals("Сопровождение договоров страхования", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[2]/div/a/span")).getText()));
        assertEquals("Договоры страхования", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen396\"]/li[1]/div/a/span")).getText()));
        assertEquals("По номеру", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen423\"]/li/div/a/span")).getText()));
        assertEquals("Проекты на пролонгацию", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen396\"]/li[2]/div/a/span")).getText()));
        assertEquals("По номеру", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen425\"]/li/div/a/span")).getText()));
        assertEquals("Платежи", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[3]/div/a/span")).getText()));
        assertEquals("Платежи", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen398\"]/li/div/a/span")).getText()));

    }





}
