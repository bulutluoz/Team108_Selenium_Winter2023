package day02_webelements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverMethodlari {
    public static void main(String[] args) {
        //Yeni bir class olusturalim (Homework)
        //ChromeDriver kullanarak, facebook sayfasina gidin
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
        // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
        // degilse dogru basligi yazdirin.
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("facebook title testi PASSED");
        }else{
            System.out.println("facebook title testi FAILED" +
                    "\nGerceklesen title : " + actualTitle);
        }
        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
        // icermiyorsa “actual” URL’i yazdirin.
        String expectedIcerik="facebook";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Facebook url testi PASSED");
        }else {
            System.out.println("Facebook url testi FAILED" +
                    "\nGerceklesen url : " + actualUrl);
        }


        // https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com");
        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String walmartExpectedIcerik= "Walmart.com";
        String walmartActualTitle= driver.getTitle();

        if (walmartActualTitle.contains(walmartExpectedIcerik)){
            System.out.println("Walmart title testi PASSED");
        }else{
            System.out.println("Walmart title testi FAILED");
        }

        // Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        // Sayfayi yenileyin

        driver.navigate().refresh();
        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        //Browser’i  kapatin
        driver.close();
    }
}
