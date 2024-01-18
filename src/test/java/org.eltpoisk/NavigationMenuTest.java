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
    public void navigationMenuTest() throws InterruptedException{

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

        assertEquals("Продажа страховых продуктов", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/div/a/span")).getText()));
        assertEquals("Шаблоны", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/ul/li[1]/div/a/span")).getText()));
        assertEquals("Быстрая регистрация", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen394\"]/li[2]/div/a/span")).getText()));
        assertEquals("Сопровождение договоров страхования", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[2]/div/a/span")).getText()));
        assertEquals("Договоры страхования", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen396\"]/li[1]/div/a/span")).getText()));
        assertEquals("По номеру", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/ul/li/div/a/span")).getText()));
        assertEquals("Проекты на пролонгацию", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen396\"]/li[2]/div/a/span")).getText()));
        assertEquals("По номеру", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/ul/li/div/a/span")).getText()));
        assertEquals("Платежи", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[3]/div/a/span")).getText()));
        assertEquals("Платежи", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen398\"]/li/div/a/span")).getText()));
        assertEquals("Ошибки", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[4]/div/a/span")).getText()));
        assertEquals("Журнал ошибок", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen400\"]/li/div/a/span")).getText()));
        assertEquals("Бланки строгой отчетности", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[5]/div/a/span")).getText()));
        assertEquals("Выдача/передача БСО", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen402\"]/li[1]/div/a/span")).getText()));
        assertEquals("Передача БСО", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[1]/ul/li[1]/div/a/span")).getText()));
        assertEquals("Прием БСО от СК", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[1]/ul/li[2]/div/a/span")).getText()));
        assertEquals("Прием БСО от СК", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[1]/ul/li[2]/ul/li/div/a/span")).getText()));
        assertEquals("Журнал номенклатуры БСО", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen402\"]/li[2]/div/a/span")).getText()));
        assertEquals("Журнал номенклатуры БСО", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[2]/ul/li[1]/div/a/span")).getText()));
        assertEquals("Видимость номенклатуры", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[2]/ul/li[2]/div/a/span")).getText()));
        assertEquals("Журнал операций с БСО", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen402\"]/li[3]/div/a/span")).getText()));
        assertEquals("Движение БСО", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[3]/ul/li/div/a/span")).getText()));
        assertEquals("Утилиты", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen402\"]/li[4]/div/a/span")).getText()));
        assertEquals("Генерация БСО", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[4]/ul/li/div/a/span")).getText()));
        assertEquals("Журнал номенклатуры БСО", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen402\"]/li[2]/div/a/span")).getText()));
        assertEquals("Журнал номенклатуры БСО", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[2]/ul/li[1]/div/a/span")).getText()));
        assertEquals("Видимость номенклатуры", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[2]/ul/li[2]/div/a/span")).getText()));
        assertEquals("Журнал операций с БСО", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen402\"]/li[3]/div/a/span")).getText()));
        assertEquals("Движение БСО", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[3]/ul/li/div/a/span")).getText()));
        assertEquals("Утилиты", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen402\"]/li[4]/div/a/span")).getText()));
        assertEquals("Генерация БСО", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[4]/ul/li/div/a/span")).getText()));
        assertEquals("Комиссионное вознаграждение", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[6]/div/a/span")).getText()));
        assertEquals("Журнал агентских договоров", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen404\"]/li[1]/div/a/span")).getText()));
        assertEquals("Журнал программ КВ", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen404\"]/li[2]/div/a/span")).getText()));
        assertEquals("Реестр начисленного КВ", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen404\"]/li[3]/div/a/span")).getText()));
        assertEquals("Акты", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[7]/div/a/span")).getText()));
        assertEquals("Журнал актов", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen406\"]/li/div/a/span")).getText()));
        assertEquals("Акты", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[7]/div/a/span")).getText()));
        assertEquals("Скидки", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[8]/div/a/span")).getText()));
        assertEquals("Управление скидками", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen408\"]/li/div/a/span")).getText()));
        assertEquals("Автокредитование", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[9]/div/a/span")).getText()));
        assertEquals("Приоритеты по банкам", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen410\"]/li[1]/div/a/span")).getText()));
        assertEquals("Кредитный калькулятор", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen410\"]/li[2]/div/a/span")).getText()));
        assertEquals("Кредитные заявки", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen410\"]/li[3]/div/a/span")).getText()));
        assertEquals("Сверка с банком", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen410\"]/li[4]/div/a/span")).getText()));
        assertEquals("Комиссионное вознаграждение", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen410\"]/li[5]/div/a/span")).getText()));
        assertEquals("Программы КВ", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[9]/ul/li[5]/ul/li[1]/div/a/span")).getText()));
        assertEquals("Начисленное КВ", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[9]/ul/li[5]/ul/li[2]/div/a/span")).getText()));
        assertEquals("Кумулятивная маржа", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[9]/ul/li[5]/ul/li[3]/div/a/span")).getText()));
        assertEquals("Администрирование", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen410\"]/li[6]/div/a/span")).getText()));
        assertEquals("Настройка кредитных программ", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[9]/ul/li[6]/ul/li[2]/div/a/span")).getText()));
        assertEquals("Настройка формул банка", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[9]/ul/li[6]/ul/li[3]/div/a/span")).getText()));
        assertEquals("Загрузка/обновление кредитных программ", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[9]/ul/li[6]/ul/li[4]/div/a/span")).getText()));
        assertEquals("Клиенты", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[10]/div/a/span")).getText()));
        assertEquals("Карточка клиента", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen412\"]/li/div/a/span")).getText()));
        assertEquals("Дополнительные инструменты", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[11]/div/a/span")).getText()));
        assertEquals("Аналитика тарифов", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen414\"]/li/div/a/span")).getText()));
        assertEquals("Администрирование", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[12]/div/a/span")).getText()));
        assertEquals("Подразделения", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen416\"]/li[1]/div/a/span")).getText()));
        assertEquals("Управление подразделениями", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[1]/ul/li/div/a/span")).getText()));
        assertEquals("Пользователи", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen416\"]/li[2]/div/a/span")).getText()));
        assertEquals("Управление пользователями", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[2]/ul/li/div/a/span")).getText()));
        assertEquals("Страховые компании", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen416\"]/li[3]/div/a/span")).getText()));
        assertEquals("Описание условий страхования", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[3]/ul/li[1]/div/a/span")).getText()));
        assertEquals("Управление страховыми компаниями", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[3]/ul/li[2]/div/a/span")).getText()));
        assertEquals("Управление страховыми продуктами", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[3]/ul/li[3]/div/a/span")).getText()));
        assertEquals("Управление инф. сообщениями", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[3]/ul/li[4]/div/a/span")).getText()));
        assertEquals("Управление универсальным продуктом", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[3]/ul/li[5]/div/a/span")).getText()));
        assertEquals("Загрузка/выгрузка платежей", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen416\"]/li[4]/div/a/span")).getText()));
        assertEquals("Рекомендации по оформлению", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen416\"]/li[5]/div/a/span")).getText()));
        assertEquals("Дополнительные настройки", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen416\"]/li[6]/div/a/span")).getText()));
        assertEquals("Добавление дополнительных полей", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[6]/ul/li/div/a/span")).getText()));
        assertEquals("О системе", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen416\"]/li[7]/div/a/span")).getText()));
        assertEquals("Uniplan", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen416\"]/li[8]/div/a/span")).getText()));
        assertEquals("Загрузка/Выгрузка данных", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[8]/ul/li/div/a/span")).getText()));
        assertEquals("Отчеты", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[13]/div/a/span")).getText()));
        assertEquals("Эффективность сотрудников", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[1]/div/a/span")).getText()));
        assertEquals("Статистика по проданным КАСКО и ОСАГО в шт.", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[2]/div/a/span")).getText()));
        assertEquals("Статистика по доли СК от общего объема сборов", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[3]/div/a/span")).getText()));
        assertEquals("Статистика по сборам СП", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[4]/div/a/span")).getText()));
        assertEquals("Отчёт по ошибкам", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[5]/div/a/span")).getText()));
        assertEquals("Отчет по кол-ву договоров/собранной премии", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[6]/div/a/span")).getText()));
        assertEquals("Планирование продаж", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[7]/div/a/span")).getText()));
        assertEquals("Планируемые показатели", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[13]/ul/li[7]/ul/li/div/a/span")).getText()));
        assertEquals("Статистика по продуктам", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[8]/div/a/span")).getText()));
        assertEquals("Конверсия расчетов", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[9]/div/a/span")).getText()));
        assertEquals("ДАШБОРД", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[10]/div/a/span")).getText()));
        assertEquals("Пересчитали, но не оформили", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen418\"]/li[11]/div/a/span")).getText()));
        profilePage.userLogout();
        loginPage.inputLogin(ConfProperties.getProperty("sellerlogin"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("sellerpasswd"));
        loginPage.clickLoginBtn();

        assertEquals("Продажа страховых продуктов", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/div/a/span")).getText()));
        assertEquals("Шаблоны", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen340\"]/li/div/a/span")).getText()));
        assertEquals("Сопровождение договоров страхования", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/div/a/span")).getText()));
        assertEquals("Договоры страхования", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/div/a/span")).getText()));
        assertEquals("По номеру", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/ul/li/div/a/span")).getText()));
        assertEquals("Проекты на пролонгацию", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen342\"]/li[2]/div/a/span")).getText()));
        assertEquals("По номеру", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/ul/li/div/a/span")).getText()));
        assertEquals("Бланки строгой отчетности", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[3]/div/a/span")).getText()));
        assertEquals("Выдача/передача БСО", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen344\"]/li[1]/div/a/span")).getText()));
        assertEquals("Передача БСО", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[3]/ul/li[1]/ul/li/div/a/span")).getText()));
        assertEquals("Журнал операций с БСО", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen344\"]/li[2]/div/a/span")).getText()));
        assertEquals("Движение БСО", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[3]/ul/li[2]/ul/li/div/a/span")).getText()));
        assertEquals("Автокредитование", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[4]/div/a/span")).getText()));
        assertEquals("Кредитный калькулятор", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen346\"]/li[1]/div/a/span")).getText()));
        assertEquals("Клиенты", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/div/a/span")).getText()));
        assertEquals("Карточка клиента", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen348\"]/li/div/a/span")).getText()));

        profilePage.userLogout();
        loginPage.inputLogin(ConfProperties.getProperty("prolongationlogin"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("prolongationpasswd"));
        loginPage.clickLoginBtn();
        assertEquals("Продажа страховых продуктов", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/div/a/span")).getText()));
        assertEquals("Шаблоны", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen394\"]/li/div/a/span")).getText()));
        assertEquals("Сопровождение договоров страхования", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[2]/div/a/span")).getText()));
        assertEquals("Договоры страхования", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/div/a/span")).getText()));
        assertEquals("По номеру", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/ul/li/div/a/span")).getText()));
        assertEquals("Проекты на пролонгацию", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen396\"]/li[2]/div/a/span")).getText()));
        assertEquals("По номеру", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/ul/li/div/a/span")).getText()));
        assertEquals("Карточка клиента", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen398\"]/li/div/a/span")).getText()));
        profilePage.userLogout();
        loginPage.inputLogin(ConfProperties.getProperty("backofficelogin"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("backofficepasswd"));
        loginPage.clickLoginBtn();
Thread.sleep(2000);
        assertEquals("Продажа страховых продуктов", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/div/a/span")).getText()));
        assertEquals("Шаблоны", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/ul/li/div/a/span")).getText()));
        assertEquals("Сопровождение договоров страхования", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/div/a/span")).getText()));
        assertEquals("Договоры страхования", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/div/a/span")).getText()));
        assertEquals("По номеру", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/ul/li/div/a/span")).getText()));
        assertEquals("Проекты на пролонгацию", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/div/a/span")).getText()));
        assertEquals("По номеру", textConverter(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/ul/li/div/a/span")).getText()));
        assertEquals("Клиенты", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]/li[3]/div/a/span")).getText()));
        assertEquals("Карточка клиента", textConverter(driver.findElement(By.xpath("//*[@id=\"ext-gen398\"]/li/div/a/span")).getText()));
    }





}
