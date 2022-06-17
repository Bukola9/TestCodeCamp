import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class JumiaLoginTest {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //1. open your chrome browser
        driver = new ChromeDriver();
        //2. Input your Jumia URL (https://www.jumia.com.ng)
        driver.get("https://www.jumia.com.ng/");
        //Test 1. Verify that user are on the right page
        if(driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //fail
        System.out.println("Wrong Webpage");
        Thread.sleep(10000);
        //3. Maximize the page
        driver.manage().window().maximize();
        //4. Click on the dropdown
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
    }

    @Test (priority = 0)
    public void ValidEmailAndPassword() throws InterruptedException {
        //Test 6. Verify that user can signin with valid email and password
        //6. click on the login button to open login page
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        //7. Input your email on email field
        Thread.sleep(5000);
        driver.findElement(By.id("fi-email")).sendKeys("adeniranbukolasamuel@gmail.com");
        //8. Input your password on password field
        driver.findElement(By.id("fi-password")).sendKeys("olubukola");
        Thread.sleep(10000);
        //9. Click on login button
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/button/span")).click();
        Thread.sleep(10000);
        // 10. Click on the dropdown
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        Thread.sleep(5000);
        //11. Click on logout button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();
        Thread.sleep(2000);
    }
       @Test (priority = 1)
        public void InvalidPassword() throws InterruptedException {
        //Test 2 Verify that user cannot signin with wrong password
           //4. Click on the dropdown
            driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
            //6. click on the login button to open login page
            driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
            //7. Input your email on email field
            Thread.sleep(5000);
            driver.findElement(By.id("fi-email")).sendKeys("adeniranbukolasamuel@gmail.com");
            //8. Input your password on password field
            driver.findElement(By.id("fi-password")).sendKeys("saraki");
            Thread.sleep(5000);
            //9. Click on login button
            driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/button/span")).click();
            Thread.sleep(5000);
                  }
    @Test (priority = 2)
    public void InvalidEmail() throws InterruptedException {
        //4. Click on the dropdown
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
        //Test 3 Verify that user cannot signin with invalid email address
        //6. click on the login button to open login page
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/div/a")).click();
        //7. Input your email on email field
        Thread.sleep(5000);
        driver.findElement(By.id("fi-email")).sendKeys("adeniranbukolasamuel@.com");
        //8. Input your password on password field
        driver.findElement(By.id("fi-password")).sendKeys("saraki");
        Thread.sleep(5000);
        //9. Click on login button
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/button/span")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 3)
    public void BlankEmail() throws InterruptedException {
        //4. Click on the dropdown
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
        //Test 4 Verify that user cannot signin with blank email address field and a correct password
        //6. click on the login button to open login page
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/div/a")).click();
        //7. Input your email on email field
        Thread.sleep(5000);
        driver.findElement(By.id("fi-email")).sendKeys("  ");
        //8. Input your password on password field
        driver.findElement(By.id("fi-password")).sendKeys("olubukola");
        Thread.sleep(5000);
        //9. Click on login button
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/button/span")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 4)
    public void BlankEmailAndPassword() throws InterruptedException {
        //4. Click on the dropdown
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
        //Test 5 Verify that user cannot signin with blank email address and password
        //6. click on the login button to open login page
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/div/a")).click();
        //7. Input your email on email field
        Thread.sleep(5000);
        driver.findElement(By.id("fi-email")).sendKeys("adeniranbukolasamuel@.com");
        //8. Input your password on password field
        driver.findElement(By.id("fi-password")).sendKeys("saraki");
        Thread.sleep(5000);
        //9. Click on login button
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/button/span")).click();
        Thread.sleep(5000);
    }


        @AfterTest
                public void closeBrowser (){
        //9. Quit the browser
        driver.quit();
    }
}
