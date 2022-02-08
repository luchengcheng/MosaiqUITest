package DicomParser;

import java.util.List;

public class IconBeamSequence {
    public String manufacturer = "";
    public String institutionName = "";
    public String institutionAddress = "";
    public String treatmentMachineName = "";
    public String primaryDosimeterUnit = "";
    public String beamNumber = "";
    public String beamName = "";
    public String beamDescription = "";
    public String beamType = "";
    public String radiationType = "";
    public String treatmentDeliveryType = "";
    public String numberOfWedges = "";
    public String numberOfCompensators = "";
    public String numberOfBoli = "";
    public String numberOfBlocks = "";
    public String finalCumulativeMetersetWeight = "";
    public String numberOfControlPoints = "";
    public String radiationMassNumber ="";
    public String radiationAtomicNumber = "";
    public String radiationChargeState = "";
    public String scanMode = "";
    public String virtualSourceAxisDistances = "";
    public String numberOfRangeShifters = "";
    public String numberOfLateralSpreadingDevices = "";
    public String numberOfRangeModulators = "";
    public String patientSupportType = "";
    public String referencedPatientSetupNumber = "";
    public String referencedToleranceTableNumber = "";
    public List<ApplicatorSequence> applicatorSequenceList = null;
//  public List<SnoutSequence> snoutSequenceList = null;
//  public List<RangeShifterSequence> rangeShifterSequenceList = null;
//  public List<LateralSpreadingDeviceSequence> lateralSpreadingDeviceSequenceList = null;
//    public List<RangeModulatorSequence> rangeModulatorSequenceList = null;
    public List<IonControlPointSequence> ionControlPointSequenceList = null;
}
