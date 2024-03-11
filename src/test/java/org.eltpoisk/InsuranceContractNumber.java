package org.eltpoisk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;

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

        assertEquals("Номер договора:", driver.findElement(By.xpath("//label[@for=\"d9RrprUhTT073OTcT4QU_policy_number\"]")).getText());
        assertEquals(true, driver.findElement(By.id("d9RrprUhTT073OTcT4QU_policy_number")).isDisplayed());
        assertEquals("ИНН:", driver.findElement(By.xpath("//label[@for=\"d9RrprUhTT073OTcT4QU_inn\"]")).getText());
        assertEquals(true, driver.findElement(By.id("d9RrprUhTT073OTcT4QU_inn")).isDisplayed());
        assertEquals("Гос. номер:", driver.findElement(By.xpath("//label[@for=\"d9RrprUhTT073OTcT4QU_rg_number\"]")).getText());
        assertEquals(true, driver.findElement(By.id("d9RrprUhTT073OTcT4QU_rg_number")).isDisplayed());
        assertEquals("ФИО Специалиста:", driver.findElement(By.xpath("//label[@for=\"d9RrprUhTT073OTcT4QU_rg_number\"]")).getText());
        assertEquals(true, driver.findElement(By.id("d9RrprUhTT073OTcT4QU_rg_number")).isDisplayed());
        assertEquals("Сотрудник ОП:", driver.findElement(By.xpath("//label[@for=\"d9RrprUhTT073OTcT4QU_prolongator\"]")).getText());
        assertEquals(true, driver.findElement(By.id("d9RrprUhTT073OTcT4QU_prolongator")).isDisplayed());
        assertEquals("Признак платежа:", driver.findElement(By.xpath("//label[@for=\"d9RrprUhTT073OTcT4QU_contract_status_akt_pay_type_id\"]")).getText());
        assertEquals(true, driver.findElement(By.id("d9RrprUhTT073OTcT4QU_contract_status_akt_pay_type_id")).isDisplayed());
        assertEquals("Внутр. ном. договора:", driver.findElement(By.xpath("//label[@for=\"kNmW5nxDIZKUbR0h3mT3_contract_number\"]")).getText());
        assertEquals(true, driver.findElement(By.id("kNmW5nxDIZKUbR0h3mT3_contract_number")).isDisplayed());
        assertEquals("ФИО/ Наим. юр. лица:", driver.findElement(By.xpath("//label[@for=\"kNmW5nxDIZKUbR0h3mT3_subject_name\"]")).getText());
        assertEquals(true, driver.findElement(By.id("kNmW5nxDIZKUbR0h3mT3_subject_name")).isDisplayed());
        assertEquals("VIN:", driver.findElement(By.xpath("//label[@for=\"kNmW5nxDIZKUbR0h3mT3_vin\"]")).getText());
        assertEquals(true, driver.findElement(By.id("kNmW5nxDIZKUbR0h3mT3_vin")).isDisplayed());
        assertEquals("Страховая компания:", driver.findElement(By.xpath("//label[@for=\"kNmW5nxDIZKUbR0h3mT3_company_id\"]")).getText());
        assertEquals(true, driver.findElement(By.id("kNmW5nxDIZKUbR0h3mT3_company_id")));
        assertEquals("Подразделение", driver.findElement(By.xpath("//label[@for=\"kNmW5nxDIZKUbR0h3mT3_seller_dep_id\"]")).getText());
        assertEquals(true, driver.findElement(By.id("kNmW5nxDIZKUbR0h3mT3_seller_dep_id")).isDisplayed());
        assertEquals("Причина БР:", driver.findElement(By.xpath("//label[@for=\"kNmW5nxDIZKUbR0h3mT3__dagoreasons\"]")).getText());
        assertEquals(true, driver.findElement(By.id("kNmW5nxDIZKUbR0h3mT3__dagoreasons")).isDisplayed());
        assertEquals("Бланк серия:", driver.findElement(By.xpath("//label[@for=\"kNmW5nxDIZKUbR0h3mT3_blank_series\"]")).getText());
        assertEquals(true, driver.findElement(By.id("kNmW5nxDIZKUbR0h3mT3_blank_series")).isDisplayed());
        
    }
}
