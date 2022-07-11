package driver;

import enums.ConfigProperties;
import exceptions.BrowserInvocationFailedException;
import factories.DriverFactory;
import utils.ReadPropertyFile;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver(){}

    public static void initDriver(){
        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver());
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Please check the browser capabilities",e);
            }
            DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperties.URL));
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
