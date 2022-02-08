package util.parserDicom;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Sequence;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;
import util.parserDicom.DCMUtil;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class DicomDemo {
    public static void getTagByFile(String pathFile) {
        try {
            File file = new File(pathFile);
            DicomInputStream dis = new DicomInputStream(file);
            Attributes fmi = dis.readFileMetaInformation();
            Attributes attrs = dis.readDataset(-1, -1);
            System.out.println("Series Instance UID:" + attrs.getString(Tag.SeriesInstanceUID));
            System.out.println("Study Instance UID:" + attrs.getString(Tag.StudyInstanceUID));
            System.out.println("Patient ID:" + attrs.getString(Tag.PatientID));
            System.out.println("Patient Name" + attrs.getString(Tag.PatientName));
            System.out.println("SOP Instance UID:" + attrs.getString(Tag.SOPInstanceUID));
            System.out.println(attrs.getString(Tag.ImageType));

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }


      /* Reading VR = SQ
            *
   * @param inputFile : File
   * @param tag : VR =SQ
   * @return
           */
    public static String[] readItem(String inputFile){
        try {
            File file = new File(inputFile);
            DicomInputStream dis = new DicomInputStream(file);
            Attributes fmi = dis.readFileMetaInformation();
            Attributes dcm = dis.readDataset(-1, -1);
            Sequence seq = dcm.getSequence(Tag.DoseReferenceSequence);
            String valueString[] = new String[seq.size()];
            for (int i = 0; i < seq.size(); i++) {
                Attributes attr = seq.get(i);
                System.out.println(":::"+attr.getString(Tag.DoseReferenceNumber));
                valueString[i] = attr.toString();
                System.out.println(valueString[i]);
            }

            return valueString;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String dicomFile = "D:\\TC\\parserDCM\\RTPLAN_DEtesting.dcm";
//        getTagByFile(dicomFile);
//        readItem ("D:\\TC\\parserDCM\\RTPLAN_DEtesting.dcm");
        File file = new File(dicomFile);
        try {
            DicomInputStream dis = new DicomInputStream(file);
            DCMUtil dcmUtil = new DCMUtil();
            dcmUtil.generateDCMObject(dis);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
