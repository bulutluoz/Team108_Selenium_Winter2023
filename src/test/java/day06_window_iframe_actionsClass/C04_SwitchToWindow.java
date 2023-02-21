package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_SwitchToWindow extends TestBase {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement ilkSayfaYaziElementi= driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi= ilkSayfaYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        bekle(2);
        String ilkSayfaWHD=driver.getWindowHandle();
        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        /*
            Eger switchToNewWindow() method'u kullanilirsa
            driver yeni acilan sayfaya gecis yapar

            Ancak bu method kullanilmadan
            bir link tiklandiginda, yeni bir sayfa aciliyorsa
            driver yeni sayfaya gecis yapmaz

            bizim yeni acilan sayfanin
            windowHandle degerini bulup
            driver'i o sayfaya gecirmemiz GEREKLIDIR

            link'e click yaptigimizda acik 2 sayfamiz oluyor
            bunlardan bir tanesi windowHandle degerini kaydettigimiz ILK SAYFA
            digeri ise windowHandle degerini bilmedigimiz IKINCI SAYFA

            biz getWindowHandles() method'u ile
            bir SET olarak iki sayfanin windowHandle degerlerini alabiliyoruz

            O SET icerisinde
            ilkSayfaWHD'ine esit olmayan String'i
            ikinciSayfaWHD olarak atayabiliriz

         */

        Set<String> tumSayfalarWHDSeti= driver.getWindowHandles();

        String ikinciSayfaWHD="";

        for (String each: tumSayfalarWHDSeti
             ) {
            if (!each.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=each;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);
        expectedTitle="New Window";
        actualTitle= driver.getTitle();
        bekle(2);
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String ikinciSayfaYazi= driver.findElement(By.tagName("h3")).getText();
        expectedYazi="New Window";
        Assert.assertEquals(expectedYazi,ikinciSayfaYazi);

        //● Bir önceki pencereye geri döndükten sonra
        driver.switchTo().window(ilkSayfaWHD);
        // sayfa başlığının “The Internet” olduğunu doğrulayın.
        expectedTitle = "The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        bekle(3);
    }













}
