import org.openqa.selenium.chrome.ChromeDriver;

public class PrintTitleUrl {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");

        String title;
        String urlString;

        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://demo.opencart.com/");

        title = chromeDriver.getTitle();
        urlString = chromeDriver.getCurrentUrl();

        System.out.println("title of the page: "+title);
        System.out.println("url of the page: "+urlString);

        chromeDriver.close();

    }
}
