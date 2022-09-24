import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ScenarioTwo {
    ChromeDriver driver;

    public void invokeBrowser() {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
    }
    public void getNthResult(int productNumber) {
        String xpathExpression = String.format("//div[@id=\"srp-river-results\"]/ul/li[%d]", productNumber);
        String product = driver.findElement(By.xpath(xpathExpression)).getText();
        System.out.println(product);
    }

    public void searchProduct(String product, String category) {
        WebElement searchbar;
        WebElement dropdown;
        WebElement searchBtn;

        searchbar = driver.findElement(By.xpath("/html/body/header/table/tbody/tr/td[3]/form/table/tbody/tr/td[1]/div[1]/div/input[1]"));
        searchbar.sendKeys("Apple");

        dropdown = driver.findElement(By.xpath("/html/body/header/table/tbody/tr/td[3]/form/table/tbody/tr/td[2]/div/select"));
        Select categorySelect = new Select(dropdown);
        categorySelect.selectByVisibleText(category);

        searchBtn = driver.findElement(By.xpath("/html/body/header/table/tbody/tr/td[3]/form/table/tbody/tr/td[3]/input"));
        searchBtn.click();

        String results = driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div/div[2]/div[1]/div[1]/h1")).getText();
        System.out.println(results);
    }

    public void getAllProducts() {

    }

    public static void main(String[] args) {
        ScenarioTwo scenarioTwo = new ScenarioTwo();
        scenarioTwo.invokeBrowser();
        scenarioTwo.searchProduct("Apple", "Cell Phones & Accessories");
        scenarioTwo.getNthResult(10);
    }
}
