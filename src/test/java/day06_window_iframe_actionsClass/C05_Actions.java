package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C05_Actions extends TestBase {

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions= new Actions(driver);
        WebElement cizgiliAlanElementi= driver.findElement(By.id("hot-spot"));

        actions.contextClick(cizgiliAlanElementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilksayfaWHD= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        Set<String> tumWHDleriSeti= driver.getWindowHandles(); // [ilkSayfaWHD,ikinciSayfaWHD]
        String ikinciSayfaWHD ="?";

        for (String each: tumWHDleriSeti
             ) {
            if (!each.equals(ilksayfaWHD)){
                ikinciSayfaWHD = each;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        String expectedYazi= "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        bekle(3);
    }
}
