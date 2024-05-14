package org.eltpoisk;


        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.checkerframework.checker.units.qual.A;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.io.UnsupportedEncodingException;
        import java.lang.reflect.Array;
        import java.nio.charset.Charset;
        import java.nio.file.WatchEvent;
        import java.text.SimpleDateFormat;
        import java.time.Duration;
        import java.util.*;
        import java.util.stream.Collectors;

        import static org.apache.hc.client5.http.utils.DateUtils.formatDate;
        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertNotNull;


public class FastRegistrationTest {
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
    public void FastRegistrationTest() throws InterruptedException {

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
           profilePage.clickfastRegistration();
           assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"FormControlRegistration\"]")).isDisplayed()));
           WebElement radiobuttonError = driver.findElement(By.xpath("//*[@value=\"2\"]"));

           radiobuttonError.click();
           assertEquals(true, radiobuttonError.isSelected());

           WebElement radiobuttonB2b = driver.findElement(By.xpath("//*[@value=\"3\"]"));
           radiobuttonB2b.click();
           assertEquals(true, radiobuttonB2b.isSelected());

           WebElement radiobuttonNoTS = driver.findElement(By.xpath("//*[@value=\"5\"]"));
           radiobuttonNoTS.click();
           assertEquals(true, radiobuttonNoTS.isSelected());


           WebElement radiobuttonAnother = driver.findElement(By.xpath("//*[@value=\"4\"]"));
           radiobuttonAnother.click();

           assertEquals(true, radiobuttonAnother.isSelected());

           profilePage.sendKeysCommentField();
           profilePage.clickSelectButtonFastRegistr();
           assertEquals(true, (driver.findElement(By.xpath("//*[@id=\"ModalReason_4undefined\"]")).isDisplayed()));

           assertEquals(true, (driver.findElement(By.xpath("//button[contains(text(),'Добавить файл')]")).isDisplayed()));
           assertEquals(true, (driver.findElement(By.xpath("//button[contains(text(),'Отменить')]")).isDisplayed()));
           WebElement saveButton = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
           assertEquals(true, saveButton.isDisplayed());
           saveButton.click();
           Thread.sleep(2000);
           assertEquals(("Страховая компания:"), (driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[1]/div/div/div/div/div/form/div[1]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div[1]/label")).getText()));
           assertEquals(true, driver.findElement(By.xpath("//*[@id=\"1CONTRACT_INSURER_NAME\"]")).isDisplayed());
           WebElement arrowTriggerName = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[1]/div/div/div/div/div/form/div[1]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div[1]/div[1]/div/img"));
           arrowTriggerName.click();

           // Найти элемент выпадающего списка

           WebElement dropdownInsurName = driver.findElement(By.xpath("/html/body/div[22]/div"));


           List<WebElement> optionsInsurName = dropdownInsurName.findElements(By.className("div.x-combo-list-item"));


           List<String> sortedOptionsInsurName = optionsInsurName.stream()
                   .map(WebElement::getText)
                   .sorted(Comparator.comparing(String::toLowerCase))
                   .collect(Collectors.toList());


           List<String> expectedOptionsInsurName = new ArrayList<>(sortedOptionsInsurName);
           assertEquals(expectedOptionsInsurName, sortedOptionsInsurName);
           arrowTriggerName.click();
           WebElement arrowTriggerProduct = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[1]/div/div/div/div/div/form/div[1]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div[2]/div[1]/div/img "));
           arrowTriggerProduct.click();

           assertEquals(("Страховой продукт:"), (driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[1]/div/div/div/div/div/form/div[1]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div[2]/label")).getText()));
           assertEquals(true, driver.findElement(By.xpath("//*[@id=\"1INSURED_PRODUCT\"]")).isDisplayed());

           // Найти элемент выпадающего списка

           WebElement dropdownInsurProduct = driver.findElement(By.xpath("/html/body/div[23]/div"));

           List<WebElement> optionsInsurProduct = dropdownInsurProduct.findElements(By.className("x-combo-list-item"));

           List<String> sortedOptionsInsurProduct = optionsInsurProduct.stream()
                   .map(WebElement::getText)
                   .sorted(Comparator.comparing(String::toLowerCase))
                   .collect(Collectors.toList());

           // Сравнение отсортированого списка с фактическим

           List<String> expectedOptionsInsurProduct = new ArrayList<>(sortedOptionsInsurProduct);
           assertEquals(expectedOptionsInsurProduct, sortedOptionsInsurProduct);

           assertEquals("Страховая программа:", driver.findElement(By.xpath("//label[@for=\"1INSURANCE_PROGRAM\"]")).getText());
           String InsurProgramm = driver.findElement(By.xpath("//*[@id=\"1INSURANCE_PROGRAM\"]")).getText();
           assertEquals("", InsurProgramm);

           assertEquals("Риск:", driver.findElement(By.xpath("//label[@for=\"1RISK\"]")).getText());
           assertEquals(true, driver.findElement(By.xpath("//*[@id=\"1RISK\"]")).isDisplayed());
           assertEquals(false, driver.findElement(By.xpath("//*[@id=\"1RISK\"]")).isEnabled());
           assertEquals("Место покупки ТС:", driver.findElement(By.xpath("//label[@for=\"PLACE_BUY_CAR_CMP\"]")).getText());
           WebElement WhereBuyTrigger = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[1]/div/div/div/div/div/form/div[1]/div[2]/div[1]/div/div/div/div/div[2]/div/div/div[1]/div[1]/div/img"));
           WhereBuyTrigger.click();

           List<String> strListExpectedPlace = new ArrayList();
           strListExpectedPlace.add("Рольф");
           strListExpectedPlace.add("Не Рольф");
           strListExpectedPlace.add("BlueFish");

           WebElement WhereBuyPoint = driver.findElement(By.xpath("/html/body/div[22]/div"));
           for(String str : strListExpectedPlace)
           {
               WebElement WhereBuyPointText = WhereBuyPoint.findElement(By.xpath("//div[contains(text(), '" + str + "')]"));
               assertNotNull(WhereBuyPointText);
           }
           WhereBuyTrigger.click();
           assertEquals("Валюта:", driver.findElement(By.xpath("//label[@for=\"1CONTRACT_CURRENCY\"]")).getText());
           WebElement Сurrency = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[1]/div/div/div/div/div/form/div[1]/div[2]/div[1]/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/img"));
           Сurrency.click();
           List<String> strListCurrency = new ArrayList();
           strListCurrency.add("Евро");
           strListCurrency.add("Рубль");
           strListCurrency.add("Американский доллар");

           WebElement CurrencyPoint = driver.findElement(By.xpath("/html/body/div[22]/div"));
           for(String str : strListCurrency)
           {
               WebElement CurrencyPointText = CurrencyPoint.findElement(By.xpath("//div[contains(text(), '" + str + "')]"));
               assertNotNull(CurrencyPointText);
           }
           Сurrency.click();
           assertEquals("Пролонгация:", driver.findElement(By.xpath("//label[@for=\"1PROLONG\"]")).getText());
           assertEquals(false, driver.findElement(By.xpath("//*[@id=\"1PROLONG\"]")).isSelected());

           assertEquals("Продавец:", driver.findElement(By.xpath("//label[@for=\"1SELLER_DAGO_BY_DEP\"]")).getText());
           /*
           WebElement SellerPointTrigger = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[1]/div/div/div/div/div/form/div[2]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div[1]/div[1]/div/img"));
           SellerPointTrigger.click();
           WebElement Seller = driver.findElement(By.xpath("/html/body/div[24]/div"));

           List<WebElement> SellerPoint = Seller.findElements(By.className("x-combo-list-item"));

           List<String> ListSellerPoint = SellerPoint.stream()
                   .map(WebElement::getText)
                   .sorted(Comparator.comparing(String::toLowerCase))
                   .collect(Collectors.toList());
           System.out.println(ListSellerPoint);
           assertNotNull(ListSellerPoint);

            */
           assertEquals("Подразделение:", driver.findElement(By.xpath("//label[@for=\"1DEPARTMENTS_BY_SELLER\"]")).getText());
           assertEquals("Специалист ОП:", driver.findElement(By.xpath("//label[@for=\"1SPECIALIST_OP\"]")).getText());
           assertEquals("ЭБСО:", driver.findElement(By.xpath("//label[@for=\"1EBSO_SELECTOR\"]")).getText());
           assertEquals(false, driver.findElement(By.id("1EBSO_SELECTOR")).isSelected());
           assertEquals("Бумажный бланк:", driver.findElement(By.xpath("//label[@for=\"1CONTRACT_BLANK_1\"]")).getText());
           assertEquals(true, driver.findElement(By.xpath("//input[@id=\"1CONTRACT_BLANK_1\"]")).isDisplayed());
           assertEquals("Квитанция A7:", driver.findElement(By.xpath("//label[@for=\"1CONTRACT_BLANK_A7\"]")).getText());
           assertEquals(true, driver.findElement(By.xpath("//input[@id=\"1CONTRACT_BLANK_A7\"]")).isDisplayed());
           assertEquals("Виртуальный бланк:", driver.findElement(By.xpath("//label[@for=\"1CONTRACT_BLANK_VIRTUAL_BLANK\"]")).getText());
           assertEquals(true, driver.findElement(By.xpath("//input[@id=\"1CONTRACT_BLANK_VIRTUAL_BLANK\"]")).isDisplayed());
           assertEquals("Номер договора:", driver.findElement(By.xpath("//label[@for=\"1ORIGINAL_NUMBER\"]")).getText());
           assertEquals(true, driver.findElement(By.xpath("//input[@id=\"1ORIGINAL_NUMBER\"]")).isDisplayed());
           assertEquals("Банк:", driver.findElement(By.xpath("//label[@for=\"1CONTRACT_CREDITOR_BANK\"]")).getText());
           assertEquals(true, driver.findElement(By.xpath("//input[@id=\"1CONTRACT_CREDITOR_BANK\"]")).isDisplayed());
           assertEquals("Страховая сумма:", driver.findElement(By.xpath("//label[@for=\"1CONTRACT_SUM\"]")).getText());
           assertEquals(true, driver.findElement(By.xpath("//input[@id=\"1CONTRACT_SUM\"]")).isDisplayed());
           assertEquals("Страховая премия:", driver.findElement(By.xpath("//label[@for=\"1CONTRACT_PREMIUM\"]")).getText());
           assertEquals(true, driver.findElement(By.xpath("//input[@id=\"1CONTRACT_PREMIUM\"]")).isDisplayed());
           assertEquals("Скидка с КВ, %:", driver.findElement(By.xpath("//label[@for=\"1DISCOUNT_KV\"]")).getText());
           assertEquals(false, driver.findElement(By.xpath("//input[@id=\"1DISCOUNT_KV\"]")).isEnabled());
           assertEquals("Франшиза, руб:", driver.findElement(By.xpath("//label[@for=\"1FRANSHIZE\"]")).getText());
           assertEquals(true, driver.findElement(By.xpath("//input[@id=\"1FRANSHIZE\"]")).isDisplayed());
           assertEquals("Дата оформления:",driver.findElement(By.xpath("//label[@for=\"1CONTRACT_SIGN_DATE\"]")).getText());
           Date dateOfIssue = new Date();
           //dateOfIssue.toString();
           SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
           String formatedDateofIssue = formatDate(dateOfIssue);
           assertEquals(formatedDateofIssue, driver.findElement(By.xpath("//input[@id=\"1CONTRACT_SIGN_DATE\"]")).getText());
           assertEquals("Начало действия:",driver.findElement(By.xpath("//label[@for=\"1CONTRACT_BEGIN_DATE\"]")).getText());
           assertEquals("Конец действия:", driver.findElement(By.xpath("//label[@for=\"1CONTRACT_END_DATE\"]")).getText());
        boolean isContractEndDatePresent = driver.findElements(By.id("1CONTRACT_END_DATE")).isEmpty();
        assertEquals(true, isContractEndDatePresent );

        for (int i = 1; i <= 10; i++) {
            String labelXpath = "//label[@for='1PAYMENT_SUM_" + i + "']";
            WebElement label = driver.findElement(By.xpath(labelXpath));
            System.out.println("Заголовок " + i + ": " + label.getText());
        }

        // Проверяем наличие полей
        for (int i = 1; i <= 10; i++) {
             String inputId = "1PAYMENT_SUM_" + i;
            WebElement input = driver.findElement(By.id(inputId));
            System.out.println("Поле " + i + ": " + input.getAttribute("name"));
        }
        assertEquals("Марка:", driver.findElement(By.xpath("//label[@for=\"1INSURANCE_OBJECT_BRAND\"]")).getText());
        assertEquals(true, driver.findElement(By.id("1INSURANCE_OBJECT_BRAND")).isDisplayed());
        assertEquals("Модель:", driver.findElement(By.xpath("//label[@for=\"1INSURANCE_OBJECT_MODEL\"]")).getText());
        assertEquals(true, driver.findElement(By.id("1INSURANCE_OBJECT_MODEL")).isDisplayed());
        assertEquals("Модификация:", driver.findElement(By.xpath("//label[@for=\"1INSURANCE_OBJECT_MODIFICATION\"]")).getText());
        assertEquals(true, driver.findElement(By.id("1INSURANCE_OBJECT_MODIFICATION")).isDisplayed());
        assertEquals("Год выпуска:", driver.findElement(By.xpath("//label[@for=\"1INSURANCE_OBJECT_USE_AGE\"]")).getText());
        assertEquals(true, driver.findElement(By.id("1INSURANCE_OBJECT_USE_AGE")).isDisplayed());
        assertEquals("Идентификатор ТС:", driver.findElement(By.xpath("//label[@for=\"1INSURANCE_OBJECT_IDENTIFIER\"]")).getText());
        assertEquals(true, driver.findElement(By.id("1INSURANCE_OBJECT_IDENTIFIER")).isDisplayed());
        assertEquals("VIN:", driver.findElement(By.xpath("//label[@for=\"1INSURANCE_OBJECT_VIN\"]")).getText());
        assertEquals(true, driver.findElement(By.id("1INSURANCE_OBJECT_VIN")).isDisplayed());
        assertEquals("Мощность, л.с.:", driver.findElement(By.xpath("//label[@for=\"1INSURANCE_OBJECT_POWER\"]")).getText());
        assertEquals(true, driver.findElement(By.id("1INSURANCE_OBJECT_POWER")).isDisplayed());
        assertEquals("Новое ТС:", driver.findElement(By.xpath("//label[@for=\"1INSURANCE_OBJECT_NEW\"]")).getText());
        assertEquals(true, driver.findElement(By.id("1INSURANCE_OBJECT_NEW")).isDisplayed());


       }
}