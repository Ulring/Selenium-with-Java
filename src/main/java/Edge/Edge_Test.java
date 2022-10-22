package Edge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Edge_Test {
    public static void main(String[] args) {

//Setting system properties of EdgeDriver
        System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");

//Creating an object of EdgeDriver
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

//Deleting all the cookies
        driver.manage().deleteAllCookies();

//launching the specified URL
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
        actions.sendKeys(filter, "vim");
        WebDriverWait wait_for_table = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait_for_search.until(ExpectedConditions.elementToBeClickable(By.tagName("td")));
        actions.perform();

//closing the browser
        //driver.close();
    }
}