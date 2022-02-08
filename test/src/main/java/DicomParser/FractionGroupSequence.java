package DicomParser;

import java.util.List;

public class FractionGroupSequence {
    public String fractionGroupNumber = "";
    public String numberOfFractionPlanned = "";
    public String numberOfBeams = "";
    public String numberOfBrachyApplication = "";
    public List<ReferencedBeamSequence>  referencedBeamSequenceList = null;
    public List<ReferencedDoseReferenceSequence> referencedDoseReferenceSequenceList = null;

    public List<ReferencedBeamSequence> getReferencedBeamSequenceList() {
        return referencedBeamSequenceList;
    }

    public List<ReferencedDoseReferenceSequence> getReferencedDoseReferenceSequenceList() {
        return referencedDoseReferenceSequenceList;
    }

    public String getFractionGroupNumber() {
        return fractionGroupNumber;
    }

    public String getNumberOfBeams() {
        return numberOfBeams;
    }

    public String getNumberOfBrachyApplication() {
        return numberOfBrachyApplication;
    }

    public String getNumberOfFractionPlanned() {
        return numberOfFractionPlanned;
    }

    public void setFractionGroupNumber(String fractionGroupNumber) {
        this.fractionGroupNumber = fractionGroupNumber;
    }

    public void setNumberOfBeams(String numberOfBeams) {
        this.numberOfBeams = numberOfBeams;
    }

    public void setNumberOfBrachyApplication(String numberOfBrachyApplication) {
        this.numberOfBrachyApplication = numberOfBrachyApplication;
    }

    public void setNumberOfFractionPlanned(String numberOfFractionPlanned) {
        this.numberOfFractionPlanned = numberOfFractionPlanned;
    }

    public void setReferencedBeamSequenceList(List<ReferencedBeamSequence> referencedBeamSequenceList) {
        this.referencedBeamSequenceList = referencedBeamSequenceList;
    }

    public void setReferencedDoseReferenceSequenceList(List<ReferencedDoseReferenceSequence> referencedDoseReferenceSequenceList) {
        this.referencedDoseReferenceSequenceList = referencedDoseReferenceSequenceList;
    }
}
