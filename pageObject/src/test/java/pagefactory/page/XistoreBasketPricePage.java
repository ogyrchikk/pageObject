package pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagefactory.ResaultOfModification;
import waits.CustomConditions;
import org.openqa.selenium.support.PageFactory;

public class XistoreBasketPricePage{

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

    @FindBy (xpath = "//*[@id='pgo-price']")
    private WebElement goodsPrice;

    @FindBy (xpath = "//a[text()='КУПИТЬ']")
    private WebElement addGoodsToBasket;

    @FindBy (xpath = "//input[@value='ОФОРМИТЬ ЗАКАЗ']")
    private WebElement orderConfirmatoin;



    public XistoreBasketPricePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public XistoreBasketPricePage openPage() {
        driver.get(DEFAULT_URL);
        return this;
    }
    public XistoreBasketPricePage searchFofTerms(String term){
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        searchInput.sendKeys(term);
        searchButton.click();
        return this;
    }
    public XistoreBasketPricePage choiseItem(){
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        searchResultTable.click();
        return this;
    }
    public ResaultOfModification choiseModification(){

        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        String goodsPriceBefore =goodsPrice.getText();
        goodsModification.click();
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        String goodsPriceAfter =goodsPrice.getText();
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        addGoodsToBasket.click();
        return new ResaultOfModification(goodsPriceBefore,goodsPriceAfter);
    }
}
