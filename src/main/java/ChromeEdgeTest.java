import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ChromeEdgeTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","D:\\edgedriver_win64\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver chromeDriver = new ChromeDriver();
        EdgeDriver edgeDriver = new EdgeDriver();

        chromeDriver.get("https://demo.guru99.com/test/newtours/");
        edgeDriver.get("https://demo.guru99.com/test/newtours/");

        chromeDriver.close();
        edgeDriver.close();
    }
}
