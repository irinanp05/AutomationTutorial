package HelperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowMethods {

        public WebDriver driver;

        //constructor
        public BrowserWindowMethods(WebDriver driver) {
            this.driver = driver;
        }

        //metode genrale pt interactiunea cu tab/window

        public void switchSpecificTab (Integer index) {
            List<String> windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(index));
        }

        public void closeCurrentTab() {
            driver.close();
        }
}
