package DicomParser;

public class DoseReferenceSequence {
    public String doseReferenceNumber = "";
    public String doseReferenceStructureType = "";
    public String doseReferenceDescription = "";
    public String doseReferenceType = "";
    public String targetPrescriptionDose ="";

    public String getDoseReferenceNumber(){
        return doseReferenceNumber;
    }

    public void setDoseReferenceNumber(String doseReferenceNumber){
        this.doseReferenceNumber = doseReferenceNumber;
    }

    public String getDoseReferenceStructureType(){
        return doseReferenceStructureType;
    }

    public void setDoseReferenceStructureType(String doseReferenceStructureType) {
        this.doseReferenceStructureType = doseReferenceStructureType;
    }

    public String getDoseReferenceDescription(){
        return doseReferenceDescription;
    }

    public void setDoseReferenceDescription(String doseReferenceDescription) {
        this.doseReferenceDescription = doseReferenceDescription;
    }

    public String getDoseReferenceType(){
        return doseReferenceType;
    }
    public void setDoseReferenceType(String doseReferenceType) {
        this.doseReferenceType = doseReferenceType;
    }

    public String getTargetPrescriptionDose(){
        return targetPrescriptionDose;
    }

    public void setTargetPrescriptionDose(String targetPrescriptionDose) {
        this.targetPrescriptionDose = targetPrescriptionDose;
    }
}
