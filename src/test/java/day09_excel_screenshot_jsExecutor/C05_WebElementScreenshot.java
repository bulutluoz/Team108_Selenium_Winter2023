package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_WebElementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edin

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualSonucYazisi =sonucYaziElementi.getText();

        String expectedIcerik = "Nutella";

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // ve rapora eklenmek icin sonuc yazisi elementinin fotografini cekin

        // 1- fotograf cekilecek elementi locate edin
        // 2- Dosyayi kaydetmek icin bir File olusturun

            File elementSs = new File("target/elementScreenshot.jpg");

        // 3- webelement ile screenshot cekip gecici dosyaya kaydedin

        File geciciDosya= sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi elementSs'e kopyalayalim

        FileUtils.copyFile(geciciDosya,elementSs);

    }
}
