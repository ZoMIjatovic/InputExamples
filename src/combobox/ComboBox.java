package combobox;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComboBox {
    
    public static void main(String[] args) {
        
        
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        
        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys("qa@cubes.rs");
        
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("cubesqa");
        
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
        loginButton.click();
        
        System.out.println(driver.getTitle());

        WebElement portals = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[5]/a")));
        portals.click();

        // Click on 'Add portal'
        WebElement addPortalButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pull-right")));
        addPortalButton.click();

        // Fill input field
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title")));
        titleField.sendKeys(Helper.getRandomText());

        // Fill url field
        WebElement urlField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("url")));
        urlField.sendKeys(Helper.getRandomUrl());
        
        // Find combo box by name locator
        WebElement combo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("region_id")));

        // Select
        Select regionCombo = new Select(combo);

        // Choose combo item by index
        //regionCombo.selectByIndex(2);
        
        // Choose combo item by value
        //regionCombo.selectByValue("427");
                
        // Choose combo item by visible text
        regionCombo.selectByVisibleText("Australija");
        
        
        // Save portal
        WebElement savePortalButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("save-portal-button")));
        savePortalButton.click();
        System.out.println("Portal has been saved!");

        
        //Thread.sleep(3000);
        //driver.quit();
    }
    
}
