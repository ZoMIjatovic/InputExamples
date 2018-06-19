package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {

    
    public static void main(String[] args) throws InterruptedException {
        
        //create new WebDriver and WebDriver wait
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        
        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");
        
        
        // Fields on Login page found by name locator and explicit wait
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys("qa@cubes.rs");
        
        //WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));
        //wait.until(ExpectedConditions.visibilityOf(passwordField));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("cubesqa");
        
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
        loginButton.click();

        System.out.println("Page title is: " + driver.getTitle());

        
        
        // Several ways for opening Categories menu
        
        
        // finding by link text
        //WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories")));

        // finding by partial link text
        //WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Categ")));

        // by absoulte xPath 
        //WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app-navbar-collapse']/ul[1]/li[3]/a")));

        // by customized realtive xPath 
        WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://bvtest.school.cubes.rs/admin/categories']")));
        
        categories.click();
        System.out.println("Page title is: " + driver.getTitle());
        
        Thread.sleep(3000);
        //driver.quit();
    }
    
}
