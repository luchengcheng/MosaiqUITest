package UIAuto.HelloMosaiq;
import ImpacUpdate.ImpacFileOperation;
import UIAuto.LaunchApp;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.TestReport.TestingListener;
import util.parserDicom.InfoFromDICOM;
import workflowModule.BasicOperation;
import workflowModule.OperationInDCMtree;



public class HelloMosaiq_Case1 {
    public static WindowsDriver<WindowsElement> mosaiq_driver = null;
    public static WindowsDriver<WindowsElement> dcmTree_driver = null;
    public static WindowsDriver<WindowsElement> dcmWin_driver = null;
    public static WindowsDriver<WindowsElement> wqeService_driver = null;
    InfoFromDICOM plan = new InfoFromDICOM();

    @BeforeTest()
    public void setup(){
        LaunchApp trial = new LaunchApp();
        boolean isLaunched = trial.setUp(Config.HelloMosaiq_Case1.RootRunPath+"\\"+ Config.HelloMosaiq_Case1.MOSAIQExeFileName, "15", Config.HelloMosaiq_Case1.MOSAIQExeFileName );
        mosaiq_driver = trial.driver;
        Assert.assertTrue(isLaunched);
    }

    @Test
    public void Login(){
        BasicOperation basicOperation = new BasicOperation();
        basicOperation.driver = mosaiq_driver;
        boolean isLogin = basicOperation.login(Config.HelloMosaiq_Case1.MOSAIQ_Username, Config.HelloMosaiq_Case1.MOSAIQ_Password);
        TestingListener.driver = mosaiq_driver;
        Assert.assertTrue(isLogin);
    }

    @Test
    public void RegisterPatient(){
        BasicOperation basicOperation = new BasicOperation();
        basicOperation.driver = mosaiq_driver;
        plan.getDcmObject(Config.HelloMosaiq_Case1.TestPlanPath);
        boolean isRegister = basicOperation.registerPatient(plan.getPatientLastName(),plan.getPatientFirstName(), plan.getPatientPlanMR());
        TestingListener.driver = mosaiq_driver;
        Assert.assertTrue(isRegister);
    }

    @Test
    public void SelectPatient(){
        BasicOperation basicOperation = new BasicOperation();
        basicOperation.driver = mosaiq_driver;
        plan.getDcmObject(Config.HelloMosaiq_Case1.TestPlanPath);
        boolean isSelectPatient =  basicOperation.selectPatient(plan.getPatientLastName()+", "+plan.getPatientFirstName()); // if patient exists
        TestingListener.driver = mosaiq_driver;
        Assert.assertTrue(isSelectPatient);
    }

    @Test
    public void ImportPlan(){
        LaunchApp dcmwin = new LaunchApp();
        dcmwin.setUp(Config.HelloMosaiq_Case1.RootRunPath+"\\"+ Config.HelloMosaiq_Case1.DcmWinExeFileName, "5", Config.HelloMosaiq_Case1.DcmWinExeFileName);
        dcmWin_driver = dcmwin.driver;
        LaunchApp wqeService = new LaunchApp();
        wqeService.setUp(Config.HelloMosaiq_Case1.RootRunPath+"\\x64\\"+ Config.HelloMosaiq_Case1.WQEServiceExeFileName,"15", Config.HelloMosaiq_Case1.WQEServiceExeFileName);
        wqeService_driver = wqeService.driver;
        LaunchApp dcmtree = new LaunchApp();
        dcmtree.setUp(Config.HelloMosaiq_Case1.RootRunPath+"\\"+ Config.HelloMosaiq_Case1.DcmTreeExeFileName,"5", Config.HelloMosaiq_Case1.DcmTreeExeFileName);
        dcmTree_driver = dcmtree.driver;
        OperationInDCMtree operationInDCMtree =new OperationInDCMtree();
        operationInDCMtree.driver = dcmtree.driver;
        boolean isImported = operationInDCMtree.importPlan(Config.HelloMosaiq_Case1.TestPlanPath);
        TestingListener.driver = dcmWin_driver;
        Assert.assertTrue(isImported);
    }

    @Test
    public void AddMachineInLocation(){
        BasicOperation basicOperation = new BasicOperation();
        basicOperation.driver = mosaiq_driver;
        boolean isAddedInLocation =  basicOperation.addMachineInLocationDirectory(Config.HelloMosaiq_Case1.MachineName);
        Assert.assertTrue(isAddedInLocation);
    }

    @Test
    public void UpdateMachineCharacterization(){
        BasicOperation basicOperation = new BasicOperation();
        basicOperation.driver = mosaiq_driver;
        boolean isUpdateCharacterization = basicOperation.updateMachineCharacterization(Config.HelloMosaiq_Case1.MachineName);
        TestingListener.driver = mosaiq_driver;
        Assert.assertTrue(isUpdateCharacterization);
    }

    @Test
    public void UpdateImpac(){
        ImpacFileOperation impacFileOperation = new ImpacFileOperation();
        impacFileOperation.UpdateImpacData();
        Reporter.log("[Impac.ini] Before updating impac.ini");
        impacFileOperation.readIni(Config.HelloMosaiq_Case1.ImpacFilePath);
        impacFileOperation.updateIniFile();
    }

    @AfterTest
    public void closeApp(){
        if(mosaiq_driver!=null)
            mosaiq_driver.closeApp();
//        if(dcmWin_driver!=null)
//            dcmWin_driver.close();
//        if(dcmTree_driver!=null)
//            dcmTree_driver.close();
//        if(wqeService_driver!=null)
//            wqeService_driver.close();
    }



    public static void main(String[] args)  {
        Reporter.log("---------------------------Update Impac.ini"+"---------------------------");
        ImpacFileOperation impacFileOperation = new ImpacFileOperation();
        impacFileOperation.UpdateImpacData();
        Reporter.log("[Impac.ini] Before updating impac.ini");
        impacFileOperation.readIni(Config.HelloMosaiq_Case1.ImpacFilePath);
        impacFileOperation.updateIniFile();
        Reporter.log("[Impac.ini] After updating impac.ini");
        impacFileOperation.readIni(Config.HelloMosaiq_Case1.ImpacFilePath);
        Reporter.log("---------------------------Launch Mosaiq, version is "+ Config.HelloMosaiq_Case1.MOSAIQ_Version+"---------------------------");
        LaunchApp trial = new LaunchApp();
        trial.setUp(Config.HelloMosaiq_Case1.RootRunPath+"\\"+ Config.HelloMosaiq_Case1.MOSAIQExeFileName, "25", Config.HelloMosaiq_Case1.MOSAIQExeFileName );
        BasicOperation basicOperation = new BasicOperation();
        basicOperation.driver = trial.driver;
        basicOperation.login(Config.HelloMosaiq_Case1.MOSAIQ_Username, Config.HelloMosaiq_Case1.MOSAIQ_Password);
        basicOperation.getScreenShot("./Data/screenshot/login.png");
        InfoFromDICOM plan = new InfoFromDICOM();
        plan.getDcmObject(Config.HelloMosaiq_Case1.TestPlanPath);
        basicOperation.selectPatient(plan.getPatientLastName()+", "+plan.getPatientFirstName()); // if patient exists
        basicOperation.getScreenShot("./Data/screenshot/selectPatient.png");
        basicOperation.addMachineInLocationDirectory(Config.HelloMosaiq_Case1.MachineName);
        basicOperation.updateMachineCharacterization(Config.HelloMosaiq_Case1.MachineName);
        basicOperation.registerPatient(plan.getPatientLastName(),plan.getPatientFirstName(), plan.getPatientPlanMR());
        basicOperation.getScreenShot("./Data/screenshot/registerPatient.png");
//        importDICOMPlan();
        basicOperation.promotePlan();
    }

//    public static boolean  importDICOMPlan() {
//    // TODO Auto-generated method stub
//        LaunchApp dcmwin = new LaunchApp();
//        dcmwin.setUp(Config.HelloMosaiq_Case1.RootRunPath+"\\"+ Config.HelloMosaiq_Case1.DcmWinExeFileName, "5", Config.HelloMosaiq_Case1.DcmWinExeFileName);
//        LaunchApp wqeService = new LaunchApp();
//        wqeService.setUp(Config.HelloMosaiq_Case1.RootRunPath+"\\x64\\"+ Config.HelloMosaiq_Case1.WQEServiceExeFileName,"25", Config.HelloMosaiq_Case1.WQEServiceExeFileName);
//        LaunchApp dcmtree = new LaunchApp();
//        dcmtree.setUp(Config.HelloMosaiq_Case1.RootRunPath+"\\"+ Config.HelloMosaiq_Case1.DcmTreeExeFileName,"5", Config.HelloMosaiq_Case1.DcmTreeExeFileName);
//        OperationInDCMtree operationInDCMtree =new OperationInDCMtree();
//        operationInDCMtree.driver = dcmtree.driver;
//        Boolean isImported = operationInDCMtree.importPlan(Config.HelloMosaiq_Case1.TestPlanPath);
//        return isImported;
//    }






}

