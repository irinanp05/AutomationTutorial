package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsMethods {
    public WebDriver driver;

    public AlertsMethods(WebDriver driver) {
        this.driver = driver;
    }

    //definim metodele generale pt interactiunea cu alertele
    //avem 4 metode de facut: accept, dismiss, prompt si wait

    public void waitForAlert() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {

        waitForAlert();
        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.accept();
    }

    public void dismissAlert() {

        waitForAlert();
        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.dismiss();
    }

    public void fillInAlert(String value) {

        Alert alertPrompt = driver.switchTo().alert();
        System.out.println(alertPrompt.getText());
        alertPrompt.sendKeys(value);
        alertPrompt.accept();
    }
}
