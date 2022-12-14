package Gun12;

import Ultils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _02_WindowsSwitch extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.selenium.dev/");
        String anaSayfaWindowId=driver.getWindowHandle(); // bulundugun sayfanın wın ıd sı

       List< WebElement> linkler= driver.findElements(By.cssSelector("a[target='_blank']"));

       for (WebElement link:linkler)
       {
           if (!link.getAttribute("href").contains("mailto"))
           link.click();
       }
        Set<String> windowsIdler=driver.getWindowHandles();

       for (String id: windowsIdler) {
           if (id.equals(anaSayfaWindowId)) continue; // ana sayfa degilse

           System.out.println("id = " + id);
           driver.switchTo().window(id); // diğer sayfaya (windowa ) geçiş yaptk
           System.out.println(id+"Title = " +driver.getTitle()); // açık olan tum sayfaların win id ler

       }

        Bekle(3);
        BekleKapat();
    }
}
