package workflowModule;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import util.findXpath.PageSource;

import java.util.Set;

public class OperationInDCMtree {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static WindowsDriver<WindowsElement> driver = null;
    public boolean importPlan(String planPath) {
        Reporter.log("---------------------------DCMtree : start to import plan---------------------------");
        PageSource page = new PageSource();
        page.getXpathNameList( driver.getPageSource());
        String fileClickXpath = page.getXpathByName("File");
        org.openqa.selenium.remote.RemoteWebElement fileClickXpathButton = driver.findElementByXPath(fileClickXpath);
        fileClickXpathButton.click();
        Reporter.log("[Button Click] \'File\' Button click in DCMTree window");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.getXpathNameList( driver.getPageSource());
        String addClickXpath = page.getXpathByName("Add...");
        org.openqa.selenium.remote.RemoteWebElement addClickXpathButton = driver.findElementByXPath(addClickXpath);
        addClickXpathButton.click();
        Reporter.log("[Button Click] \'Add...\' Button click in DCMTree window");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.getXpathNameList( driver.getPageSource());
        String fileNameEditClickXpath = page.getXpathByNameAndAttribution("[@ClassName=\"Edit\"][@Name=\"File name:\"]","/Edit");
        org.openqa.selenium.remote.RemoteWebElement fileNameEditXpathText = driver.findElementByXPath(fileNameEditClickXpath);
        fileNameEditXpathText.sendKeys(planPath);
        Reporter.log("[Text Input] Input plan path in Open window");
        String openClickXpath = page.getXpathByNameAndAttribution("[@ClassName=\"Button\"][@Name=\"Open\"]","/Button");
        org.openqa.selenium.remote.RemoteWebElement openClickXpathButton = driver.findElementByXPath(openClickXpath);
        openClickXpathButton.click();
        Reporter.log("[Button Click] \'Open\' Button click in Open window");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fileClickXpathButton.click();
        Reporter.log("[Button Click] \'File\' Button click in DCMTree window");
        page.xpathNameList.clear();
        page.getXpathNameList( driver.getPageSource());
        String transmitClickXpath = page.getXpathByName("Transmit...");
        org.openqa.selenium.remote.RemoteWebElement transmitClickXpathButton = driver.findElementByXPath(transmitClickXpath);
        transmitClickXpathButton.click();
        Reporter.log("[Button Click] \'Transmit...\' Button click in DCMTree window");
        String currentHandle1 = driver.getWindowHandle();
        Set<String> handles1= driver.getWindowHandles();
        for(String handle:handles1 ){
            if (!currentHandle1.equals(handle) ) {
                driver.switchTo().window(handle);
            }
        }
        page.xpathNameList.clear();
        page.getXpathNameList( driver.getPageSource());
        String sendClickXpath = page.getXpathByNameAndAttribution("[@Name=\"Send\"]","/Button");
        org.openqa.selenium.remote.RemoteWebElement sendClickXpathButton = driver.findElementByXPath(sendClickXpath);
        sendClickXpathButton.click();
        Reporter.log("[Button Click] \'Send\' Button click in \'Send DICOM File\' window");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(sendClickXpath.equalsIgnoreCase("can not find xpath"))
            return false;
        else
            return true;
    }
}
