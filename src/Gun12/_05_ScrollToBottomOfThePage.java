package Gun12;

import Ultils.BaseStaticDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.devtools.idealized.Javascript;

public class _05_ScrollToBottomOfThePage extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://triplebyte.com/");

        JavascriptExecutor js=(JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        // sayfanın sonuna kadar kaydırır.

        BekleKapat();
    }
}
