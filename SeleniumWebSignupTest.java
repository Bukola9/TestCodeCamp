import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start () throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();

    }

    @Test (priority =0)
    public void openurl() throws InterruptedException {
        //2. Input your Selenium Demo page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        //Test1. Verify that user are on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(10000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void positiveSignup () throws InterruptedException {
        //Test7. Verify that user succesfully signedup when valid details are inputted
        //5. Input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("bukola76");
        //6. Input your email address on email address field
        driver.findElement(By.id("user_email")).sendKeys("adeniranbukolasamuel76@gmail.com");
        //7. Locate your password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("olubukola");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
       @Test (priority = 2)
       public void clickUser1Item() throws InterruptedException {
           //9. Click on user1 item on listpage
           driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
           //Test2. Verify that when user clicks on signup button, the user is directed to signup page
           String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
           String actualUrl = driver.getCurrentUrl();
           if(actualUrl.contains("expectedUrl"))
               //Pass
               System.out.println("Correct Webpage");
           else
               //Fail
               System.out.println("Wrong Webpage");

           Thread.sleep(5000);
       }
       @Test (priority = 3)
               public void verifyItem() throws InterruptedException {
           //Test9. Verify that the item searched for on the user1 page is present
           driver.findElement(By.xpath("/html/body/div[2]/div[37]/div/div/div[1]/a")).click();
           String expectedPageUrl = "/users/1";
           String actualPageUrl = driver.getCurrentUrl();
           if (actualPageUrl.contains("expectedPageUrl"))
               //Pass
               System.out.println("Correct User1Page");
           else
               //Fail
               System.out.println("Wrong User1Page");
           Thread.sleep(5000);

       }

           @Test (priority = 4)
           public void logoutSuccessfully(){
           //11. Click on logout
           driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
           // Test10. verify that when the user logout, he/she is directed back to the home page
           String expectedTitle = "AlphaBlog";
           String actualTitle = driver.getTitle();
           if(actualTitle.contains("expectedTitle"))
               //Pass
               System.out.println("Correct Webpage");
           else
               //Fail
               System.out.println("Wrong Webpage");

       }
    @Test (priority = 5)
    public void negativeSignup () throws InterruptedException {
        //Click on signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test3. Verify that user cannot signup with username less than 3 characters
        //5. Input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("bu");
        //6. Input your email address on email address field
        driver.findElement(By.id("user_email")).sendKeys("adeniranbukolasamuel21@gmail.com");
        //7. Locate your password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("olubukola");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 6)
    public void emptySignupField () throws InterruptedException {
        //Click on signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //Test6 Verify that user cannot signup with empty field
        //5. Input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("   ");
        //6. Input your email address on email address field
        driver.findElement(By.id("user_email")).sendKeys("      ");
        //7. Locate your password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("   ");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);


    }
    @Test (priority = 7)
    public void invalidEmail () throws InterruptedException {
        //Click on signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //Test8. Verify that user cannot signup with invalid email
        //5. Input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("bukola43");
        //6. Input your email address on email address field
        driver.findElement(By.id("user_email")).sendKeys("bukola@");
        //7. Locate your password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("olubukola");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 8)
    public void invalidPassword () throws InterruptedException {
        //Click on signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //Test9. Verify that user cannot signup with invalid password
        //5. Input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("bukola43");
        //6. Input your email address on email address field
        driver.findElement(By.id("user_email")).sendKeys("bukola@");
        //7. Locate your password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("a");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
        @AfterTest
        public void closeBrowser() {
            //12. Quit the browser
            driver.quit();
        }

    }







