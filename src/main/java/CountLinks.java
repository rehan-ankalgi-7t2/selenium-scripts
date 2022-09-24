import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CountLinks {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");

        List<WebElement> elementsList = driver.findElements(By.tagName("a"));

        int listsize = elementsList.size();

        System.out.println("number of links in the page: "+listsize);
        for (int i = 0; i < listsize; i++) {
            WebElement ele = elementsList.get(i);
            String hrefText = ele.getAttribute("href");
            System.out.println(i+". "+hrefText);
        }

        driver.close();
    }
}
