import org.openqa.selenium.chrome.ChromeDriver;

public class ScenarioOne {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        String title;

        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
        title = driver.getTitle();

        if(title == "Your Store") {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.get("https://www.facebook.com/");
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();
    }
}
