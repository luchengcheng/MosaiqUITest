package Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class HelloMosaiq_Case1 {
    public static Logger logger = LoggerFactory.getLogger(HelloMosaiq_Case1.class);
    public  static String RootRunPath = "C:\\MOSAIQ\\2021.20\\LNG_2021.20.014\\IMPAC\\MOSAIQ_APP";
    public  static String CaseRootPath = "D:\\MyProject\\test\\Data\\case";
    public static  String TestPlanPath ="D:\\MyProject\\test\\Data\\case\\RTPLAN_202005271014374490518.dcm";
    public static  String DcmTreeExeFileName = "DCMtree.exe";
    public static  String DcmWinExeFileName = "Dcmwin.exe";
    public static  String WQEServiceExeFileName = "Impac.Mosaiq.Dicom.Services.WQEService.WQEProcessorSystemTray.exe";
    public static  String MOSAIQExeFileName = "accwin.exe";
    public static  String MOSAIQ_Version = "LNG_2021.20.014";
    public static  String MOSAIQ_Username = "impac";
    public static  String MOSAIQ_Password = "impac";
    public static String MachineType = "Hitachi"; //IBA,Mevion,Hitachi...
    public static  String TreatmentWorkflowProtocol = "IFS"; //IFS,TDWII
    public static  String CfgFileName = "FX1.cfg";
    public static  String MacFileName = "FX1.MAC";
    public static  String ImpacFilePath = "C:\\Users\\Public\\Impac.ini";
    public static String MachineName = "FX1";
    public static  Map<String, Map<String,String>> UpdateImpacData = new HashMap<>();
}
