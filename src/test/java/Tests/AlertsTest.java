package Tests;

import HelperMethods.AlertsMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit URL
        driver.get("https://demoqa.com");

        //afisam browser-ul in mod maximised
        driver.manage().window().maximize();

        //wait implicit - face pentru toate structurile de tipul findElement
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //definim un obiect de tip AlertMethods ca sa apelam metodele generale din clasa
        AlertsMethods alertsMethods = new AlertsMethods(driver);
        ElementsMethods elementsMethods = new ElementsMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);

        //facem scroll la pagina pt vizibilitate
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //interactionam cu meniul/sub-meniul de pe site
        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertsMenu.click();
        elementsMethods.clickElement(alertsMenu);

        WebElement alertsSubmenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        //alertsSubmenu.click();
        elementsMethods.clickElement(alertsSubmenu);

        //interactionam cu primul buton de click pt alerta
        WebElement alertOKButtonElement = driver.findElement(By.id("alertButton"));
        //alertOKButtonElement.click();
        elementsMethods.clickElement(alertOKButtonElement);
        alertsMethods.acceptAlert();

        //cum intaractionam cu butonul de OK din mesajul afisat - nu putem inspecta butonul -> cream un obiect de tip Alert
        //Alert alertOK = driver.switchTo().alert();
        //System.out.println(alertOK.getText());
        //alertOK.accept();

        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //interactionam cu al doilea click cu timer - wait implicit vs explicit
        WebElement alertOKTimerButtonElement = driver.findElement(By.id("timerAlertButton"));
        //alertOKTimerButtonElement.click();
        elementsMethods.clickElement(alertOKTimerButtonElement);
        alertsMethods.acceptAlert();
        //Alert alertOKTimer = driver.switchTo().alert(); //cu implicit, aici cade, trebuie facut cu explicit
        //alertOKTimer.accept();

        /* //definim un wait explicit, special pt a interactiona cu acceptul de la prompt
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.accept();
        */

        //interactionam cu al treilea click cu confirm/cancel
        WebElement alertConfirmCancelElement = driver.findElement(By.id("confirmButton"));
        //alertConfirmCancelElement.click();
        elementsMethods.clickElement(alertConfirmCancelElement);

        alertsMethods.dismissAlert();

        //Alert alertConfirm = driver.switchTo().alert();
        //System.out.println(alertConfirm.getText()); //ca sa afiseze in consola textul de la alerta de pe site
        //alertConfirm.dismiss();

        //interactionam cu al patrulea click cu prompt box
        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        //alertPromptElement.click();
        elementsMethods.clickElement(alertPromptElement);

        alertsMethods.fillInAlert("Maria");


       // Alert alertPrompt = driver.switchTo().alert();
        //System.out.println(alertPrompt.getText());
        //String alertValue = "Maria";
        //alertPrompt.sendKeys(alertValue); //poti pune direct textul in "", dar mai bine salvam o variabila pentru asta
        //alertPrompt.accept();


    }
}
