import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class JpetStore {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://jpetstore.aspectran.com/catalog/");

        driver.findElement(By.xpath("/html/body/section/div[2]/div[2]/div[2]/div[1]/div/a[1]")).click();
        driver.findElement(By.xpath("/html/body/section/div[2]/div[2]/div[2]/table/tbody/tr[3]/td[1]/a")).click();
        driver.findElement(By.xpath("/html/body/section/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[5]/a")).click();
        String result = driver.findElement(By.xpath("/html/body/section/div[2]/div[2]/div[2]/div[1]/form/table/tbody/tr[3]/td[4]/strong")).getText();
        result = result.substring(1, result.length());

        int foo;
        try {
            foo = Integer.parseInt(result);
        }
        catch (NumberFormatException e){
            foo = 0;
        }

        foo = foo*80;

        System.out.println("Sub Total: "+foo);

        driver.close();
    }
}
