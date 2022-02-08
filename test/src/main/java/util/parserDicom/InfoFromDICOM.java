package util.parserDicom;

import org.dcm4che3.io.DicomInputStream;
import DicomParser.DCMObject;

import java.io.File;
import java.io.IOException;

public class InfoFromDICOM {
    public  DCMObject dcmObject =null;

    public void getDcmObject(String dicomFile){
        File file = new File(dicomFile);
        try {
            DicomInputStream dis = new DicomInputStream(file);
            DCMUtil dcmUtil = new DCMUtil();
            dcmObject = dcmUtil.generateDCMObject(dis);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPatientLastName(){
        if(dcmObject!=null)
            return dcmObject.getPatientName().split("\\^")[0];
        else
            return "dcmObject is null. Please check it!";
    }
    public String getPatientFirstName(){
        if(dcmObject!=null)
            return dcmObject.getPatientName().split("\\^")[1];
        else
            return "dcmObject is null. Please check it!";
    }

    public String getPatientPlanMR(){
        if(dcmObject!=null)
            return dcmObject.getPatientId();
        else
            return "dcmObject is null. Please check it!";
    }

}
