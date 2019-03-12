import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class SimpleTest {


    @Test

    public void navigateToSunbirdS3() {

        File file = new File("./src/drivers/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver driver = new ChromeDriver();
        WebElement button;


        //driver.manage().window().maximize();
        driver.get("https://web-ui-sunbird-s3.tom.takeoff.com/");


        // enter zip-code
        WebElement enterZipCodefield = driver.findElement(By.id("input-zip-code"));
        enterZipCodefield.sendKeys("33175");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        //scroll down page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");


        // click for search button
        button = driver.findElement(By.className("inline-button"));
        try {
            button.click();

        } catch (Exception e) {

        }
        button.click();


        // search for mfc and push select
        button = driver.findElement(By.xpath(".//*[@id='location-item-sedanos-7']//button[@class='inline-button']"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        button.click();

        // new comment from mac book
    }







        /* GET COOKIES AND WRITE TO TXT*/

//        try {
//            File f= new File("cookies.txt");
//            FileWriter fs= new FileWriter(f);
//            BufferedWriter  bw= new BufferedWriter(fs);
//
//            Set<Cookie> myCookies = driver.manage().getCookies();
//            for(Cookie ck:myCookies)
//            {
//
//                bw.write(ck.getName()+";"+ck.getValue());
//                bw.flush();
//            }
//            bw.close();
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }






                        /*    SIGN UP NEW USER */

//        // push on account button
//        button = driver.findElement(By.className("user-name"));
//        button.click();
//        button = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/ul/li[3]/p/button[2]"));
//        button.click();
//
//        //signUp form
//        WebElement field = driver.findElement(By.id("input-fullName"));
//        field.sendKeys("Full name");
//        field = driver.findElement(By.id("input-email"));
//        field.sendKeys("fullname@ask-mail.com");
//        field = driver.findElement(By.id("input-phone"));
//        field.sendKeys("13028039935");
//        field = driver.findElement(By.id("input-password"));
//        field.sendKeys("12345678a");
//        field = driver.findElement(By.id("input-passwordConfirm"));
//        field.sendKeys("12345678a");
//        button = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/button"));
//        button.click();
//        //driver.quit();/



    @Test

    public void login() {

        WebDriver driver = new ChromeDriver();
        WebElement button;


        navigateToSunbirdS3();
        driver.findElement(By.className("user-name")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/ul/li[3]/p/button[1]")).click();
        driver.findElement(By.id("input-email")).sendKeys("fullname@ask-mail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345678a");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/button[2]")).click();

        try {
            File f = new File("cookies.txt");
            FileWriter fs = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fs);

            Set<Cookie> myCookies = driver.manage().getCookies();
            for (Cookie ck : myCookies) {

                bw.write(ck.getName() + ";" + ck.getValue());
                bw.flush();
            }
            bw.close();
        } catch (IOException e) {

            e.printStackTrace();
        }


    }}



