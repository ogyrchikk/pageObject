package pagefactory.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagefactory.ResaultOfModification;
import pagefactory.page.*;

public class XistoreTest {
    private WebDriver driver;
    @BeforeTest
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "C:/q/chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void test(){
        String textFromPage = new XistoreCatalogPage(driver)
                 .openPage()
                 .searchFofTerms("Redmi note 9 pro")
                 .choiseItem()
                 .choiseModificationAndFillTheBasket()
                 .confirmationOfTheOrder()
                 .fillInAllInputs("Ковтун Андрей Николаевич","kovtyn780919019@gmail.com","445427822","Рафиева 8")
                 .confirm().getTextFromConfirm();
        Assert.assertTrue("error",textFromPage.equals("ЗАКАЗ СФОРМИРОВАН"));
    }
    @AfterTest
    public void browserKill(){
        driver.quit();
    }
    @Test
    public void testPrice(){
        ResaultOfModification price = new XistoreBasketPricePage(driver).openPage().searchFofTerms("Redmi note 9 pro").choiseItem().choiseModification();
        String before = price.getBefore();
        String after = price.getAfter();
        System.out.println(before);
        System.out.println(after);
        Assert.assertFalse("error",before==after);
    }

}
