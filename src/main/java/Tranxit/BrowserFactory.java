package Tranxit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

//    public static WebDriver getBrowser() {
//        WebDriver driver = null;
//        String browserName = System.getProperty("BROWSER");
//        DesiredCapabilities capabilities;
//
//        if (browserName.equalsIgnoreCase("chrome"))
//            capabilities = DesiredCapabilities.chrome();
//
//        else if (browserName.equalsIgnoreCase("firefox"))
//            capabilities = DesiredCapabilities.firefox();
//        else
//            capabilities = DesiredCapabilities.chrome();
//
//        try {
//            driver = new RemoteWebDriver(new URL("http://Localhost:9515"), capabilities);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//
//
//        return driver;
//    }

    public static final String USERNAME = "sara.vardini";
    public static final String ACCESS_KEY = "8c53a1db-6a76-492d-9047-874e9f2d8d79";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

    static WebDriver driver = null;

    public static WebDriver getBrowser() {
        if (driver != null) {
            return driver;
        } else {
            String browserName = System.getProperty("BROWSER");
            System.out.println("browsername" + browserName);
            DesiredCapabilities caps;

            if (browserName.equalsIgnoreCase("chrome")) {

                caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "64.0");
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "51.0");
            } else if (browserName.equalsIgnoreCase("Edge")) {
                caps = DesiredCapabilities.edge();
                caps.setCapability("InPrivate", true);
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "16.16299");
            }else {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1920,1080");
                caps = DesiredCapabilities.chrome();
                caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
           }
            try {
                driver = new RemoteWebDriver(new URL(URL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
        return driver;
    }
}