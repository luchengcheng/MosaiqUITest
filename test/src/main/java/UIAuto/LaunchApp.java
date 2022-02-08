package UIAuto;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;


public class LaunchApp {
    public static WindowsDriver<WindowsElement> driver = null;
    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    public LaunchApp(){}


    public boolean setUp(String appPath, String waitForAppLaunch, String appName)  {
        Reporter.log("[Launch APP] start to launch "+ appName);
        DesiredCapabilities appCapabilities = new DesiredCapabilities();
        appCapabilities.setCapability("platformName", "Windows");
        appCapabilities.setCapability("deviceName", "WindowsPC");
        appCapabilities.setCapability("automationName", "Windows");
        appCapabilities.setCapability("app", appPath);
        appCapabilities.setCapability("unicodeKeyboard", true);
        appCapabilities.setCapability("resetKeyboard", false);
        appCapabilities.setCapability("ms:waitForAppLaunch", waitForAppLaunch);
        try {
            driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//        logger.info("[Launch APP] "+appName+" launch successfully");
        Reporter.log("[info] "+appName+" launch successfully");
        return true;
    }



}
