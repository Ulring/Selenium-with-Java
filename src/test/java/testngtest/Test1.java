package testngtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
import java.time.Duration;


public class Test1 {
    public String baseUrl = "https://github.com/42-AI/42ai_pdf_builder";
    public String gitUrl;
    String driverPath = "C:\\chromedriver.exe";
    public WebDriver driver ;

    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void getUrl(){
        WebDriverWait wait_for_code = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait_for_code.until(ExpectedConditions.elementToBeClickable(By.tagName("get-repo")));
        driver.findElement(By.tagName("get-repo")).click();
        WebDriverWait wait_for_git_ssh = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait_for_git_ssh.until(ExpectedConditions.elementToBeClickable(By.tagName("clipboard-copy")));
        driver.findElement(By.tagName("clipboard-copy")).click();
        try {
            gitUrl = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
            Assert.assertNotNull(gitUrl);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void verifyUrl(){
        Process p;
        try {
            p = Runtime.getRuntime().exec("cmd /c wsl git ls-remote " + gitUrl);
            p.waitFor();
            BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
            Assert.assertNotNull(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void terminateBrowser(){
       driver.close();
    }
}