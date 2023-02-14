package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C07_Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //	1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com/");
        //  2- Arama kutusuna “city bike” yazip aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);
        //	3- Görüntülenen sonuçların sayısını yazdırın
        WebElement sonucYaziElementi= driver.findElement(By.className("rush-component"));
        System.out.println(sonucYaziElementi.getText());
        //	4- Listeden ilk urunun resmine tıklayın.

        driver.findElement(By.className("s-image")).click();
        Thread.sleep(3000);

        driver.close();

    }
}
