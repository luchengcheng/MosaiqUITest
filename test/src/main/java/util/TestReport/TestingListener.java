package util.TestReport;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class TestingListener extends TestListenerAdapter {

    public static WindowsDriver<WindowsElement> driver;

    @Override
    public  void onTestFailure(ITestResult tr) {
        if(!tr.getName().equalsIgnoreCase("closeApp")) {
            super.onTestFailure(tr);
            try {
                takeScreenShot(tr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public  void onTestSuccess(ITestResult tr) {
        if(!tr.getName().equalsIgnoreCase("closeApp"))
        {
        super.onTestSuccess(tr);
        try {
            takeScreenShot(tr);
        } catch (IOException e) {
            e.printStackTrace();
        }}
        else
            super.onTestSuccess(tr);
    }


    public  String takeScreenShot(ITestResult tr) throws IOException{
        SimpleDateFormat smf = new SimpleDateFormat("MMddHHmmss") ;
        String curTime = smf.format(new java.util.Date());
        String fileName = tr.getName()+"_"+curTime+".png";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //把截图拷贝到自定义的目录
        String currentPath = System.getProperty("user.dir");
        String imgfile = currentPath+"\\test-output\\"+fileName;
        FileUtils.copyFile(srcFile, new File(imgfile));
        tr.setAttribute("picturePath",imgfile);
        return  imgfile;
        /**
         * 注意截图存放路径先不要随意修改，否则会影响报告中图片的显示。
         * 当然如果你会调试，可以自定义设置。
         */

    }

    public void addScreenCaptureFromPath(ITestResult iTestResult, ExtentTest test) throws IOException {
        String path = (String) iTestResult.getAttribute("picturePath");
        test.addScreenCaptureFromPath(path);
    }

}
