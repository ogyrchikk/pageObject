package pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;
import org.openqa.selenium.support.PageFactory;

public class XistoreBasketPage{

    private WebDriver driver;
    @FindBy (xpath = "//*[@id='ORDER_PROP_1']")
    private WebElement nameInput;

    @FindBy (xpath = "//*[@id='ORDER_PROP_2']")
    private WebElement mailInput;

    @FindBy (xpath = "//*[@id='ORDER_PROP_3']")
    private WebElement phoneInput;

    @FindBy (xpath = "//*[@id='ORDER_PROP_7']")
    private WebElement addresInput;

    @FindBy (xpath = "//a[@class='ordersPayment--button js-click-radio active' and @data-block='Оплатить при получении']")
    private WebElement ordersPaymentInput;

    @FindBy (xpath = "//*[@id='ORDER_CONFIRM_BUTTON']")
    private WebElement orderConfirm;

    @FindBy (xpath = "//div[text()='Заказ сформирован']")
    private WebElement resaultOrder;

    public XistoreBasketPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public XistoreBasketPage fillInAllInputs(String name,String mail,String phone,String addres){
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        nameInput.sendKeys(name);
        mailInput.sendKeys(mail);
        phoneInput.sendKeys(phone);
        addresInput.sendKeys(addres);
        ordersPaymentInput.click();
        return this;
    }
    public XistoreBasketPage confirm(){
        orderConfirm.click();
        return this;
    }
    public String getTextFromConfirm(){
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Заказ сформирован']")));
        return resaultOrder.getText();
    }
}
