package ImpacUpdate;

import org.ini4j.Ini;
import org.ini4j.Profile;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

import Config.HelloMosaiq_Case1;

public class ImpacFileOperation {
    public  void updateIniFile()  {
        slashChangeInFile("\\","\\\\" );
        File iniFIle = new File(HelloMosaiq_Case1.ImpacFilePath);
        Ini ini = new Ini();
        try {
            ini.load(iniFIle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Profile.Section section = null;
        Map<String,String> dataMap = null;
        for (String sect : HelloMosaiq_Case1.UpdateImpacData.keySet()){
            section = ini.get(sect);
            dataMap = HelloMosaiq_Case1.UpdateImpacData.get(sect);
            for (String key : dataMap.keySet()){
                section.put(key,dataMap.get(key) == null ? "" :
                        dataMap.get(key));
            }
        }
        try {
            ini.store(iniFIle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        slashChangeInFile("\\\\" ,"\\");
        slashChangeInFile("\\:\\" ,":\\");
    }

    /* This method is to solve Parser '\' issue . */
    public static void slashChangeInFile( String singleSlash, String doubleSalsh)  {
        File file = new File(HelloMosaiq_Case1.ImpacFilePath) ;
        Reader reader= null;
        StringBuilder sb=new StringBuilder();
        String str;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((str=((BufferedReader) reader).readLine())!=null){
                sb.append(str.replace(singleSlash,doubleSalsh)+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
            Writer write=new BufferedWriter(new FileWriter(file));
            write.write(String.valueOf(sb));
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void UpdateImpacData(){
        Map<String,String> vmiMap = new HashMap<>();
        Map<String,String> protonMap = new HashMap<>();
        if(HelloMosaiq_Case1.MachineType.equalsIgnoreCase(HelloMosaiq_Case1.MachineType) && HelloMosaiq_Case1.TreatmentWorkflowProtocol.equalsIgnoreCase(HelloMosaiq_Case1.TreatmentWorkflowProtocol)){
            vmiMap.put("VMIType","DTMI");
            vmiMap.put("VMIConfig", HelloMosaiq_Case1.CaseRootPath+"\\"+ HelloMosaiq_Case1.CfgFileName);
            vmiMap.put("Number of IODs","0");
            vmiMap.put("No Ports","1");
            vmiMap.put("No Open Ports","1");
            protonMap.put("MachineName","Hitachi");
        }
        HelloMosaiq_Case1.UpdateImpacData.put("VMI",vmiMap);
        HelloMosaiq_Case1.UpdateImpacData.put("PROTON",protonMap);
    }


    public class Ini4jFileVo {
        private String ip;
        private String ipPort;
        private String isUsed;
    }

    public Map<String, List<String>> showFileContent(){
        Map<String, List<String>> fileContent = new HashMap<String, List<String>>();
        return fileContent;
    }

    public  Ini4jFileVo readIniFile(File iniFile, Map<String, List<String>> fileContent) throws IOException, NoSuchFieldException, IllegalAccessException {
        Ini4jFileVo fileVo = new Ini4jFileVo();
        Ini ini = new Ini();
        ini.load(iniFile);
        Profile.Section section = null;
        Field field = null;
        for(String key : fileContent.keySet()){
            section = ini.get(key);
            for (String value: fileContent.get(key)) {
                field = fileVo.getClass().getDeclaredField(value);
                field.setAccessible(true);
                field.set(fileVo, section.get(value));
            }
        }

        /**
         * 这个是简略版的
         *    Section section = ini.get("ldap");
         *  fileVo.setIp(section.get("ip"));
         *   fileVo.setIpPort(section.get("port" ));
         *
         *  section = ini.get("test");
         *   fileVo.setIsUsed(section.get("isUsed"));
         */
        return fileVo;
    }

    public void readIni(String fileName){
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {  //按行读取字符串
                String line = sc.nextLine();
                HelloMosaiq_Case1.logger.info("\""+line+"\"");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
