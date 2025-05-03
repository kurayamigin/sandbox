package parallel;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
  private WaitUtils() {

  }

  public static WebElement wait(WebDriver driver, String xpath, int timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
  }

  public static WebElement wait(WebDriver driver, String xpath) {
    return wait(driver, xpath, 30);
  }

}
