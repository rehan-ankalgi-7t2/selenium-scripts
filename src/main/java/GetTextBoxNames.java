import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextBoxNames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        String fname, lname, email, password;

        driver.get("https://demo.opencart.com/");

        driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/ul/li[2]/div/a/span")).click();
        driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")).click();

        fname = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/form/fieldset[1]/div[2]/div/input")).getAttribute("name");
        lname = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/form/fieldset[1]/div[3]/div/input")).getAttribute("name");
        email = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/form/fieldset[1]/div[4]/div/input")).getAttribute("name");
        password = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/form/fieldset[2]/div/div/input")).getAttribute("name");

        System.out.println("fname: "+fname);
        System.out.println("lname: "+lname);
        System.out.println("email: "+email);
        System.out.println("password: "+password);

        driver.close();
    }
}
