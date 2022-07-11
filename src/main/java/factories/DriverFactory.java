package factories;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ReadPropertyFile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        WebDriver driver = null;
        String runmode = ReadPropertyFile.getValue(ConfigProperties.RUNMODE);
        String browser = ReadPropertyFile.getValue(ConfigProperties.BROWSER);
        final String REMOTE = "remote";
        final String LOCAL = "local";

        if (browser.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase(REMOTE)) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL(FrameworkConstants.getSeleniumGridUrl()), cap);
            } else if (runmode.equalsIgnoreCase(LOCAL)) {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Nexus 5");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (runmode.equalsIgnoreCase(REMOTE)) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.FIREFOX);
                driver = new RemoteWebDriver(new URL(FrameworkConstants.getSeleniumGridUrl()), cap);
            } else if (runmode.equalsIgnoreCase(LOCAL)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }  else if (browser.equalsIgnoreCase("edge")) {
            if (runmode.equalsIgnoreCase(REMOTE)) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.EDGE);
                driver = new RemoteWebDriver(new URL(FrameworkConstants.getSeleniumGridUrl()), cap);
            } else if (runmode.equalsIgnoreCase(LOCAL)) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        return driver;
    }

}
