import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElementID {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");


        driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/ul/li[2]/div/a/span")).click();
        driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a")).click();

        String emailID;
        String passwordID;

        passwordID = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[2]/div/div/form/div[2]/input")).getAttribute("id");
        emailID = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[2]/div/div/form/div[1]/input")).getAttribute("id");

        System.out.println("email ID: "+emailID);
        System.out.println("password ID: "+passwordID);

        driver.close();
    }
}
