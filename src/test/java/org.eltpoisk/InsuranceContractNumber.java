package org.eltpoisk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class InsuranceContractNumber {
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
    public void insurContractNumber() throws InterruptedException {

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
        profilePage.clickButtonInsurByNumber();

        assertEquals("Номер договора:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[1]/div/div/div[1]/label")).getText());
        assertTrue(driver.findElement(By.name("policy_number")).isDisplayed());
        assertEquals("ИНН:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[1]/div/div/div[2]/label")).getText());
        assertTrue(driver.findElement(By.name("inn")).isDisplayed());
        assertEquals("Гос. номер:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[1]/div/div/div[3]/label")).getText());
        assertTrue(driver.findElement(By.name("expert_id")).isDisplayed());
        assertEquals("ФИО Специалиста:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[1]/div/div/div[4]/label")).getText());
        assertTrue(driver.findElement(By.name("rg_number")).isDisplayed());
        assertEquals("Сотрудник ОП:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[1]/div/div/div[5]/label")).getText());
        assertTrue(driver.findElement(By.name("prolongator")).isDisplayed());
        assertEquals("Признак платежа:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[1]/div/div/div[6]/label")).getText());
        assertTrue(driver.findElement(By.name("contract_status_akt_pay_type_id")).isDisplayed());
        assertEquals("Внутр. ном. договора:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[2]/div/div/div[1]/label")).getText());
        assertTrue(driver.findElement(By.name("contract_number")).isDisplayed());
        assertEquals("ФИО/ Наим. юр. лица:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[2]/div/div/div[2]/label")).getText());
        assertTrue(driver.findElement(By.name("subject_name")).isDisplayed());
        assertEquals("VIN:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[2]/div/div/div[3]/label")).getText());
        assertTrue(driver.findElement(By.name("vin")).isDisplayed());
        assertEquals("Страховая компания:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[2]/div/div/div[4]/label")).getText());
        assertTrue(driver.findElement(By.name("company_id")).isDisplayed());
        assertEquals("Подразделение", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[2]/div/div/div[5]/label")).getText());
        assertTrue(driver.findElement(By.name("seller_dep_id")).isDisplayed());
        assertEquals("Причина БР:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[2]/div/div/div[8]/label")).getText());
        assertTrue(driver.findElement(By.name("dagoreasons")).isDisplayed());
        assertEquals("Бланк серия:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[3]/div/div/div[1]/label")).getText());
        assertTrue(driver.findElement(By.name("blank_series")).isDisplayed());
        assertEquals("Дата окончания с:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[3]/div/div/div[3]/label")).getText());
        assertTrue(driver.findElement(By.name("finish_from")).isDisplayed());
        assertEquals("Марка:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[3]/div/div/div[4]/label")).getText());
        assertTrue(driver.findElement(By.name("mark")).isDisplayed());
        assertEquals("Срок оформ-я с:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[3]/div/div/div[5]/label")).getText());
        assertTrue(driver.findElement(By.name("from_sign_date")).isDisplayed());
        assertEquals("Продукт:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[3]/div/div/div[7]/label")).getText());
        assertTrue(driver.findElement(By.name("product_id")).isDisplayed());
        assertEquals("Бланк номер:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[4]/div/div/div[1]/label")).getText());
        assertTrue(driver.findElement(By.name("blank_number")).isDisplayed());
        assertEquals("по:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[4]/div/div/div[3]/label")).getText());
        assertTrue(driver.findElement(By.name("finish_to")).isDisplayed());
        assertEquals("Модель:", driver.findElement(By.xpath("//label[@for=\"transportModels\"]")).getText());
        assertTrue(driver.findElement(By.id("transportModels")).isDisplayed());
        assertEquals("по:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[4]/div/div/div[5]/label")).getText());
        assertTrue(driver.findElement(By.name("to_sign_date")).isDisplayed());
        assertEquals("по:", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[4]/div/div/div[7]/label")).getText());
        assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/form/div/div/div/div/div[4]/div/div/div[7]/div[1]/div/input[2]")).isDisplayed());
        assertEquals("Поиск", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button")).getText());
        assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]")).isDisplayed());
        assertEquals("Значения по умолчанию", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).getText());
        assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]")).isDisplayed());
        assertEquals("Очистить", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).getText());
        assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]")).isDisplayed());
        assertEquals("Выгрузка в Excel", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[4]/table/tbody/tr[2]/td[2]/em/button")).getText());
        assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[4]/table/tbody/tr[2]/td[2]/em/button")).isDisplayed());
        assertEquals("Номер договора", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[2]/div")).getText());
        assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[2]/div")).isDisplayed());
        assertEquals("Внутр. номер договора", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[3]/div")).getText());
        assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[4]/div")).isDisplayed());
        assertEquals("Серия и номер бланка полиса", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[4]/div/a")).getText());
        assertEquals("Страховая компания", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[5]/div/a")).getText());
        assertEquals("Подразделение", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[6]/div/a")).getText());
        assertEquals("Страхователь", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[7]/div/a")).getText());
        assertEquals("Продавец", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[8]/div/a")).getText());
        assertEquals("Программа", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[10]/div/a")).getText());
        assertEquals("Пролонгация создано", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[11]/div/a")).getText());
        assertEquals("Марка ТС", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[13]/div/a")).getText());
        assertEquals("Модель ТС", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[14]/div/a")).getText());
        assertEquals("VIN", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[15]/div/a")).getText());
        assertEquals("Рег. номер ТС", driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/table/thead/tr/td[16]/div/a")).getText());

    }
}
