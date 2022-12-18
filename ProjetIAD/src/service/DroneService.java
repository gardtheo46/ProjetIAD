package service;

import Constantes.ConstantesDeplacement;
import models.Case;
import models.Drone;

import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class DroneService {

    public static void deplacerDrone(List<Case> map, Drone drone, Integer x, Integer y) {
        // Dans tous les cas, on met le coef de passage à 1
        Case derniereCase = map.get(map.indexOf(drone.getCaseActuelle()));
        drone.getHistoriqueDeplacement().add(derniereCase);
        derniereCase.setCoefPassage(1.00);
        derniereCase.setDejaPasse(true);
        // On récupere la limite de la map
        Double limiteMap = sqrt(map.size()) - 1;
        Integer limiteMapInt = limiteMap.intValue();
        // On vérifie qu'on doit pas se déplacer sur une case qui n'existe pas
        if ((x > limiteMapInt || x < 0) || (y > limiteMapInt || y < 0)) {
            // On part le plus loin possible des extrémités
            if ((x > limiteMapInt || x < 0)) {
                // Si il touche un extreme en X, il doit bouger sur l'axe des Y
                Integer distanceTo0Y = drone.getCaseActuelle().getY();
                Integer distanceToLimiteY = limiteMapInt - drone.getCaseActuelle().getY();
                if (distanceToLimiteY >= distanceTo0Y) {
                    drone.setCaseActuelle(MapService.getCase(map, drone.getCaseActuelle().getX(), drone.getCaseActuelle().getY() + 1));
                    drone.setDernierDeplacement(ConstantesDeplacement.HAUT);
                } else {
                    drone.setCaseActuelle(MapService.getCase(map, drone.getCaseActuelle().getX(), drone.getCaseActuelle().getY() - 1));
                    drone.setDernierDeplacement(ConstantesDeplacement.BAS);
                }
            } else {
                // Si il touche un extreme en Y, il doit bouger sur l'axe des X
                Integer distanceTo0X = drone.getCaseActuelle().getX();
                Integer distanceToLimiteX = limiteMapInt - drone.getCaseActuelle().getX();
                if (distanceToLimiteX >= distanceTo0X) {
                    drone.setCaseActuelle(MapService.getCase(map, drone.getCaseActuelle().getX() + 1, drone.getCaseActuelle().getY()));
                    drone.setDernierDeplacement(ConstantesDeplacement.DROITE);
                } else {
                    drone.setCaseActuelle(MapService.getCase(map, drone.getCaseActuelle().getX() - 1, drone.getCaseActuelle().getY()));
                    drone.setDernierDeplacement(ConstantesDeplacement.GAUCHE);
                }
            }
        } else {
            // On se déplace aux cases voulues
            drone.setCaseActuelle(MapService.getCase(map, x, y));
        }
        //On ajoute 1 à la distance parcourue
        drone.setDistanceParcourue(drone.getDistanceParcourue() + 1);
        //Maintenant qu'on s'est déplacé, on verifie qu'on soit encore en capacité d'explorer
        Integer distanceXToBase = drone.getCaseActuelle().getX() - drone.getCaseBase().getX();
        Integer distanceYToBase = drone.getCaseActuelle().getY() - drone.getCaseBase().getY();
        Integer distanceToBase = abs(distanceYToBase) + abs(distanceXToBase);
        // Si la distance est pile égale, ça veut dire qu'on doit rentrer à la base
        if (drone.getPorteeMax() - (drone.getDistanceParcourue() + distanceToBase) == 0) {
            drone.setExplorer(false);
        }
    }
}
