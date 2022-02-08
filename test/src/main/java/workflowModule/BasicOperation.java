package workflowModule;

import Config.HelloMosaiq_Case1;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Reporter;
import util.TestReport.TestingListener;
import util.findXpath.PageSource;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class BasicOperation {
    public static WindowsDriver<WindowsElement> driver = null;
    public static int NumOfMachine =0;
    // TODO Auto-generated method stub:
    //  This Method is to Login MOSAIQ.
    public boolean login(String mosaiq_username, String mosaiq_password) {
        Reporter.log("---------------------------MOSAIQ: start to login---------------------------");
        Reporter.log("[Login MOSAIQ][Button Click] Click \'OK\' Button util login UI show up");
        PageSource page = new PageSource();
        String informationButtonXpath = "";
        do{
            page.getXpathNameList( driver.getPageSource());
            informationButtonXpath = page.getXpathByName("OK");
            try{
                org.openqa.selenium.remote.RemoteWebElement information1Button = driver.findElementByXPath(informationButtonXpath);
                information1Button.click();
            }
            catch(Exception e){

            }
            page.xpathNameList.clear();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(!informationButtonXpath.equalsIgnoreCase("can not find xpath"));
         Reporter.log("[Login MOSAIQ][Info] current it's on \'Login\' UI");
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        page.getXpathAutomationIdList( driver.getPageSource());
        String userLoginXpath = page.getXpathByAutomationId("textEditUsername");
        org.openqa.selenium.remote.RemoteWebElement userLoginText = driver.findElementByXPath(userLoginXpath);
        userLoginText.sendKeys(mosaiq_username);
        Reporter.log("[Login MOSAIQ][Text Input] send username on \'Login\' UI");
        String passwordLoginXpath = page.getXpathByName("PasswordTextEdit");
        org.openqa.selenium.remote.RemoteWebElement passwordLoginText = driver.findElementByXPath(passwordLoginXpath);
        passwordLoginText.sendKeys(mosaiq_password);
        Reporter.log("[Login MOSAIQ][Text Input] send password on \'Login\' UI");
        String buttonLoginXpath = page.getXpathByName("&Login");
        org.openqa.selenium.remote.RemoteWebElement buttonLogin = driver.findElementByXPath(buttonLoginXpath);
        buttonLogin.click();
        String maxWimdowInTitle = page.getXpathByName("Maximize");
        if(!maxWimdowInTitle.equalsIgnoreCase("can not find xpath")){
            org.openqa.selenium.remote.RemoteWebElement maxWimdowInTitleElement = driver.findElementByXPath(maxWimdowInTitle);
            maxWimdowInTitleElement.click();
            Reporter.log("[Login MOSAIQ][Button Click] Click \'MaxWindow\' Button");
        }
        Reporter.log("[Login MOSAIQ][Button Click] Login successfully");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void getScreenShot(String screenshotFileName){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File file =  driver.getScreenshotAs(OutputType.FILE);
        File destination=new File(screenshotFileName);
        try{
            FileUtils.copyFile(file, destination);
        }
        catch(Exception e){

        }
    }

    // TODO Auto-generated method stub:
    //  This Method is to 'Register Patient' in MOSAIQ.
    public boolean registerPatient(String lastName, String firstName, String patientID){
        Reporter.log("---------------------------MOSAIQ : start to register patient---------------------------");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PageSource page = new PageSource();
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String fileLableInTitle = page.getXpathByName("File");
        org.openqa.selenium.remote.RemoteWebElement fileLableInTitleElement = driver.findElementByXPath(fileLableInTitle);
        fileLableInTitleElement.click();
         Reporter.log("[RegisterPatient][Button Click] Click \'File\' Button");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String registerPatientInMenu = page.getXpathByName("Register New Patient...");
        org.openqa.selenium.remote.RemoteWebElement registerPatientInMenuElement = driver.findElementByXPath(registerPatientInMenu);
        registerPatientInMenuElement.click();
         Reporter.log("[RegisterPatient][Button Click] Click \'Register New Patient...\' Button");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // find "New Patient" window
       String currentHandle = driver.getWindowHandle();
       Set<String> handles = driver.getWindowHandles();
        for(String handle:handles ){
            if (!currentHandle.equals(handle) ) {
                driver.switchTo().window(handle);
            }
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathAutomationIdList( driver.getPageSource());
        String patientLastName = page.getXpathByAutomationId("textLastName");
        org.openqa.selenium.remote.RemoteWebElement patientLastNameElement = driver.findElementByXPath(patientLastName);
        patientLastNameElement.sendKeys(lastName);
         Reporter.log("[RegisterPatient][Test Input] input \'Last Name\' for patient");
        String patientFirstName = page.getXpathByAutomationId("textFirstName");
        org.openqa.selenium.remote.RemoteWebElement patientFirstNameElement = driver.findElementByXPath(patientFirstName);
        patientFirstNameElement.sendKeys(firstName);
         Reporter.log("[RegisterPatient][Test Input] input \'First Name\' for patient");
        String patientId = page.getXpathByAutomationId("textIDA");
        org.openqa.selenium.remote.RemoteWebElement patientIdElement = driver.findElementByXPath(patientId);
        patientIdElement.sendKeys(patientID);
         Reporter.log("[RegisterPatient][Test Input] input \'Patient ID\' for patient");
        page.getXpathNameList( driver.getPageSource());
        String physicianName = page.getXpathByName("&Physicians/Diagnosis");
        org.openqa.selenium.remote.RemoteWebElement physicianNameElement = driver.findElementByXPath(physicianName);
        physicianNameElement.click();
         Reporter.log("[RegisterPatient][Button Click] Click \'&Physicians/Diagnosis\' Button");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.getXpathAutomationIdList( driver.getPageSource())        ;
        String attendPhysicianEdit = page.getXpathByAutomationId("inputAttendingPhysician");
        String attendPhysicianEditButton = attendPhysicianEdit+"/Button[@LocalizedControlType=\"button\"]";
        org.openqa.selenium.remote.RemoteWebElement attendPhysicianEditButtonElement = driver.findElementByXPath(attendPhysicianEditButton);
        attendPhysicianEditButtonElement.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String physicianSelect = page.getXpathByName("Row 1");
        org.openqa.selenium.remote.RemoteWebElement physicianSelectElement = driver.findElementByXPath(physicianSelect);
        physicianSelectElement.click();
         Reporter.log("[RegisterPatient][Button Click] Click the first one \'Physicians\' ");
        String selectButton = page.getXpathByNameAndAttribution("[@Name=\"Select\"]","/Button");
        org.openqa.selenium.remote.RemoteWebElement selectButtonElement = driver.findElementByXPath(selectButton);
        selectButtonElement.click();
         Reporter.log("[RegisterPatient][Button Click] Click \'Select\' Button in \'Select Physicians\' window");
        String saveButton = page.getXpathByName("Save");
        org.openqa.selenium.remote.RemoteWebElement saveButtonElement = driver.findElementByXPath(saveButton);
        saveButtonElement.click();
         Reporter.log("[RegisterPatient][Button Click] Click \'Save\' Button in \'Select Physicians\' window");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String noButton = page.getXpathByNameAndAttribution("[@Name=\"&No\"]","/Button");
        org.openqa.selenium.remote.RemoteWebElement noButtonElement = driver.findElementByXPath(noButton);
        noButtonElement.click();
         Reporter.log("[RegisterPatient][Button Click] Click \'No\' Button in \'No Duplicate Patients Found\' window");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void importTreatmentPlan(String planPath){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> handles = driver.getWindowHandles();
        if(handles.size()==1)
                driver.switchTo().window(handles.iterator().next());
        PageSource page = new PageSource();
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String fileLableInTitle = page.getXpathByName("File");
        org.openqa.selenium.remote.RemoteWebElement fileLableInTitleElement = driver.findElementByXPath(fileLableInTitle);
        fileLableInTitleElement.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String importInMenu = page.getXpathByName("Import/Export");
        org.openqa.selenium.remote.RemoteWebElement importInMenuElement = driver.findElementByXPath(importInMenu);
        importInMenuElement.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String importPlanInMenu = page.getXpathByName("Ion Plan Import...");
        org.openqa.selenium.remote.RemoteWebElement importPlanInMenuElement = driver.findElementByXPath(importPlanInMenu);
        importPlanInMenuElement.click();
    }

    // TODO Auto-generated method stub:
    //  This Method is to finish 'Plan Promote' in MOSAIQ.
    public void promotePlan(){
         Reporter.log("---------------------------MOSAIQ : start to Promote Plan---------------------------");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for(String handle:handles ){
            if (!currentHandle.equals(handle) ) {
                driver.switchTo().window(handle);
            }
        }
        PageSource page = new PageSource();
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String DAndIButton = page.getXpathByNameAndAttribution("[@Name=\"D and I\"]","/Button");
        org.openqa.selenium.remote.RemoteWebElement DAndIButtonElement = driver.findElementByXPath(DAndIButton);
        DAndIButtonElement.click();
         Reporter.log("[Promote Plan][Button Click] Click \'D and I\' Button");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String promoteButton = page.getXpathByNameAndAttribution("[@Name=\"Promote\"]","/Button");
        org.openqa.selenium.remote.RemoteWebElement promoteButtonElement = driver.findElementByXPath(promoteButton);
        promoteButtonElement.click();
         Reporter.log("[Promote Plan][Button Click] Click \'Promote\' Button");
    }

    // TODO Auto-generated method stub:
    //  This Method is to select patient when the patient exists.
    public boolean selectPatient(String patientName){
         Reporter.log("---------------------------MOSAIQ : start to Select Patient when the patient exists---------------------------");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PageSource page = new PageSource();
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        String fileLableInTitle = page.getXpathByName("File");
        org.openqa.selenium.remote.RemoteWebElement fileLableInTitleElement = driver.findElementByXPath(fileLableInTitle);
        fileLableInTitleElement.click();
         Reporter.log("[SelectPatient][Button Click] Click \'File\' Button");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String patientInList = page.getXpathByName(patientName);
        org.openqa.selenium.remote.RemoteWebElement patientInListElement = driver.findElementByXPath(patientInList);
        patientInListElement.click();
         Reporter.log("[SelectPatient][Button Click] Click Patient Name Item");
         return true;
    }

    // TODO Auto-generated method stub:
    //  This Method is to add machine in File-Directories-Location Directory.
    public boolean addMachineInLocationDirectory(String machineName) {
        Reporter.log("---------------------------MOSAIQ : start to add machine in Location Directory---------------------------");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().window(driver.getWindowHandle());
        PageSource page = new PageSource();
        System.out.println(driver.getCapabilities());
        page.getXpathNameList( driver.getPageSource());
        String fileLableInTitle = page.getXpathByName("File");
        org.openqa.selenium.remote.RemoteWebElement fileLableInTitleElement = driver.findElementByXPath(fileLableInTitle);
        fileLableInTitleElement.click();
         Reporter.log("[Add Machine In Location Directory][Button Click] Click \'File\' Button");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String directorisInMenu = page.getXpathByName("Directories");
        org.openqa.selenium.remote.RemoteWebElement directorisElement = driver.findElementByXPath(directorisInMenu);
        directorisElement.click();
         Reporter.log("[Add Machine In Location Directory][Button Click] Click \'Directories\' BUtton");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String locationDirectorisInMenu = page.getXpathByName("Location Directory...");
        org.openqa.selenium.remote.RemoteWebElement locationDirectorisInMenuElement = driver.findElementByXPath(locationDirectorisInMenu);
        locationDirectorisInMenuElement.click();
         Reporter.log("[Add Machine In Location Directory][Button Click] Click \'Location Directory...\' BUtton");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for(String handle:handles ){
            if (!currentHandle.equals(handle) ) {
                driver.switchTo().window(handle);
            }
        }
        ArrayList<String> machineList = machineListInLocation(page);
        NumOfMachine = machineList.indexOf(machineName);
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        if(!machineList.contains(machineName)){
            Reporter.log("[Add Machine In Location Directory] need to add machine "+machineName);
            String addButton = page.getXpathByName("Add");
            org.openqa.selenium.remote.RemoteWebElement addButtonElement = driver.findElementByXPath(addButton);
            addButtonElement.click();
             Reporter.log("[Add Machine In Location Directory][Button Click] Click \'Add\' BUtton");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            page.xpathNameList.clear();
            page.xpathAutomationIdList.clear();
            page.getXpathNameList(driver.getPageSource());
            page.getXpathAutomationIdList( driver.getPageSource());
            String nameText = page.getXpathByAutomationId("textEditName");
            org.openqa.selenium.remote.RemoteWebElement nameTextElement = driver.findElementByXPath(nameText);
            nameTextElement.sendKeys(machineName);
            Reporter.log("[Add Machine In Location Directory][Input Text] Input machine name");
            String categorySelect = page.getXpathByAutomationIdAndAttribution("lookUpCategory","/Edit");
            org.openqa.selenium.remote.RemoteWebElement categorySelectElement = driver.findElementByXPath(categorySelect);
            categorySelectElement.sendKeys("Accelerator");
            Reporter.log("[Add Machine In Location Directory][Input Text] Input machine category");
            String typeSelect = page.getXpathByAutomationIdAndAttribution("lookUpType","/Edit");
            org.openqa.selenium.remote.RemoteWebElement typeSelectElement = driver.findElementByXPath(typeSelect);
            typeSelectElement.sendKeys("Radiation Oncology");
             Reporter.log("[Add Machine In Location Directory][Input Text] Input machine type");
            String saveButton = page.getXpathByName("Save");
            org.openqa.selenium.remote.RemoteWebElement saveButtonElement = driver.findElementByXPath(saveButton);
            saveButtonElement.click();
             Reporter.log("[Add Machine In Location Directory][Button Click] Click \'Save\' Button");
            TestingListener.driver = driver;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            page.xpathNameList.clear();
            page.xpathAutomationIdList.clear();
            page.getXpathNameList(driver.getPageSource());
            String closeButton = page.getXpathByName("Close");
            org.openqa.selenium.remote.RemoteWebElement closeButtonElement = driver.findElementByXPath(closeButton);
            closeButtonElement.click();
             Reporter.log("[Add Machine In Location Directory][Button Click] Click \'Close\' Button");
        }
        else{
             Reporter.log("[Add Machine In Location Directory] machine "+machineName+"has existed.");
            String closeButton = page.getXpathByName("Close");
            org.openqa.selenium.remote.RemoteWebElement closeButtonElement = driver.findElementByXPath(closeButton);
            closeButtonElement.click();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    // TODO Auto-generated method stub:
    //  This Method is to output all machines in File-Directories-Location Directory.
    public ArrayList<String> machineListInLocation(PageSource page){
        ArrayList<String> machineList = new ArrayList<String>();
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        String machine = "";
        int i=0;
        do {
            machine = page.getXpathByName("Machine row "+i);
            if(!machine.equalsIgnoreCase("can not find xpath")){
                 org.openqa.selenium.remote.RemoteWebElement machineListElement = driver.findElementByXPath(machine);
                 machineList.add(machineListElement.getText());}
            i++;
        }while(!machine.equalsIgnoreCase("can not find xpath"));
        System.out.println("");
        return machineList;
    }

//    // TODO Auto-generated method stub:
//    //  This Method is to output all machines in File-System Utilities-Mahcine Characterization.
//    public ArrayList<String> machineListInMachineCharacterization(PageSource page){
//        ArrayList<String> machineList = new ArrayList<String>();
//        page.xpathNameList.clear();
//        page.xpathAutomationIdList.clear();
//        page.getXpathByName(driver.getPageSource());
//        page.getXpathAutomationIdList(driver.getPageSource());
//        String thumbMachine = page.getXpathByAutomationId("DownPageButton");
//        org.openqa.selenium.remote.RemoteWebElement thumbMachineElement = driver.findElementByXPath(thumbMachine);
//        thumbMachineElement.sendKeys("ttttttt");
//        thumbMachineElement.click();
//        thumbMachineElement.getLocation();
//        String machine =   thumbMachineElement.getText();
////        page.xpathNameList.clear();
////        page.xpathAutomationIdList.clear();
////        page.getXpathByName(driver.getPageSource());
//
//        return machineList;
//    }

    // TODO Auto-generated method stub:
    //  This Method is to update/add machine characterization.
    public boolean updateMachineCharacterization(String machineName) {
         Reporter.log("---------------------------MOSAIQ : start to add machine characterization---------------------------");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!currentHandle.equals(handle)) {
                driver.switchTo().window(handle);
            }
        }
        PageSource page = new PageSource();
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        String maxWimdowInTitle = page.getXpathByName("Maximize");
        if(!maxWimdowInTitle.equalsIgnoreCase("can not find xpath")){
            org.openqa.selenium.remote.RemoteWebElement maxWimdowInTitleElement = driver.findElementByXPath(maxWimdowInTitle);
            maxWimdowInTitleElement.click();
             Reporter.log("[Machine Characterization][Button Click] Click \'MaxWindow\' Button");
        }
        String fileLableInTitle = page.getXpathByName("File");
        org.openqa.selenium.remote.RemoteWebElement fileLableInTitleElement = driver.findElementByXPath(fileLableInTitle);
        fileLableInTitleElement.click();
         Reporter.log("[Machine Characterization][Button Click] Click \'File\' Button");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        String systemUtilitiesInMenu = page.getXpathByName("System Utilities");
        org.openqa.selenium.remote.RemoteWebElement systemUtilitiesInMenuElement = driver.findElementByXPath(systemUtilitiesInMenu);
        systemUtilitiesInMenuElement.click();
         Reporter.log("[Machine Characterization][Button Click] Click \'System Utilities\' Button");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        String machineCharacterizationInMenu = page.getXpathByName("Machine Characterization...");
        org.openqa.selenium.remote.RemoteWebElement machineCharacterizationInMenuElement = driver.findElementByXPath(machineCharacterizationInMenu);
        machineCharacterizationInMenuElement.click();
         Reporter.log("[Add Machine In Location Directory][Button Click] Click \'Machine Characterization...\' BUtton");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentHandle = driver.getWindowHandle();
        handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!currentHandle.equals(handle)) {
                driver.switchTo().window(handle);
            }
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        String addButton = page.getXpathByName("Add");
        org.openqa.selenium.remote.RemoteWebElement addButtonElement = driver.findElementByXPath(addButton);
        addButtonElement.click();
         Reporter.log("[Machine Characterization][Button Click] Click \'Add\' Button");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentHandle = driver.getWindowHandle();
        handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!currentHandle.equals(handle)) {
                driver.switchTo().window(handle);
            }
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        page.getXpathAutomationIdList(driver.getPageSource());
        String typeText = page.getXpathByName("[@ClassName=\"ClaDrop_01000000H\"][@Name=\"Type:\"]");
        org.openqa.selenium.remote.RemoteWebElement typeTextElement = driver.findElementByXPath(typeText);
        typeTextElement.click();
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);// Here is KeyEvent.VK_DOWN rather than KeyEvent.VK_PAGE_DOWN
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_DOWN);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        String machineText = page.getXpathByName("[@ClassName=\"ClaDrop_01000000H\"][@Name=\"Machine:\"]");
        org.openqa.selenium.remote.RemoteWebElement machineTextElement = driver.findElementByXPath(machineText);
        machineTextElement.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        for(int i=0;i<=5;i++){  // TODO; it should be NumOfMachine.
              robot.keyPress(KeyEvent.VK_DOWN);// Here is KeyEvent.VK_DOWN rather than KeyEvent.VK_PAGE_DOWN
              robot.keyRelease(KeyEvent.VK_DOWN);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
         Reporter.log("[Machine Characterization][Choose Machine] choose machine");
        String allButton = page.getXpathByName("All");
        org.openqa.selenium.remote.RemoteWebElement allButtonElement = driver.findElementByXPath(allButton);
        allButtonElement.click();
         Reporter.log("[Machine Characterization][Button Click] Click button \'All\'");
        String okButton = page.getXpathByName("OK");
        org.openqa.selenium.remote.RemoteWebElement okButtonElement = driver.findElementByXPath(okButton);
        okButtonElement.click();
         Reporter.log("[Machine Characterization][Button Click] Click button \'OK\'");
        String importButton = page.getXpathByName("Import");
        org.openqa.selenium.remote.RemoteWebElement importButtonElement = driver.findElementByXPath(importButton);
        importButtonElement.click();
         Reporter.log("[Machine Characterization][Button Click] Click button \'Import\'");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentHandle = driver.getWindowHandle();
        handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!currentHandle.equals(handle)) {
                driver.switchTo().window(handle);
            }
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        page.getXpathAutomationIdList(driver.getPageSource());
        String macPathEdit = page.getXpathByNameAndAttribution("Path:","/Edit");
        org.openqa.selenium.remote.RemoteWebElement macPathEditElement = driver.findElementByXPath(macPathEdit);
        ForSendKeys(macPathEditElement, HelloMosaiq_Case1.CaseRootPath);
        macPathEditElement.clear();
        macPathEditElement.sendKeys(HelloMosaiq_Case1.CaseRootPath);
         Reporter.log("[Machine Characterization][Input Text] Input MAC file path");
        String spaceClick = page.getXpathByAutomationId("16398");
        org.openqa.selenium.remote.RemoteWebElement spaceClickElement = driver.findElementByXPath(spaceClick);
        spaceClickElement.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        page.getXpathAutomationIdList(driver.getPageSource());
        String fileClick = page.getXpathByAutomationIdAndAttribution("16393","/Pane");
        org.openqa.selenium.remote.RemoteWebElement fileClickElement = driver.findElementByXPath(fileClick);
        fileClickElement.click();
        robot.keyPress(KeyEvent.VK_DOWN);// Here is KeyEvent.VK_DOWN rather than KeyEvent.VK_PAGE_DOWN
        robot.keyRelease(KeyEvent.VK_DOWN);
        String okClick = page.getXpathByName("OK");
        org.openqa.selenium.remote.RemoteWebElement okClickElement = driver.findElementByXPath(okClick);
        okClickElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String changeButton = page.getXpathByName("Change");
        org.openqa.selenium.remote.RemoteWebElement changeButtonElement = driver.findElementByXPath(changeButton);
        changeButtonElement.click();
         Reporter.log("[Machine Characterization][Button Click] Click button \'Change\'");
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        page.getXpathAutomationIdList(driver.getPageSource());
        String informationButtonXpath = page.getXpathByName("OK");
        org.openqa.selenium.remote.RemoteWebElement informationButtonXpathElement = driver.findElementByXPath(informationButtonXpath);
        informationButtonXpathElement.click();

        String machinetemplateName="";
        int count=0;
        do{
//            click reference;
            currentHandle = driver.getWindowHandle();
            handles = driver.getWindowHandles();
            for (String handle : handles) {
                if (!currentHandle.equals(handle)) {
                    driver.switchTo().window(handle);
                }
            }
                page.xpathNameList.clear();
                page.xpathAutomationIdList.clear();
                page.getXpathNameList(driver.getPageSource());
                page.getXpathAutomationIdList(driver.getPageSource());
                String referenceButton = page.getXpathByNameAndAttribution("Reference","/Button");
                org.openqa.selenium.remote.RemoteWebElement referenceButtonElement = driver.findElementByXPath(referenceButton);
                referenceButtonElement.click();
                 Reporter.log("[Machine Characterization][Button Click] Click button \'Reference\'");
            Robot keyboard = null;
            try {
                keyboard = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            for(int i=0;i<=count;i++) {
                    keyboard.keyPress(KeyEvent.VK_DOWN);
                    keyboard.keyRelease(KeyEvent.VK_DOWN);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                count++;
                 machinetemplateName = currentTemplateName(page);
                 System.out.println("Current Template is "+machinetemplateName);
        }while(!machinetemplateName.equalsIgnoreCase(machineName));
        //delete all
        String deleteAllButton = page.getXpathByAutomationIdAndAttribution("16441","/Button");   //????
        org.openqa.selenium.remote.RemoteWebElement deleteAllButtonElement = driver.findElementByXPath(deleteAllButton);
        deleteAllButtonElement.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //copy all
        String copyAllButton = page.getXpathByAutomationIdAndAttribution("16435","/Button");   //????
        org.openqa.selenium.remote.RemoteWebElement copyAllButtonElement = driver.findElementByXPath(copyAllButton);
        copyAllButtonElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String okChangeMachineButton = page.getXpathByName("OK");   //????
        org.openqa.selenium.remote.RemoteWebElement okChangeMachineButtonElement = driver.findElementByXPath(okChangeMachineButton);
        okChangeMachineButtonElement.click();
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList( driver.getPageSource());
        page.getXpathAutomationIdList(driver.getPageSource());
        informationButtonXpath = page.getXpathByName("OK");
        informationButtonXpathElement = driver.findElementByXPath(informationButtonXpath);
        informationButtonXpathElement.click();

        String closeButton = page.getXpathByName("Close");   //????
        org.openqa.selenium.remote.RemoteWebElement closeButtonElement = driver.findElementByXPath(closeButton);
        closeButtonElement.click();
        return true;
    }


    public static void ForSendKeys(RemoteWebElement element, String content){
        for (int i = 0; i < content.length(); i++) {
            element.sendKeys(content.charAt(i)+"");
        }
    }

    public String currentTemplateName(PageSource page){
        String machineTemplateName = "";
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!currentHandle.equals(handle)) {
                driver.switchTo().window(handle);
            }
        }
        page.xpathNameList.clear();
        page.xpathAutomationIdList.clear();
        page.getXpathNameList(driver.getPageSource());
        page.getXpathAutomationIdList(driver.getPageSource());
        String currentReferenceType = page.getXpathByAutomationIdAndAttribution("16445","/Edit");   //????
        org.openqa.selenium.remote.RemoteWebElement currentReferenceTypeElement = driver.findElementByXPath(currentReferenceType);
        machineTemplateName = currentReferenceTypeElement.getText();
       return machineTemplateName;
    }





}
