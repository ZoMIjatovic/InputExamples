
package radioButton;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RadioButton {
    
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        driver.manage().window().maximize();
        driver.get("https://www.nngroup.com/articles/checkboxes-vs-radio-buttons/");

        System.out.println("Page title: " + driver.getTitle());
        

        // Find radio items by using relative xPath
        //List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        List<WebElement> radioButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type='radio']")));

        // Click on item based on his position inside list
        radioButtons.get(4).click();

        // Click on every item
        for (WebElement radioButton : radioButtons) {
            radioButton.click();
        }
        
        // Click on every item 2
        for (int i = 0; i < radioButtons.size(); i++) {
            radioButtons.get(i).click();
        }
        
        
        Thread.sleep(2000);
//        driver.quit();

    }
    
}
