package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //  Html komutu : https://username:password@URL
        //	Username     : admin
        // 	password      : admin
        //
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //4- Basarili sekilde sayfaya girildigini dogrulayin
        String actualGirisYazisi= driver.findElement(By.tagName("p")).getText();
        String expectedIcerik = "Congratulations";

        Assert.assertTrue(actualGirisYazisi.contains(expectedIcerik));

    }
}
