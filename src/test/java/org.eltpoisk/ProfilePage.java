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
    @FindBy(xpath = "//*[@id=\"ext-gen81\"]")
    private WebElement logoutBtn;
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logoutBtn.click(); }

    @FindBy(xpath = "//*[@id=\"ext-gen394\"]/li[1]/div")
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

}
