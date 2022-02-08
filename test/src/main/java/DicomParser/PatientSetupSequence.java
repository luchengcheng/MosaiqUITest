package DicomParser;

public class PatientSetupSequence {
    public String patientPosition = "";
    public String patientSetupNumber = "";

    public String getPatientPosition() {
        return patientPosition;
    }

    public String getPatientSetupNumber() {
        return patientSetupNumber;
    }

    public void setPatientPosition(String patientPosition) {
        this.patientPosition = patientPosition;
    }

    public void setPatientSetupNumber(String patientSetupNumber) {
        this.patientSetupNumber = patientSetupNumber;
    }
}
