package constants;

public class FrameworkConstants {

    private FrameworkConstants(){}

    private static String userDir = "user.dir";
    private static final String CONFIGFILEPATH = System.getProperty(userDir)+"/src/test/resources/config/config.properties";
    private static final String SELENIUMGRIDURL="http://localhost:4444/wd/hub";
    private static final int SHADOWWAITINGTIME= 20;
    private static final int SHADOWPOLLINGTIME = 2;

    public static String getConfigfilepath() {
        return CONFIGFILEPATH;
    }

    public static String getSeleniumGridUrl() {
        return SELENIUMGRIDURL;
    }

    public static int getShadowWaitingTime() {
        return SHADOWWAITINGTIME;
    }

    public static int getShadowPollingTime() {
        return SHADOWPOLLINGTIME;
    }
}
