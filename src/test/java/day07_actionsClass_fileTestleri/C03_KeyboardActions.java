package day07_actionsClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyboardActions extends TestBase {

    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Cookies'i kabul edip Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_only_essential_button']"))
                .click();
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"))
                .click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        bekle(2);
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@placeholder='First name']"));

        Actions actions= new Actions(driver);
        Faker faker= new Faker();
        String fakeEmailAdress=faker.internet().emailAddress();

        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmailAdress)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmailAdress)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("20")
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


        //4- Kaydol tusuna basalim

        bekle(10);
    }

}
