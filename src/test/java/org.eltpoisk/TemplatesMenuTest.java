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


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemplatesMenuTest {
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
    public void encodingTest() {
        System.out.println("Проверка кодировки");
    }
    @Test
    public void TemplatesMenuTestFilter() throws InterruptedException {

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
        WebElement PageOne = driver.findElement(By.xpath("//div[contains(text(), 'Фамилия154646 И.О.')]"));
        String loginPageOne = PageOne.getText();
        profilePage.Template();
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/table/tbody/tr[1]/td/a/img")).isDisplayed()));
        assertEquals(loginPageOne, (driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span[1]")).getText()));
        assertEquals("0", (driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span[2]/strong")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]")).isDisplayed()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[1]/input[1]")).isDisplayed()));
        profilePage.clickCheckboxAll();
        WebElement checkbox = driver.findElement(By.cssSelector("input[name='to_del[]']"));
        assertEquals(true, checkbox.isSelected());
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"to_del_all\"]")).isDisplayed()));
        profilePage.CheckDelAll();
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"to_del_all\"]")).isSelected()));
        assertEquals("с ", (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[2]/table/tbody/tr/td[1]")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"date_from\"]")).isDisplayed()));
        profilePage.clickDateFieldsForm();
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"calendarDiv\"]")).isDisplayed()));
        assertEquals(" по ", (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[2]/table/tbody/tr/td[3]")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"date_to\"]")).isDisplayed()));
        profilePage.clickDateFieldsTo();
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"calendarDiv\"]")).isDisplayed()));
        profilePage.clickExitCalendare();
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[3]/select")).isDisplayed()));
         profilePage.clickFilterUsername();
/**
        // Находим выпадающий список на странице
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[3]/select"));

        // Создаем объект класса Select для работы с выпадающим списком
        Select select = new Select(dropdown);

        // Получаем все опции выпадающего списка
        List<WebElement> options = select.getOptions();

        // Создаем список для сохранения значений из выпадающего списка
        List<String> originalList = new ArrayList<>();

        // Получаем значения из выпадающего списка и добавляем в список originalList
        for (WebElement option : options) {
            originalList.add(option.getText());
        }

        // Создаем копию originalList
        List<String> sortedList = new ArrayList<>(originalList);

        // Сортируем список sortedList сначала по латинице, затем по кириллице, затем по цифрам (игнорируя регистр)
        Collections.sort(sortedList, (s1, s2) -> {
            String s1Lower = s1.toLowerCase();
            String s2Lower = s2.toLowerCase();
            if (s1Lower.matches("[a-zA-Z].*") && s2Lower.matches("[а-яА-Я].*")) {
                return -1;
            } else if (s1Lower.matches("[а-яА-Я].*") && s2Lower.matches("[a-zA-Z].*")) {
                return 1;
            }
            else if (s1Lower.matches("[а-яА-Я].*") && s2Lower.matches("[а-яА-Я].*")) {
                return s1Lower.compareTo(s2Lower);
            }
            else if (s1Lower.matches("[а-яА-Я].*") && s2Lower.matches("[0-9].*")) {
                return -1;
            }
            else if (s1Lower.matches("[0-9].*") && s2Lower.matches("[0-9].*") ){
                return s1Lower.compareTo(s2Lower);
            }
            else {
                return s1Lower.compareTo(s2Lower);
            }
        });
        // Проверяем, что списки отсортированы верно
        assertEquals(originalList, sortedList);

        // Сравниваем originalList и sortedList поэлементно, игнорируя регистр
        boolean isSorted = true;
        for (int i = 0; i < originalList.size(); i++) {
            if (!originalList.get(i).equalsIgnoreCase(sortedList.get(i))) {
                isSorted = false;
                break;
            }
        }



        WebElement dropdownList = driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[3]/select"));

        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        ArrayList<String> originalList =  new ArrayList<String>();
        for (WebElement option : options) {
            originalList.add(option.getText());
        }
        ArrayList<String> sortedList = new ArrayList<String>(originalList);
        Collections.sort(sortedList);

        boolean isSorted = true;
        for (int i = 0; i < originalList.size(); i++) {
            if (!originalList.get(i).equals(sortedList.get(i))) {
                isSorted = false;
                System.out.println(sortedList);
                break;
            }
        }
        assertTrue(isSorted);
*/
        assertEquals("Марка", (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[1]/th[4]/b")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"mark_filter\"]")).isDisplayed()));
        assertEquals("Модель", (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[1]/th[5]/b")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[5]/select")).isDisplayed()));
        assertEquals("Комментарии", (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[1]/th[6]/b")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[6]/input")).isDisplayed()));
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[6]/input"));
        inputField.sendKeys("T30833 Продажа_страховых_продуктов!?>>Шаблоны");
        String inputValue = inputField.getAttribute("value");
        assertEquals(inputValue,"T30833 Продажа_страховых_продуктов!?>>Шаблоны");
        assertEquals("Страховая", (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[1]/th[7]/b")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[7]/select")).isDisplayed()));

        WebElement dropdownListInsurence = driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[7]/select"));
        List<WebElement> optionsIns = dropdownListInsurence.findElements(By.tagName("option"));
        // Создаем новый список, в который будем сохранять значения из выпадающего списка
        List<String> actualValuesInsurence = new ArrayList<String>();
        // Добавляем значения из выпадающего списка в новый список
        for (WebElement option : optionsIns) {
            actualValuesInsurence.add(option.getText());
        }
        // Создаем копию нового списка и сортируем его
        List<String> sortedValuesInsurence = new ArrayList<String>(actualValuesInsurence);
        Collections.sort(sortedValuesInsurence, String.CASE_INSENSITIVE_ORDER);
        // Проверяем, что отсортированный список совпадает с оригинальным списком
        assertEquals(sortedValuesInsurence, actualValuesInsurence);

        assertEquals("Банк", (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[1]/th[8]/b")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[7]/select")).isDisplayed()));
        WebElement dropdownListBanks = driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[7]/select"));
        List<WebElement> optionsBanks = dropdownListInsurence.findElements(By.tagName("option"));
        // Создаем новый список, в который будем сохранять значения из выпадающего списка
        List<String> actualValuesBanks = new ArrayList<String>();
        // Добавляем значения из выпадающего списка в новый список
        for (WebElement option : optionsBanks) {
            actualValuesBanks.add(option.getText());
        }
        // Создаем копию нового списка и сортируем его
        List<String> sortedValuesBanks = new ArrayList<String>(actualValuesBanks);
        Collections.sort(sortedValuesBanks, String.CASE_INSENSITIVE_ORDER);
        // Проверяем, что отсортированный список совпадает с оригинальным списком
        assertEquals(sortedValuesBanks, actualValuesBanks);

        assertEquals("Действия", (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[1]/th[9]/b")).getText()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[9]/a")).isDisplayed()));

        WebElement timeElement = driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/tbody/tr[2]/td[2]"));
        String timeValue = timeElement.getText().trim();
        assertTrue(timeValue.matches("\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}"));
        assertEquals(true, (driver.findElement(By.cssSelector("img[src=\"images/load.png\"]")).isDisplayed()));
        assertEquals(true, (driver.findElement(By.cssSelector("img[src=\"images/anchor.png\"]")).isDisplayed()));
        assertEquals(true, (driver.findElement(By.cssSelector("img[src=\"images/uritused.gif\"")).isDisplayed()));
        assertEquals(true, (driver.findElement(By.cssSelector("img[src=\"images/cancel.png\"]")).isDisplayed()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"saved_contracts_table\"]/tbody/tr[52]/td/div")).isDisplayed()));
        assertEquals(true, (driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/table/tbody/tr[227]/td/div")).isDisplayed()));
        assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/a")).isDisplayed()));

    }

}
