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

        assertEquals("Продажа страховых продуктов", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/div/a/span")).getText());
        assertEquals("Шаблоны", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/ul/li[1]/div/a/span")).getText());
        assertEquals("Быстрая регистрация", driver.findElement(By.xpath("//a[contains(span/text(), 'Быстрая регистрация')]")).getText());
        assertEquals("Сопровождение договоров страхования", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/div/a/span")).getText());
        assertEquals("Договоры страхования", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/div/a/span")).getText());
        assertEquals("По номеру", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/ul/li/div/a/span")).getText());
        assertEquals("Проекты на пролонгацию", (driver.findElement(By.xpath("//a[contains(span/text(), 'Проекты на пролонгацию')]")).getText()));
        assertEquals("По номеру", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/ul/li/div/a/span")).getText());
        assertEquals("Платежи", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[3]/div/a/span")).getText());
        assertEquals("Платежи", driver.findElement(By.xpath("//a[contains(span/text(), 'Платежи')]")).getText());
        assertEquals("Ошибки", driver.findElement(By.xpath("//*[@id=\"ext-gen104\"]/li[4]/div/a/span")).getText());
        assertEquals("Журнал ошибок", driver.findElement(By.xpath("//a[contains(span/text(), 'Журнал ошибок')]")).getText());
        assertEquals("Бланки строгой отчетности", driver.findElement(By.xpath("//*[@id=\"ext-gen104\"]/li[5]/div/a/span")).getText());
        assertEquals("Выдача/передача БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[1]/div/a/span")).getText());
        assertEquals("Передача БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[1]/ul/li[1]/div/a/span")).getText());
        assertEquals("Прием БСО от СК", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[1]/ul/li[2]/div/a/span")).getText());
        assertEquals("Прием БСО от СК", driver.findElement(By.xpath("//a[contains(span/text(), 'Прием БСО от СК')]")).getText());
        assertEquals("Журнал номенклатуры БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[2]/div/a/span")).getText());
        assertEquals("Журнал номенклатуры БСО", driver.findElement(By.xpath("//a[contains(span/text(), 'Журнал номенклатуры БСО')]")).getText());
        assertEquals("Видимость номенклатуры", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[2]/ul/li[2]/div/a/span")).getText());
        assertEquals("Журнал операций с БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[3]/div/a/span")).getText());
        assertEquals("Движение БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[3]/ul/li/div/a/span")).getText());
        assertEquals("Утилиты", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[4]/div/a/span")).getText());
        assertEquals("Генерация БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[4]/ul/li/div/a/span")).getText());
        assertEquals("Журнал номенклатуры БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[2]/div/a/span")).getText());
        assertEquals("Журнал номенклатуры БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[2]/ul/li[1]/div/a/span")).getText());
        assertEquals("Видимость номенклатуры", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[2]/ul/li[2]/div/a/span")).getText());
        assertEquals("Журнал операций с БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[3]/div/a/span")).getText());
        assertEquals("Движение БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[3]/ul/li/div/a/span")).getText());
        assertEquals("Утилиты", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[4]/div/a/span")).getText());
        assertEquals("Генерация БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/ul/li[4]/ul/li/div/a/span")).getText());
        assertEquals("Комиссионное вознаграждение", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[9]/ul/li[5]/div/a/span")).getText());
        assertEquals("Журнал агентских договоров", driver.findElement(By.xpath("//a[contains(span/text(), 'Журнал агентских договоров')]")).getText());
        assertEquals("Журнал программ КВ", driver.findElement(By.xpath("//a[contains(span/text(), 'Журнал программ КВ')]")).getText());
        assertEquals("Реестр начисленного КВ", driver.findElement(By.xpath("//a[contains(span/text(), 'Реестр начисленного КВ')]")).getText());
        assertEquals("Акты", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[7]/div/a/span")).getText());
        assertEquals("Журнал актов", driver.findElement(By.xpath("//a[contains(span/text(), 'Журнал актов')]")).getText());
        assertEquals("Скидки", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[8]/div/a/span")).getText());
        assertEquals("Управление скидками", driver.findElement(By.xpath("//a[contains(span/text(), 'Управление скидками')]")).getText());
        assertEquals("Автокредитование", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[9]/div/a/span")).getText());
        assertEquals("Приоритеты по банкам", driver.findElement(By.xpath("//a[contains(span/text(), 'Приоритеты по банкам')]")).getText());
        assertEquals("Кредитный калькулятор", driver.findElement(By.xpath("//a[contains(span/text(), 'Кредитный калькулятор')]")).getText());
        assertEquals("Кредитные заявки", driver.findElement(By.xpath("//a[contains(span/text(), 'Кредитные заявки')]")).getText());
        assertEquals("Сверка с банком", driver.findElement(By.xpath("//a[contains(span/text(), 'Сверка с банком')]")).getText());
        assertEquals("Комиссионное вознаграждение", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[9]/ul/li[5]/div/a/span")).getText());
        assertEquals("Программы КВ", driver.findElement(By.xpath("//a[contains(span/text(), 'Программы КВ')]")).getText());
        assertEquals("Начисленное КВ", driver.findElement(By.xpath("//a[contains(span/text(), 'Начисленное КВ')]")).getText());
        assertEquals("Кумулятивная маржа", driver.findElement(By.xpath("//a[contains(span/text(), 'Кумулятивная маржа')]")).getText());
        assertEquals("Администрирование", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[9]/ul/li[6]/div/a/span")).getText());
        assertEquals("Управление банками", driver.findElement(By.xpath("//a[contains(span/text(), 'Управление банками')]")).getText());
        assertEquals("Настройка кредитных программ", driver.findElement(By.xpath("//a[contains(span/text(), 'Настройка кредитных программ')]")).getText());
        assertEquals("Настройка формул банка", driver.findElement(By.xpath("//a[contains(span/text(), 'Настройка формул банка')]")).getText());
        assertEquals("Загрузка/обновление кредитных программ", driver.findElement(By.xpath("//a[contains(span/text(), 'Загрузка/обновление кредитных программ')]")).getText());
        assertEquals("Клиенты", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[10]/div/a/span")).getText());
        assertEquals("Карточка клиента", driver.findElement(By.xpath("//a[contains(span/text(), 'Карточка клиента')]")).getText());
        assertEquals("Дополнительные инструменты", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[11]/div/a/span")).getText());
        assertEquals("Аналитика тарифов", driver.findElement(By.xpath("//a[contains(span/text(), 'Аналитика тарифов')]")).getText());
        assertEquals("Администрирование", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/div/a/span")).getText());
        assertEquals("Подразделения", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[1]/div/a/span")).getText());
        assertEquals("Управление подразделениями", driver.findElement(By.xpath("//a[contains(span/text(), 'Управление подразделениями')]")).getText());
        assertEquals("Пользователи", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[2]/div/a/span")).getText());
        assertEquals("Управление пользователями", driver.findElement(By.xpath("//a[contains(span/text(), 'Управление пользователями')]")).getText());
        assertEquals("Страховые компании", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[3]/div/a/span")).getText());
        assertEquals("Описание условий страхования", driver.findElement(By.xpath("//a[contains(span/text(), 'Описание условий страхования')]")).getText());
        assertEquals("Управление страховыми компаниями", driver.findElement(By.xpath("//a[contains(span/text(), 'Управление страховыми компаниями')]")).getText());
        assertEquals("Управление страховыми продуктами", driver.findElement(By.xpath("//a[contains(span/text(), 'Управление страховыми продуктами')]")).getText());
        assertEquals("Управление инф. сообщениями", driver.findElement(By.xpath("//a[contains(span/text(), 'Управление инф. сообщениями')]")).getText());
        assertEquals("Управление универсальным продуктом", driver.findElement(By.xpath("//a[contains(span/text(), 'Управление универсальным продуктом')]")).getText());
        assertEquals("Загрузка/выгрузка платежей", driver.findElement(By.xpath("//a[contains(span/text(), 'Загрузка/выгрузка платежей')]")).getText());
        assertEquals("Рекомендации по оформлению", driver.findElement(By.xpath("//a[contains(span/text(), 'Рекомендации по оформлению')]")).getText());
        assertEquals("Дополнительные настройки", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[6]/div/a/span")).getText());
        assertEquals("Добавление дополнительных полей", driver.findElement(By.xpath("//a[contains(span/text(), 'Добавление дополнительных полей')]")).getText());
        assertEquals("О системе", driver.findElement(By.xpath("//a[contains(span/text(), 'О системе')]")).getText());
        assertEquals("Uniplan", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[12]/ul/li[8]/div/a/span")).getText());
        assertEquals("Загрузка/Выгрузка данных", driver.findElement(By.xpath("//a[contains(span/text(), 'Загрузка/Выгрузка данных')]")).getText());
        assertEquals("Отчеты", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[13]/div/a/span")).getText());
        assertEquals("Эффективность сотрудников", driver.findElement(By.xpath("//a[contains(span/text(), 'Эффективность сотрудников')]")).getText());
        assertEquals("Статистика по проданным КАСКО и ОСАГО в шт.", driver.findElement(By.xpath("//a[contains(span/text(), 'Статистика по проданным КАСКО и ОСАГО в шт.')]")).getText());
        assertEquals("Статистика по доли СК от общего объема сборов", driver.findElement(By.xpath("//a[contains(span/text(), 'Статистика по доли СК от общего объема сборов')]")).getText());
        assertEquals("Статистика по сборам СП", driver.findElement(By.xpath("//a[contains(span/text(), 'Статистика по сборам СП')]")).getText());
        assertEquals("Отчёт по ошибкам", driver.findElement(By.xpath("//a[contains(span/text(), 'Отчёт по ошибкам')]")).getText());
        assertEquals("Отчет по кол-ву договоров/собранной премии", driver.findElement(By.xpath("//a[contains(span/text(), 'Отчет по кол-ву договоров/собранной премии')]")).getText());
        assertEquals("Планирование продаж", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[13]/ul/li[7]/div/a/span")).getText());
        assertEquals("Планируемые показатели", driver.findElement(By.xpath("//a[contains(span/text(), 'Планируемые показатели')]")).getText());
        assertEquals("Статистика по продуктам", driver.findElement(By.xpath("//a[contains(span/text(), 'Статистика по продуктам')]")).getText());
        assertEquals("Конверсия расчетов", driver.findElement(By.xpath("//a[contains(span/text(), 'Конверсия расчетов')]")).getText());
        assertEquals("ДАШБОРД", driver.findElement(By.xpath("//a[contains(span/text(), 'ДАШБОРД')]")).getText());
        assertEquals("Пересчитали, но не оформили", driver.findElement(By.xpath("//a[contains(span/text(), 'Пересчитали, но не оформили')]")).getText());
        profilePage.userLogout();
        loginPage.inputLogin(ConfProperties.getProperty("sellerlogin"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("sellerpasswd"));
        loginPage.clickLoginBtn();

        assertEquals("Продажа страховых продуктов", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/div/a/span")).getText());
        assertEquals("Шаблоны", driver.findElement(By.xpath("//a[contains(span/text(), 'Шаблоны')]")).getText());
        assertEquals("Сопровождение договоров страхования", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/div/a/span")).getText());
        assertEquals("Договоры страхования", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/div/a/span")).getText());
        assertEquals("По номеру", driver.findElement(By.xpath("//a[contains(span/text(), 'По номеру')]")).getText());
        assertEquals("Проекты на пролонгацию", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/div/a/span")).getText());
        assertEquals("По номеру", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/ul/li/div/a/span")).getText());
        assertEquals("Бланки строгой отчетности", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[3]/div/a/span")).getText());
        assertEquals("Выдача/передача БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[3]/ul/li[1]/div/a/span")).getText());
        assertEquals("Передача БСО", driver.findElement(By.xpath("//a[contains(span/text(), 'Передача БСО')]")).getText());
        assertEquals("Журнал операций с БСО", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[3]/ul/li[2]/div/a/span")).getText());
        assertEquals("Движение БСО", driver.findElement(By.xpath("//a[contains(span/text(), 'Движение БСО')]")).getText());
        assertEquals("Автокредитование", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[4]/div/a/span")).getText());
        assertEquals("Кредитный калькулятор", driver.findElement(By.xpath("//a[contains(span/text(), 'Кредитный калькулятор')]")).getText());
        assertEquals("Кредитные заявки", driver.findElement(By.xpath("//a[contains(span/text(), 'Кредитные заявки')]")).getText());
        assertEquals("Клиенты", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[5]/div/a/span")).getText());
        assertEquals("Карточка клиента", driver.findElement(By.xpath("//a[contains(span/text(), 'Карточка клиента')]")).getText());

        profilePage.userLogout();
        loginPage.inputLogin(ConfProperties.getProperty("prolongationlogin"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("prolongationpasswd"));
        loginPage.clickLoginBtn();
        assertEquals("Продажа страховых продуктов", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/div/a/span")).getText());
        assertEquals("Шаблоны", driver.findElement(By.xpath("//a[contains(span/text(), 'Шаблоны')]")).getText());
        assertEquals("Сопровождение договоров страхования", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/div/a/span")).getText());
        assertEquals("Договоры страхования", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/div/a/span")).getText());
        assertEquals("По номеру", driver.findElement(By.xpath("//a[contains(span/text(), 'По номеру')]")).getText());
        assertEquals("Проекты на пролонгацию", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/div/a/span")).getText());
        assertEquals("По номеру", driver.findElement(By.xpath("//a[contains(span/text(), 'По номеру')]")).getText());
        assertEquals("Карточка клиента", driver.findElement(By.xpath("//a[contains(span/text(), 'Карточка клиента')]")).getText());
        profilePage.userLogout();
        loginPage.inputLogin(ConfProperties.getProperty("backofficelogin"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("backofficepasswd"));
        loginPage.clickLoginBtn();
Thread.sleep(2000);
        assertEquals("Продажа страховых продуктов", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/div/a/span")).getText());
        assertEquals("Шаблоны", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/ul/li/div/a/span")).getText());
        assertEquals("Сопровождение договоров страхования", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/div/a/span")).getText());
        assertEquals("Договоры страхования", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/div/a/span")).getText());
        assertEquals("По номеру", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/ul/li/div/a/span")).getText());
        assertEquals("Проекты на пролонгацию", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/div/a/span")).getText());
        assertEquals("По номеру", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[2]/ul/li/div/a/span")).getText());
        assertEquals("Клиенты", driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[4]/div/a/span")).getText());
        assertEquals("Карточка клиента", driver.findElement(By.xpath("//a[contains(span/text(), 'Карточка клиента')]")).getText());
        profilePage.userLogout();

    }





}
