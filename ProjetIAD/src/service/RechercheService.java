package service;

import Constantes.ConstantesDeplacement;
import models.Case;
import models.Drone;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class RechercheService {

    public void algoISOA(List<Case> map,List<Drone> drones) {
        for (Drone drone : drones) {
            Integer xActuel = drone.getCaseActuelle().getX();
            Integer yActuel = drone.getCaseActuelle().getY();
            if (drone.isExplorer()) {
                //S’il est sur la cible, alors il l’a détruit (mettre à jour la valeur de la cible)
                Case caseActuelle = map.get(map.indexOf(drone.getCaseActuelle()));
                if (caseActuelle.isCible()) {
                    caseActuelle.setCible(false);
                    drone.setNbCiblesTuees(drone.getNbCiblesTuees() + 1);
                }

                //Examiner tout autour du robot grâce à la distance de vision
                List<Case> caseAVoir = new ArrayList<>();

                switch (drone.getDernierDeplacement()) {
                    case ConstantesDeplacement.AUCUN:
                    case ConstantesDeplacement.HAUT:
                        for (int i = 1; i <= drone.getDistanceVision(); i++) {
                            caseAVoir.add(MapService.getCase(map, xActuel, yActuel + i));
                            caseAVoir.add(MapService.getCase(map, xActuel + 1, yActuel + i));
                            caseAVoir.add(MapService.getCase(map, xActuel - 1, yActuel + i));
                        }
                        break;
                    case ConstantesDeplacement.BAS:
                        for (int i = 1; i <= drone.getDistanceVision(); i++) {
                            caseAVoir.add(MapService.getCase(map, xActuel, yActuel - i));
                            caseAVoir.add(MapService.getCase(map, xActuel + 1, yActuel - i));
                            caseAVoir.add(MapService.getCase(map, xActuel - 1, yActuel - i));
                        }
                        break;
                    case ConstantesDeplacement.GAUCHE:
                        for (int i = 1; i <= drone.getDistanceVision(); i++) {
                            caseAVoir.add(MapService.getCase(map, xActuel - i, yActuel));
                            caseAVoir.add(MapService.getCase(map, xActuel - i, yActuel + 1));
                            caseAVoir.add(MapService.getCase(map, xActuel - i, yActuel - 1));
                        }
                        break;
                    case ConstantesDeplacement.DROITE:
                        for (int i = 1; i <= drone.getDistanceVision(); i++) {
                            caseAVoir.add(MapService.getCase(map, xActuel + i, yActuel));
                            caseAVoir.add(MapService.getCase(map, xActuel + i, yActuel + 1));
                            caseAVoir.add(MapService.getCase(map, xActuel + i, yActuel - 1));
                        }
                        break;
                }
                //S’il y a une cible -> se rendre à la cible en s'alignant verticalement puis horizontalement, sauf s’il y a des phéromones sur la cible
                for (Case cases : caseAVoir) {
                    if (cases != null) {
                        if (cases.isCible()) {
                            Integer distanceX = cases.getX() - drone.getCaseActuelle().getX();
                            Integer distanceY = cases.getY() - drone.getCaseActuelle().getY();
                            if (abs(distanceX) <= abs(distanceY)) {
                                // On se déplace sur l'axe Y
                                if (distanceY > 0) {
                                    DroneService.deplacerDrone(map, drone, xActuel, yActuel++);
                                } else {
                                    DroneService.deplacerDrone(map, drone, xActuel, yActuel--);
                                }
                            } else {
                                // On se déplace sur l'axe X
                                if (distanceX > 0) {
                                    DroneService.deplacerDrone(map, drone, xActuel++, yActuel);
                                } else {
                                    DroneService.deplacerDrone(map, drone, xActuel--, yActuel);
                                }

                            }
                        }
                    }
                }
                //S’il n’y a pas de phéromone continuer tout droit
                if (caseAVoir.get(0).getCoefPassage().equals(0.00)) {
                    switch (drone.getDernierDeplacement()) {
                        case ConstantesDeplacement.AUCUN:
                        case ConstantesDeplacement.HAUT:
                            DroneService.deplacerDrone(map, drone, xActuel, yActuel++);
                            drone.setDernierDeplacement(ConstantesDeplacement.HAUT);
                            break;
                        case ConstantesDeplacement.BAS:
                            DroneService.deplacerDrone(map, drone, xActuel, yActuel--);
                            drone.setDernierDeplacement(ConstantesDeplacement.BAS);
                            break;
                        case ConstantesDeplacement.GAUCHE:
                            DroneService.deplacerDrone(map, drone, xActuel--, yActuel);
                            drone.setDernierDeplacement(ConstantesDeplacement.GAUCHE);
                            break;
                        case ConstantesDeplacement.DROITE:
                            DroneService.deplacerDrone(map, drone, xActuel++, yActuel);
                            drone.setDernierDeplacement(ConstantesDeplacement.DROITE);
                            break;
                    }

                    //Chaque tour, chaque phéromone perd 0.01
                    MapService.reductionPheromone(map);

                } else {
                    //Tant que Lmax < ce que le drone à parcouru + ce qu’il doit parcourir pour rentrer (alignement abscisse et ordonnée)
                    Integer distanceX = drone.getCaseBase().getX() - drone.getCaseActuelle().getX();
                    Integer distanceY = drone.getCaseBase().getY() - drone.getCaseActuelle().getY();
                    if (abs(distanceX) <= abs(distanceY)) {
                        // On se déplace sur l'axe Y
                        if (distanceY > 0) {
                            DroneService.deplacerDrone(map, drone, xActuel, yActuel++);
                        } else {
                            DroneService.deplacerDrone(map, drone, xActuel, yActuel--);
                        }
                    } else {
                        // On se déplace sur l'axe X
                        if (distanceX > 0) {
                            DroneService.deplacerDrone(map, drone, xActuel++, yActuel);
                        } else {
                            DroneService.deplacerDrone(map, drone, xActuel--, yActuel);
                        }
                    }
                }
            }

        }
    }
}

