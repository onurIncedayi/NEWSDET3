package Gun14;

import Ultils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
SENARYO 3:
        -"https://shopdemo.e-junkie.com/" web sitesine gidin
        -'Demo eBook' için 'Sepete Ekle'ye tıklayın
        -'Banka Kartı ile Öde' seçeneğine tıklayın
        -Herhangi bir bilgi doldurmadan 'Öde' butonuna tıklayın
        - Doğrula "Geçersiz E-posta - Geçersiz E-posta - Geçersiz Fatura Adı" mesajı görüntüleniyor!*/
public class Senaryo3 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://shopdemo.e-junkie.com/");

        Bekle(2);
        WebElement demoEbook=driver.findElement(By.xpath("//div[@class='thumbnail'and @style='background-image: url(https://s3.amazonaws.com/static.e-junkie.com/products/thumbnails/1595015.png); border-radius: 4px 4px 0px 0px;']"));
        demoEbook.click();

        WebElement sepeteEkle=driver.findElement(By.cssSelector("[class='g_btn']"));
        sepeteEkle.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));

        Bekle(4);
        WebElement bankaKarti=driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        bankaKarti.click();

        WebElement odeBtn=driver.findElement(By.cssSelector("[class='Pay-Button']"));
        odeBtn.click();

        WebElement assertOne=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='Close-SnackBar md hydrated']+span")));
        Assert.assertTrue(assertOne.getText().contains("Invalid Email"));

        Assert.assertTrue(driver.getPageSource().contains("Invalid Email"));
        Assert.assertTrue(driver.getPageSource().contains("Invalid Billing Name"));

        BekleKapat();
    }
}
