package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit URL
        driver.get("https://demoqa.com");

        //afisam browser-ul in mod maximised
        driver.manage().window().maximize();

        //cream obiecte
        ElementsMethods elementsMethods = new ElementsMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);

        //comanda pt a inchide browser-ul: driver.quit();dar o punem cand terminam tot codul

        //facem scroll la pagina pt vizibilitate
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0, 350);


        //interactionam cu meniul/sub-meniul de pe site
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        //elementsMenu.click();
        elementsMethods.clickElement(elementsMenu);

        WebElement webTableSubmenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        //webTableSubmenu.click();
        elementsMethods.clickElement(webTableSubmenu);
        //definim un element dupa ID
        
        //test 1: adaugam un rand nou
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        //addElement.click();
        elementsMethods.clickElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Irina";
        //firstNameElement.sendKeys(firstNameValue);
        elementsMethods.fillElement(firstNameElement, firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Pricop";
        //lastNameElement.sendKeys(lastNameValue);
        elementsMethods.fillElement(lastNameElement, lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "pricop_irina2009@yahoo.com";
        //emailElement.sendKeys(emailValue);
        elementsMethods.fillElement(emailElement, emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "27";   // de ce nu se face o metoda cu int?
        //ageElement.sendKeys(ageValue);
        elementsMethods.fillElement(ageElement, ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "5000";
        //salaryElement.sendKeys(salaryValue);
        elementsMethods.fillElement(salaryElement, salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "testing";
        //departmentElement.sendKeys(departmentValue);
        elementsMethods.fillElement(departmentElement, departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        //submitElement.click();
        elementsMethods.clickElement(submitElement);


        pageMethods.scrollPage(0, 450);
        //test 2: modific un entry existent
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        //editElement.click();
        elementsMethods.clickElement(editElement);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "7500";
        //editSalaryElement.clear();
        elementsMethods.clearFillElement(editSalaryElement, editSalaryValue);
        //editSalaryElement.sendKeys(editSalaryValue);
        elementsMethods.fillElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "7500";
        //editDepartmentElement.clear();
        elementsMethods.clearFillElement(editDepartmentElement, editDepartmentValue);
        //editDepartmentElement.sendKeys(editDepartmentValue);
        elementsMethods.fillElement(editDepartmentElement, editDepartmentValue);

        WebElement editSubmitElement = driver.findElement(By.id("submit"));
        //editSubmitElement.click();
        elementsMethods.clickElement(editSubmitElement);

        //test 3: sterge un entry existent
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        //deleteElement.click();
        elementsMethods.clickElement(deleteElement);

        driver.quit();


    }


}
