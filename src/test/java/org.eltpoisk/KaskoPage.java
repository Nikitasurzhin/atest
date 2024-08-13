package org.eltpoisk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(id = "changeUserDepartmentCombo")
    private WebElement DepartmentRGS;
    public void DepartmentRGS(){
        DepartmentRGS.sendKeys("Тест");
    }
    @FindBy(id = "changeUserDepartmentCombo")
    private WebElement DepartmentRESO;
    public void DepartmentRESO(){
        DepartmentRESO.sendKeys("Тест Ресо");
    }

    @FindBy(id = "changeUserDepartmentCombo")
    private WebElement DepartmentRenins;
    public void DepartmentRenins(){
        DepartmentRESO.sendKeys("Тест Реник");
    }
    @FindBy(id = "changeUserDepartmentCombo")
    private WebElement DepartmentSovcom;
    public void DepartmentSovcom(){
        DepartmentRESO.sendKeys("Тест Совком");
    }
    @FindBy(id = "changeUserDepartmentCombo")
    private WebElement DepartmentEnergo;
    public void DepartmentEnergo(){
        DepartmentRESO.sendKeys("Энергогарант тест");
    }



    @FindBy(xpath = "/html/body/div[15]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button")
    private WebElement SubmitDepartment;
    public void SubmitDepartment(){
        SubmitDepartment.click();
    }
    @FindBy(xpath = "/html/body/div[13]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]")
    private WebElement SubmitDepartmentTwo;
    public void SubmitDepartmentTwo(){
        SubmitDepartmentTwo.click();
    }
    @FindBy(xpath = "//label[@for=\"changeUserDepartmentCombo\"]")
    private WebElement changeUserDepartmentCombo;
    public void changeUserDepartmentCombo(){
        changeUserDepartmentCombo.click();
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

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_BRAND\"]/option[132]")
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
    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div[4]/div/div/a[1]/span/span/span[2]")
    public WebElement RgsHullInsurance;
    public void HullInsuranceClick(){
        RgsHullInsurance.click();
    }

    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/label[3]/div[2]")
    public WebElement InfoBlock;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div[4]/div/div/div/div/div/span")
    public WebElement Price;

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

    @FindBy(xpath = "/html/body/table/tbody/tr[3]/td/form/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[51]/td[2]/div/input")
    private WebElement DocSeria3page;
    public void DocSeria3page(){
        DocSeria3page.sendKeys("7728");
    }

    @FindBy(xpath = "/html/body/table/tbody/tr[3]/td/form/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[53]/td[2]/div/input")
    private WebElement DocNumber3page;
    public void DocNumber3page(){
        DocNumber3page.sendKeys("321123");
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_DOC_PTS_DATE\"]")
    private WebElement DatePTS3page;

    public void DatePTS3page(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = today.format(formatter);
        DatePTS3page.sendKeys(formattedDate);
    }

    @FindBy(id = "BTN_NEXTPAGE")
    private WebElement PageNext3page;

    public void PageNext3page(){
        PageNext3page.click();
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_VIN\"]")
    private WebElement NumberVIN4page;

    public void NumberVIN4page(){
        NumberVIN4page.sendKeys("ZD1MN370811519766");
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_DOC_PTS_SERIA\"]")
    private WebElement SeriaPTS4page;

    public void SeriaPTS4page(){
        SeriaPTS4page.sendKeys("13РТ");
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_DOC_PTS_NUMBER\"]")
    private WebElement NumberPTS4page;

    public void NumberPTS4page(){
        NumberPTS4page.sendKeys("140281");
    }
    @FindBy(xpath = "/html/body/table/tbody/tr[3]/td/form/table/tbody/tr[2]/td/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/table[1]/tbody/tr[2]/td[2]/em/button")
    private WebElement InsurerClientCardButton;

    public void ClickInsurerClientCardButton(){

        InsurerClientCardButton.click();
    }
    @FindBy(id = "last_name")
    private WebElement SurnameClientCard;

    public void EnterSurnameClientCard(){
       SurnameClientCard.sendKeys("Лучков");
    }
    @FindBy(id = "first_name")
    private WebElement NameClientCard;

    public void EnterNameClientCard(){
        NameClientCard.sendKeys("Михаил");
    }

    @FindBy(xpath = "//button[contains(text(),'Поиск')]")
    private WebElement SearchButtonClientCard;

    public void ClickSearchButtonClientCard(){
        SearchButtonClientCard.click();
    }

    @FindBy(xpath = "/html/body/div[24]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]")
    private WebElement SelectButton;
    @FindBy(xpath = "//div[contains(text(),'Лучков')]")
    public WebElement PersonKK;
    public void SelectPerson(){
        PersonKK.click();
    }


    @FindBy(xpath = "//button[contains(text(),'Выбрать клиента')]")

    private WebElement SelectKKButton;
    public void ClickSelectButtonKK(){
        SelectKKButton.click();
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_KEYS\"]")
    private WebElement KeyCount;

    public void KeyCount(){
        KeyCount.sendKeys("2");
    }

    @FindBy(xpath = "//*[@id=\"form\"]/table/tbody/tr[6]/td/table/tbody/tr[1]/td/font/a/b")
    private WebElement FaceClick;

    public void FaceClick(){
        FaceClick.click();
    }

    @FindBy(id = "USER_1_FULL_NAME")
    private WebElement USER_1_FULL_NAME;

    public void USER_1_FULL_NAME(){
        USER_1_FULL_NAME.sendKeys("Береда Александр Николаевич");
    }
    @FindBy(id= "USER_1_EXP_DATE")
    private WebElement USER_1_EXP_DATE;

    public void USER_1_EXP_DATE(){
        USER_1_EXP_DATE.sendKeys("31.12.1989");
    }

    @FindBy(id = "USER_1_BIRTH_DATE")
    private WebElement USER_1_BIRTH_DATE;

    public void USER_1_BIRTH_DATE(){
        USER_1_BIRTH_DATE.sendKeys("13.05.1967");
    }
    @FindBy(id = "USER_1_DOC_SERIA")
    private WebElement USER_1_DOC_SERIA;

    public void USER_1_DOC_SERIA(){
        USER_1_DOC_SERIA.sendKeys("7728");
    }
    @FindBy(id = "USER_1_DOC_NUMBER")
    private WebElement USER_1_DOC_NUMBER;

    public void USER_1_DOC_NUMBER(){
        USER_1_DOC_NUMBER.sendKeys("321123");
    }


    @FindBy(xpath = "//*[@id=\"BTN_NEXTPAGE\"]")
    private WebElement ButtonNext4page;

    public void ClickButtonNext4page(){
        ButtonNext4page.click();
    }
    @FindBy(xpath = "//*[@id=\"_TR\"]/td[2]/div/a[1]")
    private WebElement PreliminaryKaskoPolice;

    public void SavePreliminaryKaskoPolice(){
    PreliminaryKaskoPolice.click();
    }

    @FindBy(id = "BTN_SAVE")
    private WebElement ButtonSave;
    public void ButtonSave(){
        ButtonSave.click();
    }
    @FindBy(id = "CONTRACT_DOUBLE_SAVE")
    private WebElement CONTRACT_DOUBLE_SAVE;

    public void ClickCONTRACT_DOUBLE_SAVE(){
        CONTRACT_DOUBLE_SAVE.click();
    }


    @FindBy(id = "RESO_GARANTIJA_DATE_BUY_TS")
    private WebElement ResoGarantijaDateBuyTS;
    public void ResoGarantijaDateBuyTS(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = today.format(formatter);
        ResoGarantijaDateBuyTS.sendKeys(formattedDate);
    }

    @FindBy(id = "RESO_GARANTIJA_INSURANCE_SPEC_03_SEATS")
    private WebElement ResoGarantijaSeats;
    public void ResoGarantijaSeats(){
        ResoGarantijaSeats.sendKeys("5");
    }
    @FindBy(id = "CONTRACT_BEGIN_DATE_CALC")
    private WebElement ContractBeginDate;
    public void ContractBeginDate(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = today.format(formatter);
        ContractBeginDate.sendKeys(formattedDate);
    }


    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_COLOUR\"]/option[4]")
    private WebElement WhiteColor;
    public void InsuranceObjectColour(){
        WhiteColor.click();
    }
    @FindBy(id = "INSURANCE_OBJECT_DMG_NOTES")
    private WebElement InsuranceObjectDmgNote;
    public void InsuranceObjectDmgNote(){
        InsuranceObjectDmgNote.sendKeys("Нет");
    }
    @FindBy(xpath = "//*[@id=\"_TR\"]/td[2]/div/a[1]/strong")
    private WebElement ResoPolic;
    public void ResoPolic(){
        ResoPolic.click();
    }

    @FindBy(id = "//*[@id=\"INSURANCE_OBJECT_NEW2\"]/option[2]")
    private WebElement InsuranceObjectNew;
    public void InsuranceObjectNew(){
        InsuranceObjectNew.click();
    }

    @FindBy(id = "SOVKOMBANK_77_DATE_BUY")
    private WebElement SovkomBank77DateBuy;
    public void SovkomBank77DateBuy(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = today.format(formatter);
        SovkomBank77DateBuy.sendKeys(formattedDate);
    }
    @FindBy(id = "USER_1_DOC_DATE")
    private WebElement USER_1_DOC_DATE;
    public void USER_1_DOC_DATE(){
        USER_1_DOC_DATE.sendKeys("12.05.2018");
    }
    @FindBy(id = "INSURANCE_OBJECT_KUZOV")
    private WebElement InsuranceObjectKuzov;
    public void InsuranceObjectKuzov(){
        InsuranceObjectKuzov.sendKeys("ZD1MN370811519766");
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_COLOR\"]/option[20]")
    private WebElement InsuranceObjectColor;
    public void InsuranceObjectColor(){
        InsuranceObjectColor.click();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_CHANGE_DOC_TS\"]/option[3]")
    private WebElement InsuranceObjectChangeDocTs;
    public void InsuranceObjectChangeDocTs(){
        InsuranceObjectChangeDocTs.click();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_PTS_REGION\"]/option[3]")
    private WebElement InsuranceObjectPtsRegion;
    public void InsuranceObjectPtsRegion(){
        InsuranceObjectPtsRegion.click();
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_PTS_BY_KZ\"]/option[3]")
    private WebElement INSURANCE_OBJECT_PTS_BY_KZ;
    public void INSURANCE_OBJECT_PTS_BY_KZ(){
        INSURANCE_OBJECT_PTS_BY_KZ.click();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_PTS_GIBDD\"]/option[3]")
    private WebElement INSURANCE_OBJECT_PTS_GIBDD;
    public void INSURANCE_OBJECT_PTS_GIBDD(){
        INSURANCE_OBJECT_PTS_GIBDD.click();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_OWNER_COUNT\"]/option[3]")
    private WebElement INSURANCE_OBJECT_OWNER_COUNT;
    public void INSURANCE_OBJECT_OWNER_COUNT(){
        INSURANCE_OBJECT_OWNER_COUNT.click();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_FINDED_TS\"]/option[3]")
    private WebElement INSURANCE_OBJECT_FINDED_TS;
    public void INSURANCE_OBJECT_FINDED_TS(){
        INSURANCE_OBJECT_FINDED_TS.click();
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_CHANGE_VIN\"]/option[3]")
    private WebElement INSURANCE_OBJECT_CHANGE_VIN;
    public void INSURANCE_OBJECT_CHANGE_VIN(){
        INSURANCE_OBJECT_CHANGE_VIN.click();
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_BU_TS\"]/option[3]")
    private WebElement INSURANCE_OBJECT_BU_TS;
    public void INSURANCE_OBJECT_BU_TS(){
        INSURANCE_OBJECT_BU_TS.click();
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_MOLDING\"]/option[3]")
    private WebElement INSURANCE_OBJECT_MOLDING;
    public void INSURANCE_OBJECT_MOLDING(){
        INSURANCE_OBJECT_MOLDING.click();
    }
    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_TOTAL_REPAIR\"]/option[3]")
    private WebElement INSURANCE_OBJECT_TOTAL_REPAIR;
    public void INSURANCE_OBJECT_TOTAL_REPAIR(){
        INSURANCE_OBJECT_TOTAL_REPAIR.click();
    }

    @FindBy(xpath = "//*[@id=\"INSURANCE_OBJECT_EXHIBITION\"]/option[3]")
    private WebElement INSURANCE_OBJECT_EXHIBITION;
    public void INSURANCE_OBJECT_EXHIBITION(){
        INSURANCE_OBJECT_EXHIBITION.click();
    }

}
