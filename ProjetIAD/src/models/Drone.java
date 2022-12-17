package models;

import Constantes.ConstantesDeplacement;

import java.util.ArrayList;
import java.util.List;

public class Drone {

    private Integer porteeMax;

    private Integer distanceVision;

    private Case caseBase;

    private Case caseActuelle;

    private String dernierDeplacement;

    private Integer distanceParcourue;

    private Integer nbCiblesTuees;

    private boolean explorer;

    private List<Case> historiqueDeplacement;

    private Case caseCible;

    public Drone(Integer porteeMax, Integer distanceVision, Case caseBase) {
        this.porteeMax = porteeMax;
        this.distanceVision = distanceVision;
        this.caseBase = caseBase;
        this.caseActuelle = caseBase;
        this.dernierDeplacement = ConstantesDeplacement.AUCUN;
        this.distanceParcourue = 0;
        this.nbCiblesTuees = 0;
        this.explorer = true;
        this.historiqueDeplacement = new ArrayList<>();
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

    public List<Case> getHistoriqueDeplacement() {
        return historiqueDeplacement;
    }

    public void setHistoriqueDeplacement(List<Case> historiqueDeplacement) {
        this.historiqueDeplacement = historiqueDeplacement;
    }

    public Case getCaseCible() {
        return caseCible;
    }

    public void setCaseCible(Case caseCible) {
        this.caseCible = caseCible;
    }
}
