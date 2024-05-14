package org.eltpoisk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KaskoPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public KaskoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"MAIN_INSURED_PERSON_region_ids\"]")
    private WebElement Region;
    public void RegionInputField(){
        Region.sendKeys("Москва");
    }
    @FindBy(xpath = "/html/body/div[9]/div/div")
    private WebElement Moscow;
    public void RegionMoscow(){
        Moscow.click();
    }

    @FindBy(xpath = "//*[@id=\"INSURED_PERSON_FULL_NAME\"]")
    private WebElement FIO;
    public void FIOInputField(){
        FIO.sendKeys("Береда Александр Николаевич");
    }

    @FindBy(xpath = "//*[@id=\"INSURED_PERSON_BIRTH_DATE\"]")
    private WebElement DOB;
    public void DOBInputField(){
        DOB.sendKeys("13.05.1966");
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_BRAND\"]/option[129]")
    private WebElement Geely;

    public void MarkGeelyChoice(){
        Geely.click();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_MODEL\"]/option[2]")
    private WebElement AtlasPro;

    public void ModelAtlasProChoice(){
        AtlasPro.click();
    }
    @FindBy(xpath = "/html/body/table/tbody/tr[3]/td/form/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr[49]/td[2]/div/div/select/option[2]")
    private WebElement Year;

    public void YearChoice(){
        Year.click();
    }
    @FindBy(xpath = "/html/body/table/tbody/tr[3]/td/form/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr[59]/td[2]/div/input")
    private WebElement EngineDisplacement;

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_NEW\"]/option[3]")
    private WebElement ItsNew;

    public void ItsNewTrue(){
        ItsNew.click();
    }

    public void EngineDisplacementChoice(){
        EngineDisplacement.sendKeys("1477");
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_GEARBOX_TYPE\"]/option[2]")
    private WebElement TypeGearbox;

    public void AutoGearboxChoice(){
        TypeGearbox.click();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_BODY_TYPE\"]/option[9]")
    private WebElement СarBodyType;

    public void CrossoverType(){
        СarBodyType.click();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_DOORS_NUM\"]")
    private WebElement DoorsAmount;

    public void FiveDoors(){
        DoorsAmount.sendKeys("5");
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_POWER\"]")
    private WebElement CarPower;

    public void CarPowerChoice(){
        CarPower.sendKeys("177");
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_MILES\"]")
    private WebElement CarMileage;

    public void CarMileageChoice(){
        CarMileage.sendKeys("10");
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_SPEC_01_SS\"]")
    private WebElement CarPrice;

    public void CarPriceChoice(){
        CarPrice.sendKeys("3071700");
    }
    @FindBy(xpath = "//*[@id=\"CONTRACT_RESTRICTION_AGE1\"]/option[41]")
    private WebElement DriverAge;

    public void DriverAgeChoice(){
       DriverAge.click();
    }
    @FindBy(xpath = "//*[@id=\"CONTRACT_RESTRICTION_EXP1\"]/option[36]")
    private WebElement DrivingExperienceAge;

    public void DrivingExperienceChoice(){
        DrivingExperienceAge.click();
    }
    @FindBy(xpath = "//*[@id=\"CONTRACT_RESTRICTION_SEX1\"]/option[2]")
    private WebElement DrivingSex;

    public void DrivingSexChoice(){
        DrivingSex.click();
    }
    @FindBy(xpath = "//*[@id=\"BTN_NEXTPAGE\"]")
    private WebElement BtnNextPage;

    public void BtnNextPageClick(){
        BtnNextPage.click();
    }
    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div[6]/div/div/div/div[1]/div/div/div[4]/div/div/a[1]/span/span/span[2]")
    public WebElement RgsHullInsurance;

    public void RgsHullInsuranceClick(){
        RgsHullInsurance.click();
    }
    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div[6]/div/div/div/div[2]/div/div/label[2]/div[2]")
    public WebElement RgsInfoBlock;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div[6]/div/div/div/div[1]/div/div/div[4]/div/div/div/div/div/span")
    public WebElement RgsPrice;
    @FindBy(xpath = "//*[@id=\"OWNER_LAST_NAME\"]")
    private WebElement Surname3page;

    public void Surname3page(){
        Surname3page.sendKeys("Береда");
    }
    @FindBy(xpath = "//*[@id=\"OWNER_FIRST_NAME\"]")
    private WebElement Name3page;

    public void Name3page(){
        Name3page.sendKeys("Александр");
    }
    @FindBy(xpath = "//*[@id=\"OWNER_MIDDLE_NAME\"]")
    private WebElement MiddleName3page;

    public void MiddleName3page(){
        MiddleName3page.sendKeys("Николаевич");
    }
    @FindBy(xpath = "//*[@id=\"OWNER_BIRTH_DATE\"]")
    private WebElement DOB3page;

    public void DOB3page(){
        DOB3page.sendKeys("13.05.1966");
    }
    @FindBy(xpath = "//*[@id=\"OWNER_DOC_SERIA\"]")
    private WebElement DocSeria3page;

    public void DocSeria3page(){
        DOB3page.sendKeys("7728");
    }
    @FindBy(xpath = "//*[@id=\"OWNER_DOC_NUMBER\"]")
    private WebElement DocNumber3page;

    public void DocNumber3page(){
        DOB3page.sendKeys("321123");
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_DOC_PTS_DATE\"]")
    private WebElement DatePTS3page;

    public void DatePTS3page(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = today.format(formatter);
        DatePTS3page.sendKeys(formattedDate);
    }

    @FindBy(xpath = "//*[@id=\"BTN_NEXTPAGE\"]")
    private WebElement PageNext3page;

    public void PageNext3page(){
        PageNext3page.click();
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_VIN\"]")
    private WebElement NumberVIN4page;

    public void NumberVIN4page(){
        NumberVIN4page.sendKeys();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_DOC_PTS_SERIA\"]")
    private WebElement SeriaPTS4page;

    public void SeriaPTS4page(){
        SeriaPTS4page.sendKeys();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_DOC_PTS_NUMBER\"]")
    private WebElement NumberPTS4page;

    public void NumberPTS4page(){
        NumberPTS4page.sendKeys();
    }
    @FindBy(xpath = "/html/body/table/tbody/tr[3]/td/form/table/tbody/tr[2]/td/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/table[1]/tbody/tr[2]/td[2]/em/button")
    private WebElement InsurerClientCardButton;

    public void ClickInsurerClientCardButton(){

        InsurerClientCardButton.click();
    }
    @FindBy(xpath = "/html/body/div[15]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/form/div/div[1]/div/div/div[1]/div[1]/input")
    private WebElement SurnameClientCard;

    public void EnterSurnameClientCard(){
       SurnameClientCard.sendKeys("Береда");
    }
    @FindBy(xpath = "/html/body/div[14]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/form/div/div[1]/div/div/div[2]/div[1]/input")
    private WebElement NameClientCard;

    public void EnterNameClientCard(){
        NameClientCard.sendKeys("Александр");
    }
    @FindBy(xpath = "/html/body/div[13]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button")
    private WebElement SearchButtonClientCard;

    public void ClickSearchButtonClientCard(){
        SearchButtonClientCard.click();
    }
    @FindBy(xpath = "/html/body/div[19]/div[2]/div[1]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div/div[8]/table")
    private WebElement PersonKK;

    public void SelectPerson(){
        PersonKK.click();
        PersonKK.click();
           }
    @FindBy(xpath = "/html/body/div[12]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[4]/table/tbody/tr[2]/td[2]/em/button")
    private WebElement SelectKKButton;
    public void ClickSelectButtonKK(){
        SelectKKButton.click();
    }

}
