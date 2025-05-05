package parallel;

import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestLogin {

  ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public TestLogin() {}

  @BeforeMethod
  public void setUp() {
    ChromeOptions options = new ChromeOptions();

    // Common options
    options.addArguments("--start-maximized");          // open browser in full screen
    options.addArguments("--disable-infobars");         // disabling infobars
    options.addArguments("--disable-extensions");       // disabling extensions
    options.addArguments("--disable-gpu");              // applicable to Windows OS only
    options.addArguments("--no-sandbox");               // Bypass OS security model
    options.addArguments("--remote-allow-origins=*");   // avoid connection errors
    options.addArguments("--disable-dev-shm-usage");
    // options.addArguments("--headless=new");
    options.setCapability("goog:loggingPrefs", new HashMap<String, Object>() {{
      put("browser", "ALL");
    }});
    WebDriver web = new ChromeDriver(options);
    this.driver.set(web);
    this.driver.get().navigate().to("https://practicetestautomation.com/practice-test-login/");

  }

  @AfterMethod
  public void tearDown() {
    this.driver.get().quit();
  }

  @Test
  public void testLogin() throws InterruptedException {
    WebDriver driver = this.driver.get();
    Thread.sleep(2000);
    WebElement username = WaitUtils.wait(driver, "//input[@id='username']");
    WebElement password = WaitUtils.wait(driver, "//input[@id='password']");
    username.sendKeys("student");
    password.sendKeys("Password123");
    WebElement submit = WaitUtils.wait(driver, "//button[@id='submit']");
    submit.click();

    WebElement welcome = WaitUtils.wait(driver, "//h1[@class='post-title']", 30);
    Assertions.assertEquals("Logged In Successfully", welcome.getText());
  }

  @Test
  public void testLogin2() throws InterruptedException {
    WebDriver driver = this.driver.get();
    Thread.sleep(2500);
    WebElement username = WaitUtils.wait(driver, "//input[@id='username']");
    WebElement password = WaitUtils.wait(driver, "//input[@id='password']");
    username.sendKeys("student");
    password.sendKeys("Password123");
    WebElement submit = WaitUtils.wait(driver, "//button[@id='submit']");
    submit.click();

    WebElement welcome = WaitUtils.wait(driver, "//h1[@class='post-title']", 30);
    Assertions.assertEquals("Logged In Successfully", welcome.getText());
  }

  @Test
  public void testLogin3() throws InterruptedException {
    WebDriver driver = this.driver.get();
    Thread.sleep(3000);
    WebElement username = WaitUtils.wait(driver, "//input[@id='username']");
    WebElement password = WaitUtils.wait(driver, "//input[@id='password']");
    username.sendKeys("student");
    password.sendKeys("Password123");
    WebElement submit = WaitUtils.wait(driver, "//button[@id='submit']");
    submit.click();

    WebElement welcome = WaitUtils.wait(driver, "//h1[@class='post-title']", 30);
    Assertions.assertEquals("Logged In Successfully", welcome.getText());
  }

}
