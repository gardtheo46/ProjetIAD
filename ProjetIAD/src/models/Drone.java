package models;

public class Drone {

    private Integer porteeMax;

    private Integer distanceToBase;

    private Integer distanceVision;

    private Case caseBase;

    private Case caseActuelle;

    private Integer distanceParcourue;

    private Integer nbCiblesTuees;

    private boolean explorer;

    public Drone(Integer porteeMax, Integer distanceToBase, Integer distanceVision, Case caseBase) {
        this.porteeMax = porteeMax;
        this.distanceToBase = distanceToBase;
        this.distanceVision = distanceVision;
        this.caseBase = caseBase;
        this.caseActuelle = caseBase;
        this.distanceParcourue = 0;
        this.nbCiblesTuees = 0;
        this.explorer = true;
    }

    public Integer getPorteeMax() {
        return porteeMax;
    }

    public void setPorteeMax(Integer porteeMax) {
        this.porteeMax = porteeMax;
    }

    public Integer getDistanceToBase() {
        return distanceToBase;
    }

    public void setDistanceToBase(Integer distanceToBase) {
        this.distanceToBase = distanceToBase;
    }

    public Integer getDistanceVision() {
        return distanceVision;
    }

    public void setDistanceVision(Integer distanceVision) {
        this.distanceVision = distanceVision;
    }

    public Case getCaseBase() {
        return caseBase;
    }

    public void setCaseBase(Case caseBase) {
        this.caseBase = caseBase;
    }

    public Case getCaseActuelle() {
        return caseActuelle;
    }

    public void setCaseActuelle(Case caseActuelle) {
        this.caseActuelle = caseActuelle;
    }

    public Integer getDistanceParcourue() {
        return distanceParcourue;
    }

    public void setDistanceParcourue(Integer distanceParcourue) {
        this.distanceParcourue = distanceParcourue;
    }

    public Integer getNbCiblesTuees() {
        return nbCiblesTuees;
    }

    public void setNbCiblesTuees(Integer nbCiblesTuees) {
        this.nbCiblesTuees = nbCiblesTuees;
    }

    public boolean isExplorer() {
        return explorer;
    }

    public void setExplorer(boolean explorer) {
        this.explorer = explorer;
    }
}
