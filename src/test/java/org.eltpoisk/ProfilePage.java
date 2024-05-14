package org.eltpoisk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
       /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(css = "button.x-btn-text.logout")
    private WebElement logoutBtn;
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logoutBtn.click(); }

    @FindBy(xpath = "//a[contains(span/text(), 'Шаблоны')]")
    private WebElement TemplateBtn;

    public void Template() {
        TemplateBtn.click(); }
    /**
     * определение локатора имени пользователя
     */
    @FindBy(xpath = "//*[@id=\"ext-comp-1016\"]")
    private WebElement userLogin;

    public String getUserName() {
        String userName = userLogin.getText();
        return userName; }

    @FindBy(xpath = "//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[1]/input[1]")
    private WebElement checkboxBtn;

    public void clickCheckboxAll() {
        checkboxBtn.click(); }

    @FindBy(xpath = "//*[@id=\"to_del_all\"]")
    private WebElement CheckDelAll;

    public void CheckDelAll() {
        CheckDelAll.click(); }

    @FindBy(xpath = "//*[@id=\"date_from\"]")
    private WebElement DatefieldFrom;

    public void clickDateFieldsForm() {
        DatefieldFrom.click(); }

    @FindBy(xpath = "//*[@id=\"date_to\"]")
    private WebElement DateFieldsTo;

    public void clickDateFieldsTo() throws InterruptedException {
        DateFieldsTo.click();
        Thread.sleep(100);
        DateFieldsTo.click();
    }
    @FindBy(xpath = "//*[@id=\"saved_contracts_table\"]/thead/tr[2]/th[3]/select")
    private WebElement filterUsername;

    public void clickFilterUsername(){
        filterUsername.click();
    }
    @FindBy(xpath = "//*[@id=\"topBar\"]/img")
    private WebElement closeCalendar;

    public void clickExitCalendare(){

        closeCalendar.click();
    }
    @FindBy (xpath = "/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[1]/ul/li[2]/div/a/span")
    private WebElement fastRegistration;

    public void clickfastRegistration(){

        fastRegistration.click();
    }
    @FindBy (xpath = "//*[@id=\"dagoreg_comment\"]")
    private WebElement CommentFieldFastRegistration;
    public void sendKeysCommentField(){
        CommentFieldFastRegistration.sendKeys("Тестовый комментарий");
    }
    @FindBy (xpath = "//*[@id=\"submitFCR\"]/tbody/tr[2]/td[2]")
    private WebElement SelectButtonFastRegistration;

    public void clickSelectButtonFastRegistr(){
    SelectButtonFastRegistration.click();
    }

    @FindBy (xpath = "/html/body/div[2]/div[2]/div[2]/ul/div/li/ul/li[2]/ul/li[1]/ul/li/div/a")
    private WebElement buttonInsurByNumber;

    public void clickButtonInsurByNumber(){
        buttonInsurByNumber.click();
    }
        @FindBy (xpath = "/html/body/div[3]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/div/div[2]/div[1]/div/div/div")
        private WebElement buttonKasko;

        public void clickButtonKasko(){
            buttonKasko.click();
    }

}
