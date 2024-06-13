package Tests;

import HelperMethods.BrowserWindowMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit URL
        driver.get("https://demoqa.com");

        //afisam browser-ul in mod maximised
        driver.manage().window().maximize();

        //definim un obiect de tip WindowMethods
        BrowserWindowMethods windowMethods = new BrowserWindowMethods(driver);
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

        WebElement browserWindowSubmenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        //browserWindowSubmenu.click();
        elementsMethods.clickElement(browserWindowSubmenu);

        //interactionam cu butonul de New Tab
        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        js.executeScript("arguments[0].click();", newTabElement);

        //cum interactionam cu un tab/window: framework-urile nu fac diferenta intre ele, deci folosim aceeasi metoda
        System.out.println(driver.getCurrentUrl()); //va afisa titlul paginii curente
        //ca sa se mute focusul pe alta pagina; le trateaza pe toate ca pe niste string-uri, deci mai multe tab-uri vor fi interpretate ca o multime
        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); //iti spune cate tab-uri/window-uri sunt deschise curent/ in mom. definirii
        //ne mutam cu focusul pe un anume tab/window
        //driver.switchTo().window(tabs.get(1));
        //System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);

        //inainte sa mergem mai departe, trebuie sa remutam focusul pe primul tab, deci trebuie sa inchidem tab-ul curent
        //driver.close(); //close vs quit: close inchidse tab-ul curent, iar quit inchide browser-ul cu toate tab-urile
        windowMethods.closeCurrentTab();

        //desi am inhchis tab-ul curent, tot nu inseamna ca am revenit cu focusul la tab-ul initial; pt asta, avem metoda:
        //driver.switchTo().window(tabs.get(0));
        windowMethods.switchSpecificTab(0);
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //interactionam cu butonul de New Window
        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        //newWindowElement.click();
        elementsMethods.clickElement(newWindowElement);

        System.out.println(driver.getCurrentUrl());

        //List<String> windows = new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(windows.get(1));
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());

        //driver.close();
        //driver.switchTo().window(windows.get(0));
        windowMethods.closeCurrentTab();

        driver.quit();

    //how to open a new tab in selenium java
        //driver.switchTo().newWindow(WindowType.TAB);
    }
}
