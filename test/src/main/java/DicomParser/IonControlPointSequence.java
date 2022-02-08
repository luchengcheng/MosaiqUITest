package DicomParser;

public class IonControlPointSequence {
    public String controlPointSequence = "";
    public String nominalBeamEntry = "";
    public String gantryAngle = "";
    public String gantryRotationDirection = "";
    public String beamLimitingDeviceAngle = "";
    /**
     * some fields are ignored
     */
    public String scanSpotTuneId = "";
    public String numberOfScanSpotPositions = "";
    public String scanSpotPositionMap = "";
    public String scanSpotMetersetWeight = "";
    public String scanningSpotSize = "";
    public String numberOfPaintings ="";

    public String getBeamLimitingDeviceAngle() {
        return beamLimitingDeviceAngle;
    }

    public String getControlPointSequence() {
        return controlPointSequence;
    }

    public String getGantryAngle() {
        return gantryAngle;
    }

    public String getGantryRotationDirection() {
        return gantryRotationDirection;
    }

    public String getNominalBeamEntry() {
        return nominalBeamEntry;
    }

    public String getNumberOfPaintings() {
        return numberOfPaintings;
    }

    public String getNumberOfScanSpotPositions() {
        return numberOfScanSpotPositions;
    }

    public String getScanningSpotSize() {
        return scanningSpotSize;
    }

    public String getScanSpotMetersetWeight() {
        return scanSpotMetersetWeight;
    }

    public String getScanSpotPositionMap() {
        return scanSpotPositionMap;
    }

    public String getScanSpotTuneId() {
        return scanSpotTuneId;
    }

    public void setBeamLimitingDeviceAngle(String beamLimitingDeviceAngle) {
        this.beamLimitingDeviceAngle = beamLimitingDeviceAngle;
    }

    public void setControlPointSequence(String controlPointSequence) {
        this.controlPointSequence = controlPointSequence;
    }

    public void setGantryAngle(String gantryAngle) {
        this.gantryAngle = gantryAngle;
    }

    public void setGantryRotationDirection(String gantryRotationDirection) {
        this.gantryRotationDirection = gantryRotationDirection;
    }

    public void setNominalBeamEntry(String nominalBeamEntry) {
        this.nominalBeamEntry = nominalBeamEntry;
    }

    public void setNumberOfPaintings(String numberOfPaintings) {
        this.numberOfPaintings = numberOfPaintings;
    }

    public void setNumberOfScanSpotPositions(String numberOfScanSpotPositions) {
        this.numberOfScanSpotPositions = numberOfScanSpotPositions;
    }

    public void setScanningSpotSize(String scanningSpotSize) {
        this.scanningSpotSize = scanningSpotSize;
    }

    public void setScanSpotMetersetWeight(String scanSpotMetersetWeight) {
        this.scanSpotMetersetWeight = scanSpotMetersetWeight;
    }

    public void setScanSpotPositionMap(String scanSpotPositionMap) {
        this.scanSpotPositionMap = scanSpotPositionMap;
    }

    public void setScanSpotTuneId(String scanSpotTuneId) {
        this.scanSpotTuneId = scanSpotTuneId;
    }

}
