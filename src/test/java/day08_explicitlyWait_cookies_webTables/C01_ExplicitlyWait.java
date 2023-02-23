package day08_explicitlyWait_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait {

    @Test
    public void test01(){

        /*
            Implicitly Wait test yaparken ihtiyacimiz olan beklemelerin cogunu halleder
            Nadiren de olsa bazi islemler icin implicitlyWait icin tanimlanan
            sureden daha fazla zamana ihtiyac olabilir

            ExplicitlyWait bir webelement uzerinde gerceklesecek
            TEK BIR gorev icin tanimlanir

            Bunun icin hem webelement tanimlanmali, hem de gorev
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //   explicitly wait kullanacaksak
        //   A - bir wait objesi olustur

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

        //  B - EGER kullanacagimiz webelement locate edilebilir ise locate yapalim

        // WebElement itsGoneElementi=
                //driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        //  C- EGER locate etmemiz icin zamana ihtiyac varsa,
        //     Locate ve gorev tanimlamayi tek satirda yapiyoruz

        WebElement itsGoneElementi=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        driver.close();




    }
}
