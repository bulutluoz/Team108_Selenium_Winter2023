package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExistsTesti {

    @Test
    public void test01(){
        // Calistigimiz package icerisinde
        // text.txt isimli bir file oldugunu test edin

        String dinamikDosyaYolu = System.getProperty("user.dir")
                                    +"/src/test/java/day07_actionsClass_fileTestleri/text.txt";


        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
