package pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;
import org.openqa.selenium.support.PageFactory;

public class XistoreCatalogPage{

    public static final String DEFAULT_URL= "https://xistore.by/";
    private WebDriver driver;
    @FindBy (xpath = "//input[@id='title-search-input']")
    private WebElement searchInput;

    @FindBy (xpath = "//button[@class='input-search-button']")
    private WebElement searchButton;

    @FindBy (xpath = "//a[@class='search__page_item-name' and @href='/catalog/telefony/smartfon_xiaomi_redmi_note_9_pro/?offer=39907']")
    private WebElement searchResultTable;

    @FindBy (xpath = "//a[@data-type='128 Gb']")
    private WebElement goodsModification;

    @FindBy (xpath = "//a[text()='КУПИТЬ']")
    private WebElement addGoodsToBasket;

    @FindBy (xpath = "//input[@value='ОФОРМИТЬ ЗАКАЗ']")
    private WebElement orderConfirmatoin;

    public XistoreCatalogPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public XistoreCatalogPage openPage() {
        driver.get(DEFAULT_URL);
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }
    public XistoreCatalogPage searchFofTerms(String term){
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        searchInput.sendKeys(term);
        searchButton.click();
        return this;
    }
    public XistoreCatalogPage choiseItem(){
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        searchResultTable.click();
        return this;
    }
    public XistoreCatalogPage choiseModificationAndFillTheBasket(){
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        goodsModification.click();
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        addGoodsToBasket.click();
        return this;
    }
    public XistoreBasketPage confirmationOfTheOrder(){
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ОФОРМИТЬ ЗАКАЗ']")));
        orderConfirmatoin.click();
        return new XistoreBasketPage(driver);
    }
}
