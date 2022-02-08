package DicomParser;

import java.util.List;

public class DCMObject {
   public String instanceCreationDate = "";
   public String instanceCreationTime = "";
   public String sopClassUid = "";
   public String sopInstanceUid = "";
   public String studyDate = "";
   public String studyTime = "";
   public String modality = "";
   public String manufacture = "";
   public String institutionName = "";
   public String institutionAddress = "";
   public String stationName = "";
   public String seriesDescription = "";
   public String operatorName = "";
   public String manufacturerModelName = "";
   public String patientName = "";
   public String patientId = "";
   public String patientBirthDate = "";
   public String patientSex = "";
   public String deviceSerialNumber = "";
   public String softwareVersion = "";
   public String studyInstanceUid = "";
   public String seriesInstanceUid = "";
   public String studyId = "";
   public String seriesNumber = "";
   public String frameOfReferenceUid = "";
   public String rtPlanLabel = "";
   public String rtPlanName = "";
   public String rtPlanDate = "";
   public String rtPlanTime = "";
   public String planIntent = "";
   public String rtPlanGeometry = "";
   public List<DoseReferenceSequence> doseReferenceSequenceList = null;
   public List<FractionGroupSequence> fractionGroupSequenceList = null;
   public List<PatientSetupSequence> patientSetupSequenceList = null;
   public List<IconToleranceTableSequence> iconToleranceTableSequenceList = null;
   public List<IconBeamSequence> iconBeamSequenceList = null;

   public List<DoseReferenceSequence> getDoseReferenceSequenceList() {
      return doseReferenceSequenceList;
   }

   public String getDeviceSerialNumber() {
      return deviceSerialNumber;
   }

   public List<FractionGroupSequence> getFractionGroupSequenceList() {
      return fractionGroupSequenceList;
   }

   public List<PatientSetupSequence> getPatientSetupSequenceList() {
      return patientSetupSequenceList;
   }

   public String getInstanceCreationDate() {
      return instanceCreationDate;
   }

   public String getFrameOfReferenceUid() {
      return frameOfReferenceUid;
   }

   public List<IconBeamSequence> getIconBeamSequenceList() {
      return iconBeamSequenceList;
   }

   public String getInstanceCreationTime() {
      return instanceCreationTime;
   }

   public String getInstitutionAddress() {
      return institutionAddress;
   }

   public String getInstitutionName() {
      return institutionName;
   }

   public String getManufacture() {
      return manufacture;
   }

   public List<IconToleranceTableSequence> getIconToleranceTableSequenceList() {
      return iconToleranceTableSequenceList;
   }

   public String getManufacturerModelName() {
      return manufacturerModelName;
   }

   public String getModality() {
      return modality;
   }

   public String getOperatorName() {
      return operatorName;
   }

   public String getPatientBirthDate() {
      return patientBirthDate;
   }

   public String getPatientId() {
      return patientId;
   }

   public String getPatientName() {
      return patientName;
   }

   public String getPatientSex() {
      return patientSex;
   }

   public String getPlanIntent() {
      return planIntent;
   }

   public String getRtPlanDate() {
      return rtPlanDate;
   }

   public String getSeriesDescription() {
      return seriesDescription;
   }

   public String getRtPlanLabel() {
      return rtPlanLabel;
   }

   public String getRtPlanGeometry() {
      return rtPlanGeometry;
   }

   public String getRtPlanName() {
      return rtPlanName;
   }

   public String getRtPlanTime() {
      return rtPlanTime;
   }

   public String getSeriesInstanceUid() {
      return seriesInstanceUid;
   }

   public String getSeriesNumber() {
      return seriesNumber;
   }

   public String getSoftwareVersion() {
      return softwareVersion;
   }

   public String getSopClassUid() {
      return sopClassUid;
   }

   public String getSopInstanceUid() {
      return sopInstanceUid;
   }

   public String getStationName() {
      return stationName;
   }

   public String getStudyDate() {
      return studyDate;
   }

   public String getStudyId() {
      return studyId;
   }

   public String getStudyInstanceUid() {
      return studyInstanceUid;
   }

   public String getStudyTime() {
      return studyTime;
   }

   public void setDeviceSerialNumber(String deviceSerialNumber) {
      this.deviceSerialNumber = deviceSerialNumber;
   }

   public void setFrameOfReferenceUid(String frameOfReferenceUid) {
      this.frameOfReferenceUid = frameOfReferenceUid;
   }

   public void setInstanceCreationDate(String instanceCreationDate) {
      this.instanceCreationDate = instanceCreationDate;
   }

   public void setDoseReferenceSequenceList(List<DoseReferenceSequence> doseReferenceSequenceList) {
      this.doseReferenceSequenceList = doseReferenceSequenceList;
   }

   public void setFractionGroupSequenceList(List<FractionGroupSequence> fractionGroupSequenceList) {
      this.fractionGroupSequenceList = fractionGroupSequenceList;
   }

   public void setInstanceCreationTime(String instanceCreationTime) {
      this.instanceCreationTime = instanceCreationTime;
   }

   public void setInstitutionAddress(String institutionAddress) {
      this.institutionAddress = institutionAddress;
   }

   public void setInstitutionName(String institutionName) {
      this.institutionName = institutionName;
   }

   public void setManufacture(String manufacture) {
      this.manufacture = manufacture;
   }

   public void setIconToleranceTableSequenceList(List<IconToleranceTableSequence> iconToleranceTableSequenceList) {
      this.iconToleranceTableSequenceList = iconToleranceTableSequenceList;
   }

   public void setIconBeamSequenceList(List<IconBeamSequence> iconBeamSequenceList) {
      this.iconBeamSequenceList = iconBeamSequenceList;
   }

   public void setManufacturerModelName(String manufacturerModelName) {
      this.manufacturerModelName = manufacturerModelName;
   }

   public void setModality(String modality) {
      this.modality = modality;
   }

   public void setOperatorName(String operatorName) {
      this.operatorName = operatorName;
   }

   public void setPatientBirthDate(String patientBirthDate) {
      this.patientBirthDate = patientBirthDate;
   }

   public void setPatientId(String patientId) {
      this.patientId = patientId;
   }

   public void setPatientName(String patientName) {
      this.patientName = patientName;
   }

   public void setPatientSex(String patientSex) {
      this.patientSex = patientSex;
   }

   public void setPatientSetupSequenceList(List<PatientSetupSequence> patientSetupSequenceList) {
      this.patientSetupSequenceList = patientSetupSequenceList;
   }

   public void setPlanIntent(String planIntent) {
      this.planIntent = planIntent;
   }

   public void setRtPlanDate(String rtPlanDate) {
      this.rtPlanDate = rtPlanDate;
   }

   public void setRtPlanGeometry(String rtPlanGeometry) {
      this.rtPlanGeometry = rtPlanGeometry;
   }

   public void setRtPlanLabel(String rtPlanLabel) {
      this.rtPlanLabel = rtPlanLabel;
   }

   public void setRtPlanName(String rtPlanName) {
      this.rtPlanName = rtPlanName;
   }

   public void setRtPlanTime(String rtPlanTime) {
      this.rtPlanTime = rtPlanTime;
   }

   public void setSeriesDescription(String seriesDescription) {
      this.seriesDescription = seriesDescription;
   }

   public void setSeriesInstanceUid(String seriesInstanceUid) {
      this.seriesInstanceUid = seriesInstanceUid;
   }

   public void setSeriesNumber(String seriesNumber) {
      this.seriesNumber = seriesNumber;
   }

   public void setSoftwareVersion(String softwareVersion) {
      this.softwareVersion = softwareVersion;
   }

   public void setSopClassUid(String sopClassUid) {
      this.sopClassUid = sopClassUid;
   }

   public void setSopInstanceUid(String sopInstanceUid) {
      this.sopInstanceUid = sopInstanceUid;
   }

   public void setStationName(String stationName) {
      this.stationName = stationName;
   }

   public void setStudyDate(String studyDate) {
      this.studyDate = studyDate;
   }

   public void setStudyId(String studyId) {
      this.studyId = studyId;
   }

   public void setStudyInstanceUid(String studyInstanceUid) {
      this.studyInstanceUid = studyInstanceUid;
   }

   public void setStudyTime(String studyTime) {
      this.studyTime = studyTime;
   }
}
