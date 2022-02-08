package DicomParser;

public class ReferencedBeamSequence {
    public String beamDose = "";
    public String beanMeterset = "";
    public String beamDOseType = "";
    public String alternateBeamDose = "";
    public String alternateBeamDoseType = "";
    public String referencedBeamNumber = "";

    public String getAlternateBeamDose() {
        return alternateBeamDose;
    }

    public String getAlternateBeamDoseType() {
        return alternateBeamDoseType;
    }

    public String getBeamDose() {
        return beamDose;
    }

    public String getBeamDOseType() {
        return beamDOseType;
    }

    public String getBeanMeterset() {
        return beanMeterset;
    }

    public String getReferencedBeamNumber() {
        return referencedBeamNumber;
    }

    public void setAlternateBeamDose(String alternateBeamDose) {
        this.alternateBeamDose = alternateBeamDose;
    }

    public void setAlternateBeamDoseType(String alternateBeamDoseType) {
        this.alternateBeamDoseType = alternateBeamDoseType;
    }

    public void setBeamDose(String beamDose) {
        this.beamDose = beamDose;
    }

    public void setBeamDOseType(String beamDOseType) {
        this.beamDOseType = beamDOseType;
    }

    public void setBeanMeterset(String beanMeterset) {
        this.beanMeterset = beanMeterset;
    }

    public void setReferencedBeamNumber(String referencedBeamNumber) {
        this.referencedBeamNumber = referencedBeamNumber;
    }
}
