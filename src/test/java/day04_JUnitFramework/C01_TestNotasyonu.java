package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
        Framework : Ortak calisma cercevesi
                    Hangi dosyalari nerede olusturacagimiz belirler ve boylece toplu calismayi kolaylastirir
                    Her framework, dosya duzeni olusturmanin yaninda,
                    islerimizi kolaylastiran yeni ozellikler sunmustur

                    JUnit framework en temel test framework'udur
                    bize kazandirdigi en onemli ozelllik @Test Annotation (Notasyon)'dir

                    @Test notasyonu sayesinde her bir method
                    bagimsiz olarak calistirilabilen bir TEST Method'u olur

                    @Test notasyonu sayesinde istersek herbir test method'unu bagimsiz calistirabildigimiz gibi
                    istenirse class level'dan calistirip,
                    tum testlerin calismasini saglayabiliriz

                    JUnit framework'de test method'larinin hangi sira ile calisacagini
                    ONGOREMEYIZ ve KONTROL EDEMEYIZ
     */
    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.wisequarter.com");

        driver.close();
    }

    @Test
    public void test02(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");
        driver.close();
    }

}
