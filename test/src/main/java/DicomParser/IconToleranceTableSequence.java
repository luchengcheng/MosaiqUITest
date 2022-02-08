package DicomParser;

public class IconToleranceTableSequence {
    public String toleranceTableNumber = "";
    public String toleranceTableLabel = "";
    public String patientSupportAngleTolerance = "";
    public String tableTopPitchAngleTolerance = "";
    public String tableTopRollAngleTolerance = "";
    public String tableTopVerticalAngleTolerance = "";
    public String tableTopLongitudinalPositionTolerance = "";
    public String tableTopLateralPositionTolerance = "";

    public String getPatientSupportAngleTolerance() {
        return patientSupportAngleTolerance;
    }

    public String getTableTopLateralPositionTolerance() {
        return tableTopLateralPositionTolerance;
    }

    public String getTableTopLongitudinalPositionTolerance() {
        return tableTopLongitudinalPositionTolerance;
    }

    public String getTableTopPitchAngleTolerance() {
        return tableTopPitchAngleTolerance;
    }

    public String getTableTopRollAngleTolerance() {
        return tableTopRollAngleTolerance;
    }

    public String getTableTopVerticalAngleTolerance() {
        return tableTopVerticalAngleTolerance;
    }

    public String getToleranceTableLabel() {
        return toleranceTableLabel;
    }

    public String getToleranceTableNumber() {
        return toleranceTableNumber;
    }

    public void setPatientSupportAngleTolerance(String patientSupportAngleTolerance) {
        this.patientSupportAngleTolerance = patientSupportAngleTolerance;
    }

    public void setTableTopLateralPositionTolerance(String tableTopLateralPositionTolerance) {
        this.tableTopLateralPositionTolerance = tableTopLateralPositionTolerance;
    }

    public void setTableTopLongitudinalPositionTolerance(String tableTopLongitudinalPositionTolerance) {
        this.tableTopLongitudinalPositionTolerance = tableTopLongitudinalPositionTolerance;
    }

    public void setTableTopPitchAngleTolerance(String tableTopPitchAngleTolerance) {
        this.tableTopPitchAngleTolerance = tableTopPitchAngleTolerance;
    }

    public void setTableTopRollAngleTolerance(String tableTopRollAngleTolerance) {
        this.tableTopRollAngleTolerance = tableTopRollAngleTolerance;
    }

    public void setTableTopVerticalAngleTolerance(String tableTopVerticalAngleTolerance) {
        this.tableTopVerticalAngleTolerance = tableTopVerticalAngleTolerance;
    }

    public void setToleranceTableLabel(String toleranceTableLabel) {
        this.toleranceTableLabel = toleranceTableLabel;
    }

    public void setToleranceTableNumber(String toleranceTableNumber) {
        this.toleranceTableNumber = toleranceTableNumber;
    }
}
