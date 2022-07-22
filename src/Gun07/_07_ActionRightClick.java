package Gun07;

import Ultils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _07_ActionRightClick extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://demoqa.com/buttons");

        WebElement element=driver.findElement(By.id("rightClickBtn"));

        Actions aksiyonlar=new Actions(driver);
        Action aksiyon=aksiyonlar.moveToElement(element).contextClick().build();
        aksiyon.perform();


        BekleKapat();
    }
}
