package util.parserDicom;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Sequence;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;
import DicomParser.DCMObject;
import DicomParser.DoseReferenceSequence;
import DicomParser.FractionGroupSequence;
import DicomParser.ReferencedBeamSequence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DCMUtil {
    public DCMObject dcmOb = new DCMObject();
//    public double tolerance = 0.001;
//    public double[] fractionMUArr = {0};
//    public double[] controlPointSequence = {0};
//    public double[] finalWeightLayer = {0};

    public Attributes attributesInfo(DicomInputStream DICOM){
          if(DICOM!=null){
            try {
            Attributes fmi = DICOM.readFileMetaInformation();
            Attributes attrs = DICOM.readDataset(-1, -1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<DoseReferenceSequence> getDoseReferenceSequence(Sequence seq){
        List<DoseReferenceSequence> doseReferenceSequenceList = new ArrayList();
        for (int i = 0; i < seq.size(); i++) {
            DoseReferenceSequence doseReferenceSequenceOb = new DoseReferenceSequence();
            Attributes attr = seq.get(i);
            String doseReferenceNumber =  attr.getString(Tag.DoseReferenceNumber);
            doseReferenceSequenceOb.setDoseReferenceNumber(doseReferenceNumber);
            String doseReferenceStructureType =  attr.getString(Tag.DoseReferenceStructureType);
            doseReferenceSequenceOb.setDoseReferenceStructureType(doseReferenceStructureType);
            String doseReferenceDescription =  attr.getString(Tag.DoseReferenceDescription);
            doseReferenceSequenceOb.setDoseReferenceDescription(doseReferenceDescription);
            String DoseReferenceType =  attr.getString(Tag.DoseReferenceType);
            doseReferenceSequenceOb.setDoseReferenceType(DoseReferenceType);
            String TargetPrescriptionDose =  attr.getString(Tag.TargetPrescriptionDose);
            doseReferenceSequenceOb.setTargetPrescriptionDose(TargetPrescriptionDose);
            doseReferenceSequenceList.add(doseReferenceSequenceOb);
//             String[] s = attr.toString().split("\n");
//             System.out.println(":::"+s);
        }
        return doseReferenceSequenceList;
    }

    public List<ReferencedBeamSequence> getReferencedBeamSequence(Sequence seq){
        List<ReferencedBeamSequence> referencedBeamSequenceList = new ArrayList();
        for (int i = 0; i < seq.size(); i++) {
            ReferencedBeamSequence referencedBeamSequenceOb = new ReferencedBeamSequence();
            Attributes attr = seq.get(i);
            String referencedBeamNumber = attr.getString(Tag.ReferencedBeamNumber);
            referencedBeamSequenceOb.setReferencedBeamNumber(referencedBeamNumber);
            String beamDose = attr.getString(Tag.BeamDose);
            referencedBeamSequenceOb.setBeamDose(beamDose);
            String beamMeterSet = attr.getString(Tag.BeamMeterset);
            referencedBeamSequenceOb.setBeanMeterset(beamMeterSet);
            referencedBeamSequenceList.add(referencedBeamSequenceOb);
        }
        return referencedBeamSequenceList;
    }

    public List<FractionGroupSequence> getFractionGroupSequence(Sequence seq){
        List<FractionGroupSequence> fractionGroupSequenceList = new ArrayList();
        for (int i = 0; i < seq.size(); i++) {
            FractionGroupSequence fractionGroupSequenceOb = new FractionGroupSequence();
            Attributes attr = seq.get(i);
            String fractionGroupNumber = attr.getString(Tag.FractionGroupNumber);
            fractionGroupSequenceOb.setFractionGroupNumber(fractionGroupNumber);
            String numberOfFractionsPlanned = attr.getString(Tag.NumberOfFractionsPlanned);
            fractionGroupSequenceOb.setNumberOfFractionPlanned(numberOfFractionsPlanned);
            String numberOfBrachyApplicationSetups = attr.getString(Tag.NumberOfBrachyApplicationSetups);
            fractionGroupSequenceOb.setNumberOfBrachyApplication(numberOfBrachyApplicationSetups);
            Sequence referencedBeamSequence = attr.getSequence(Tag.ReferencedBeamSequence);
            fractionGroupSequenceOb.setReferencedBeamSequenceList(getReferencedBeamSequence(referencedBeamSequence));
//            fractionGroupSequenceOb.setReferencedDoseReferenceSequenceList();
            String numberOfBeams = attr.getString(Tag.NumberOfBeams);
            fractionGroupSequenceOb.setNumberOfBeams(numberOfBeams);
            fractionGroupSequenceList.add(fractionGroupSequenceOb);
        }
        return fractionGroupSequenceList;
    }


    public DCMObject generateDCMObject(DicomInputStream DICOM){
        if(DICOM!=null){
            try {
                Attributes fmi = DICOM.readFileMetaInformation();
                Attributes attrs = DICOM.readDataset(-1, -1);
                dcmOb.setPatientName(attrs.getString(Tag.PatientName));
                dcmOb.setPatientId(attrs.getString(Tag.PatientID));
                dcmOb.setDeviceSerialNumber(attrs.getString(Tag.DeviceSerialNumber));
                dcmOb.setFrameOfReferenceUid(attrs.getString(Tag.FrameOfReferenceUID));
                dcmOb.setInstanceCreationDate(attrs.getString(Tag.InstanceCreationDate));
                dcmOb.setInstanceCreationTime(attrs.getString(Tag.InstanceCreationTime));
                dcmOb.setInstitutionAddress(attrs.getString(Tag.InstitutionAddress));
                dcmOb.setInstitutionName(attrs.getString(Tag.InstitutionName));
                dcmOb.setManufacture(attrs.getString(Tag.Manufacturer));
                dcmOb.setManufacturerModelName(attrs.getString(Tag.ManufacturerModelName));
                dcmOb.setModality(attrs.getString(Tag.Modality));
                dcmOb.setOperatorName(attrs.getString(Tag.OperatorsName));
                dcmOb.setPatientBirthDate(attrs.getString(Tag.PatientBirthDate));
                dcmOb.setPatientSex(attrs.getString(Tag.PatientSex));
                dcmOb.setPlanIntent(attrs.getString(Tag.PlanIntent));
                dcmOb.setRtPlanDate(attrs.getString(Tag.RTPlanDate));
                dcmOb.setRtPlanGeometry(attrs.getString(Tag.RTPlanGeometry));
                dcmOb.setRtPlanLabel(attrs.getString(Tag.RTPlanLabel));
                dcmOb.setRtPlanName(attrs.getString(Tag.RTPlanName));
                dcmOb.setRtPlanTime(attrs.getString(Tag.RTPlanTime));
                dcmOb.setSeriesDescription(attrs.getString(Tag.SeriesDescription));
                dcmOb.setSeriesInstanceUid(attrs.getString(Tag.SeriesInstanceUID));
                dcmOb.setSeriesNumber(attrs.getString(Tag.SoftwareVersions));
                dcmOb.setSopClassUid(attrs.getString(Tag.SOPClassUID));
                dcmOb.setSopInstanceUid(attrs.getString(Tag.SOPInstanceUID));
                dcmOb.setStationName(attrs.getString(Tag.StationName));
                dcmOb.setStudyDate(attrs.getString(Tag.StudyDate));
                dcmOb.setStudyId(attrs.getString(Tag.StudyID));
                dcmOb.setStudyInstanceUid(attrs.getString(Tag.StudyInstanceUID));
                dcmOb.setStudyTime(attrs.getString(Tag.StudyTime));
                Sequence doseReferenceSequence = attrs.getSequence(Tag.DoseReferenceSequence);
                dcmOb.setDoseReferenceSequenceList(getDoseReferenceSequence(doseReferenceSequence));
                Sequence fractionGroupSequence = attrs.getSequence(Tag.FractionGroupSequence);
                dcmOb.setFractionGroupSequenceList(getFractionGroupSequence(fractionGroupSequence));
                return dcmOb;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
