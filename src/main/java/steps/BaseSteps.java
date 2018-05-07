package steps;

        import cucumber.api.java.After;
        import cucumber.api.java.Before;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import prop.TestProperties;

        import java.util.Properties;
        import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected static WebDriver driver;
    protected static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public static void setUp() throws Exception {
        String browser = properties.getProperty("browser");
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
