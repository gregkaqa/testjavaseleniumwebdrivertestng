import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver; //poprawnie zaimprtowało nam to z mavena
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.testng.annotations.AfterSuite;
        import org.testng.annotations.BeforeSuite;
        import org.testng.annotations.Test;

        import java.net.MalformedURLException;
        import java.net.URL;

public class Test1 {
    /**/
    public WebDriver driver;
    public RemoteWebDriver drivero;
    public String RemoteURL = "http://localhost:4444/wd/hub/";
    public boolean chrome = true;

    /*adnotacja przed zestawie testów suite to zestaw testów robimy metode ktora cos robi przed testami*/
    @BeforeSuite
    public void przedTestami() throws MalformedURLException {
        if (chrome) {
            //WebDriverManager.chromedriver().avoidAutoVersion();
            //WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();
            DesiredCapabilities capa = DesiredCapabilities.chrome();
            // ChromeOptions chrome = new ChromeOptions();
            capa.setBrowserName("chrome");
           // capa.setCapability("headless", false);
            drivero = new RemoteWebDriver(new URL(RemoteURL), capa);
        } else {
           /* WebDriverManager.firefoxdriver().avoidAutoVersion();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();*/
            DesiredCapabilities capa =  DesiredCapabilities.firefox();
            capa.setBrowserName("firefox");
           // capa.setCapability("headless", false);
           // capa.setCapability("version", "latest");

           // capa.setVersion("70.0");
            drivero = new RemoteWebDriver(new URL(RemoteURL), capa);
        }
    }

    /*adnotacja po zestawie testów suite to zestaw testów robimy metode ktora cos robi po testach*/
    @AfterSuite
    public void poTestach() {
        drivero.close();
    }

    /*właściwe testy*/
    @Test
    public void pierwszyTest() throws InterruptedException {
        //boolean chrome = false;
       /* driver.get("http://www.bing.com");
        driver.findElement(By.id("sb_form_q")).sendKeys("pogoda warszawa");
        driver.findElement(By.id("sb_form_go")).click();*/
        drivero.get("http://www.bing.com");
        drivero.findElement(By.id("sb_form_q")).sendKeys("pogoda warszawa");
        drivero.findElement(By.id("sb_form_go")).click();
        Thread.sleep(5000);
    }

    @Test
    public void drugiTest() throws InterruptedException {
        //boolean chrome = false;
        if (chrome) {
           /* driver.get("http://duckduckgo.com/");
            driver.findElement(By.id("search_form_input_homepage")).sendKeys("pogoda gdańsk");
            driver.findElement(By.id("search_button_homepage")).click();*/
            drivero.get("http://duckduckgo.com/");
            drivero.findElement(By.id("search_form_input_homepage")).sendKeys("pogoda gdańsk");
            drivero.findElement(By.id("search_button_homepage")).click();
            Thread.sleep(5000);
        }
    }
}