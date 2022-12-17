package models;

import Constantes.ConstantesDeplacement;

public class Drone {

    private Integer porteeMax;

    private Integer distanceVision;

    private Case caseBase;

    private Case caseActuelle;

    private String dernierDeplacement;

    private Integer distanceParcourue;

    private Integer nbCiblesTuees;

    private boolean explorer;

    public Drone(Integer porteeMax, Integer distanceVision, Case caseBase) {
        this.porteeMax = porteeMax;
        this.distanceVision = distanceVision;
        this.caseBase = caseBase;
        this.caseActuelle = caseBase;
        this.dernierDeplacement = ConstantesDeplacement.AUCUN;
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

    public String getDernierDeplacement() {
        return dernierDeplacement;
    }

    public void setDernierDeplacement(String dernierDeplacement) {
        this.dernierDeplacement = dernierDeplacement;
    }
}
