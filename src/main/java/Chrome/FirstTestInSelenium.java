package Chrome;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTestInSelenium {

    /*public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub

//setting the driver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

//Initiating your chromedriver
        WebDriver driver = new ChromeDriver();

//maximize window
        driver.manage().window().maximize();

//open browser with desired URL
        driver.get("https://ulring.github.io/");

//search in the website
        WebDriverWait wait_for_details = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait_for_details.until(ExpectedConditions.elementToBeClickable(By.tagName("details")));
        driver.findElement(By.tagName("details")).click();
        WebDriverWait wait_for_search = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait_for_search.until(ExpectedConditions.elementToBeClickable(By.id("search")));
        driver.findElement(By.id("search")).click();
        Actions actions = new Actions(driver);
        WebElement filter = driver.findElement(By.id("search"));
        actions.click(filter);
        actions.sendKeys(filter,"vim");
        WebDriverWait wait_for_table = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait_for_search.until(ExpectedConditions.elementToBeClickable(By.tagName("td")));
        actions.perform();

//closing the browser
        driver.close();
    }*/

}