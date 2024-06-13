package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit URL
        driver.get("https://demoqa.com");

        //afisam browser-ul in mod maximised
        driver.manage().window().maximize();

        //cream un obiect de tip Method
        ElementsMethods elementsMethods = new ElementsMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);

        //comanda pt a inchide browser-ul: driver.quit();dar o punem cand terminam tot codul

        //facem scroll la pagina pt vizibilitate
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        // interactionam cu meniul/sub-meniul de pe site
        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        //formsMenu.click();
        elementsMethods.clickElement(formsMenu);

        WebElement formsSubmenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        //formsSubmenu.click();
        elementsMethods.clickElement(formsSubmenu);

        //introducem prenumele
        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Maria";
        //firstNameElement.sendKeys(firstNameValue);
        elementsMethods.fillElement(firstNameElement, firstNameValue);

        //introducem numele
        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Pop";
        //lastNameElement.sendKeys(lastNameValue);
        elementsMethods.fillElement(lastNameElement, lastNameValue);

        //introducem email-ul
        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "abc@def.com";
        //emailElement.sendKeys(emailValue);
        elementsMethods.fillElement(emailElement, emailValue);

        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //alegem bulina de gender
        //definim o logica generala de a selecta un element dintr-o lista
        List<WebElement> genderElements = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue = "Female";
        switch (genderValue){
            case "Male": genderElements.getFirst().click(); // get(0) sau getFirst(), e aceeasi chestie
                        elementsMethods.clickElement(genderElements.getFirst());
            break;
            case "Female": genderElements.get(1).click();
                            elementsMethods.clickElement(genderElements.get(1));
            break;
            case "Other": genderElements.get(2).click();
                            elementsMethods.clickElement(genderElements.get(2));
            break;
        }

        //introducem nr de telefon
        WebElement mobileNumberElement = driver.findElement(By.id("userNumber"));
        String mobileNumberValue = "0721458987";
        //mobileNumberElement.sendKeys(mobileNumberValue);
        elementsMethods.fillElement(mobileNumberElement, mobileNumberValue);

        //date of birth: lucram cu meniuri drop-down
        WebElement dateOfBirthElement = driver.findElement(By.id("dateOfBirthInput"));
        //dateOfBirthElement.click();
        elementsMethods.clickElement(dateOfBirthElement);

        WebElement dateOfBirthMonthElement = driver.findElement(By.className("react-datepicker__month-select"));
        //Select monthSelect = new Select(dateOfBirthMonthElement);
        //monthSelect.selectByVisibleText("June");
        elementsMethods.selectByTextElement(dateOfBirthMonthElement, "June");

        WebElement dateOfBirthYearElement = driver.findElement(By.className("react-datepicker__year-select"));
        //Select yearSelect = new Select(dateOfBirthYearElement);
        //yearSelect.selectByValue("1996");
        elementsMethods.selectByValueElement(dateOfBirthYearElement, "1993");


        List<WebElement> weekDaysElements = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']"));
        String weekDaysValue = "13";
        for(Integer i = 0; i<weekDaysElements.size(); i++) {
            if(weekDaysElements.get(i).getText().equals(weekDaysValue)) {
                //weekDaysElements.get(i).click();
                elementsMethods.clickElement(weekDaysElements.get(i));
                break;
            }
        }
                
        //introducem subiectul
        WebElement subjectInputElement = driver.findElement(By.id("subjectsInput"));
        String subjectInputValue = "Arts";
        //subjectInputElement.sendKeys(subjectInputValue);
        elementsMethods.fillElement(subjectInputElement, subjectInputValue);
        //selectam subiectul introdus; simulam un Enter de la tastatura
        //subjectInputElement.sendKeys(Keys.ENTER);
        elementsMethods.pressElement(subjectInputElement, Keys.ENTER);

        //facem scroll la pagina pt vizibilitate
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //selectam hobby
        List<WebElement> hobbiesElements = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading", "Music");
        for (Integer index=0; index<hobbiesElements.size();index++){
            String hobbyText = hobbiesElements.get(index).getText();
            if (hobbiesValues.contains(hobbyText)){
                //hobbiesElements.get(index).click();
                elementsMethods.clickElement(hobbiesElements.get(index));
            }
        }
        /* enhanced for:
        *List<WebElement> hobbiesElements = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        *List<String> hobbiesValues = Arrays.asList("Sports", "Reading", "Music");
        *for (WebElement hobbiesElement : hobbiesElements) {
        *   String hobbyText = hobbiesElement.getText();
        *    if (hobbiesValues.contains(hobbyText)) {
        *        hobbiesElement.click();
        *    }
        *}
        */

        //upload a picture; interactionam cu un fisier : uploadPicture
        WebElement pictureUploadElement = driver.findElement(By.id("uploadPicture"));
        String picturePathValue = "peakpx (1).jpg";
        File file = new File("src/test/resources/" + picturePathValue); //am creat un absolute path pt fisier, pt ca dadea eroare codul
        //pictureUploadElement.sendKeys(file.getAbsolutePath());
        elementsMethods.fillElement(pictureUploadElement, file.getAbsolutePath());

        //currentAddress
        WebElement addressElement = driver.findElement(By.id("currentAddress"));
        String addressValue = "adresa";
        //addressElement.sendKeys(addressValue);
        elementsMethods.fillElement(addressElement, addressValue);

        //state
        WebElement stateElement = driver.findElement(By.id("state"));
        //stateElement.click();
        elementsMethods.clickElement(stateElement);
        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateInputValue = "Uttar Pradesh";
        //stateInputElement.sendKeys(stateInputValue);
        elementsMethods.fillElement(stateInputElement, stateInputValue);
        //stateInputElement.sendKeys(Keys.ENTER);
        elementsMethods.pressElement(stateInputElement, Keys.ENTER);

        //city
        WebElement cityElement = driver.findElement(By.id("city"));
        //cityElement.click();
        elementsMethods.clickElement(cityElement);
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityInputValue = "Agra";
        //cityInputElement.sendKeys(cityInputValue);
        elementsMethods.fillElement(cityInputElement, cityInputValue);
        //cityInputElement.sendKeys(Keys.ENTER);
        elementsMethods.pressElement(cityInputElement, Keys.ENTER);

        //submit form
        WebElement submitForm = driver.findElement(By.id("submit"));
        //submitForm.click();
        elementsMethods.clickElement(submitForm);

        //validam tabelul cu valorile introduse
        WebElement thankYouMessageElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouMessageElement.getText(), "Thanks for submitting the form");

        List<WebElement> tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name " + firstNameValue + " " + lastNameValue);

        Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + emailValue);

        Assert.assertEquals(tableValues.get(2).getText(), "Gender " + genderValue);

        Assert.assertEquals(tableValues.get(3).getText(), "Mobile " + mobileNumberValue);

        Assert.assertEquals(tableValues.get(5).getText(), "Subjects " + subjectInputValue);

        String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesValues);
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);

        Assert.assertEquals(tableValues.get(7).getText(), "Picture " + picturePathValue);

        Assert.assertEquals(tableValues.get(8).getText(), "Address " + addressValue);

        Assert.assertEquals(tableValues.get(9).getText(), "State and City " + stateInputValue + " " + cityInputValue);

        WebElement closeElement = driver.findElement(By.id("closeLargeModal"));
        //js.executeScript("arguments[0].click();", closeElement);
        elementsMethods.clickJSElements(closeElement);









    }
}
