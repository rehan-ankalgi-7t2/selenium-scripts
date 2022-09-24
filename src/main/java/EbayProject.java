import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EbayProject {
    ChromeDriver driver;
    String url = "https://www.ebay.com/";

    public void invokeBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    public void searchProduct(String product, String category){
        driver.findElement(By.id("gh-ac")).sendKeys(product);

        WebElement dropdown = driver.findElement(By.id("gh-cat"));
        Select selectCategory = new Select(dropdown);
        selectCategory.selectByVisibleText(category);
        driver.findElement(By.id("gh-btn")).click();

        String result = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println("Result :: "+ result);
    }

    public void getNthProduct(int itemNumber){
        String productXpath = String.format("/html/body/div[6]/div[4]/div[2]/div[1]/div[2]/ul/li[%d]", itemNumber);
        String nthProduct = driver.findElement(By.xpath(productXpath)).getText();

        System.out.println("Nth Product :: "+ nthProduct);
    }

    public void getAllProducts(){
        List<WebElement> allProduct = driver.findElements(By.xpath("//div[@id='ResultSetItems']/ul[@id='ListViewInner']/li"));

        for(WebElement product: allProduct){
            System.out.println(product.getText());
            System.out.println("-----------------------------------------");
        }
    }

    public void getAllProductsViaScrollDown(){
        List<WebElement> allProduct = driver.findElements(By.xpath("//div[@id='ResultSetItems']/ul[@id='ListViewInner']/li"));
        Actions action = new Actions(driver);

        for(WebElement product: allProduct){
            action.moveToElement(product).build().perform();
            System.out.println(product.getText());
            System.out.println("-----------------------------------------");
        }
    }

    public void getAllProductsViaScrollDownViaJS(){
        List<WebElement> allProduct = driver.findElements(By.xpath("//div[@id='ResultSetItems']/ul[@id='ListViewInner']/li"));

        for(WebElement product: allProduct){
            int x, y;
            x = product.getLocation().x;
            y = product.getLocation().y;
            scrollDown(x, y);
            System.out.println(product.getText());
            System.out.println("-----------------------------------------");
        }
    }

    private void scrollDown(int x, int y){
        JavascriptExecutor jsEngine;

        String jsCommand = String.format("window.scrollBy(%d,%d)", x,y);

        jsEngine = (JavascriptExecutor) driver;
        jsEngine.executeScript(jsCommand);
    }

    public static void main(String[] args) {
        EbayProject ebayProject = new EbayProject();

        ebayProject.invokeBrowser();
        ebayProject.searchProduct("Apple", "Cell Phones & Accessories");
        ebayProject.getNthProduct(7);
        ebayProject.getAllProducts();
        ebayProject.driver.close();
    }

}
