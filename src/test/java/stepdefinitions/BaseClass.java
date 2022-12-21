package stepdefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeTest;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    Playwright playwright = Playwright.create();

    // get the browser name from config.properties
    String browserName;
    {
        try {
            browserName = openBrowser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    BrowserType browserType = getBrowserType(playwright, browserName);
    Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));

        private static BrowserType getBrowserType(Playwright playwright, String browserName) {
        switch (browserName) {
            case "chrome":
                return playwright.chromium();
            case "webkit":
                return playwright.webkit();
            case "firefox":
                return playwright.firefox();
            default:
                throw new IllegalArgumentException();
        }
    }

    public String openBrowser() throws IOException {
        Properties properties = init_prop();
        String browserName = properties.getProperty("browser");
        return browserName;
    }

    @BeforeTest
    public Properties init_prop() throws IOException {
        Properties prop=new Properties();
        FileInputStream ip= new FileInputStream("./src/main/resources/config.properties");
        prop.load(ip);
        return prop;
    }
}
