package service;

import Constantes.ConstantesDeplacement;
import models.Case;
import models.Drone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.abs;

public class RechercheService {

    public static void algoISOA(List<Case> map, List<Drone> drones) {
        for (Drone drone : drones) {
            Integer xActuel = drone.getCaseActuelle().getX();
            Integer yActuel = drone.getCaseActuelle().getY();
            //S’il est sur la cible, alors il l’a détruit (mettre à jour la valeur de la cible)
            Case caseActuelle = map.get(map.indexOf(drone.getCaseActuelle()));
            if (caseActuelle.isCible()) {
                caseActuelle.setCible(false);
                drone.setCaseCible(null);
                drone.setOccupe(false);
                drone.setNbCiblesTuees(drone.getNbCiblesTuees() + 1);
            }
            if (drone.isExplorer() && !drone.isOccupe()) {
                //Examiner tout autour du robot grâce à la distance de vision
                List<Case> caseAVoir = new ArrayList<>();
                switch (drone.getDernierDeplacement()) {
                    case ConstantesDeplacement.AUCUN:
                    case ConstantesDeplacement.HAUT:
                        for (int i = 1; i <= drone.getDistanceVision(); i++) {
                            switch(i){
                                case 1:
                                    caseAVoir.add(MapService.getCase(map, xActuel, yActuel + i));
                                    break;
                                case 2:
                                    caseAVoir.add(MapService.getCase(map, xActuel-1, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+1, yActuel + i));
                                    break;
                                case 3:
                                    caseAVoir.add(MapService.getCase(map, xActuel-2, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-1, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+1, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+2, yActuel + i));
                                    break;
                                case 4:
                                    caseAVoir.add(MapService.getCase(map, xActuel-3, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-2, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-1, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+1, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+2, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+3, yActuel + i));
                                    break;
                                case 5:
                                    caseAVoir.add(MapService.getCase(map, xActuel-4, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-3, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-2, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-1, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+1, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+2, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+3, yActuel + i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+4, yActuel + i));
                                    break;
                            }
                        }
                        break;
                    case ConstantesDeplacement.BAS:
                        for (int i = 1; i <= drone.getDistanceVision(); i++) {
                            switch(i){
                                case 1:
                                    caseAVoir.add(MapService.getCase(map, xActuel, yActuel - i));
                                    break;
                                case 2:
                                    caseAVoir.add(MapService.getCase(map, xActuel-1, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+1, yActuel - i));
                                    break;
                                case 3:
                                    caseAVoir.add(MapService.getCase(map, xActuel-2, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-1, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+1, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+2, yActuel - i));
                                    break;
                                case 4:
                                    caseAVoir.add(MapService.getCase(map, xActuel-3, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-2, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-1, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+1, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+2, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+3, yActuel - i));
                                    break;
                                case 5:
                                    caseAVoir.add(MapService.getCase(map, xActuel-4, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-3, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-2, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel-1, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+1, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+2, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+3, yActuel - i));
                                    caseAVoir.add(MapService.getCase(map, xActuel+4, yActuel - i));
                                    break;
                            }
                        }
                        break;
                    case ConstantesDeplacement.GAUCHE:
                        for (int i = 1; i <= drone.getDistanceVision(); i++) {
                            switch(i){
                                case 1:
                                    caseAVoir.add(MapService.getCase(map, xActuel - i, yActuel));
                                    break;
                                case 2:
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel-1));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel+1));
                                    break;
                                case 3:
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel - 2));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel - 1));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel +1));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel +2));
                                    break;
                                case 4:
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel - 3));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel - 2));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel - 1));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel ));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel +1));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel +2));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel +3));
                                    break;
                                case 5:
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel - 4));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel - 3));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel - 2));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel - 1));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel +1));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel +2));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel +3));
                                    caseAVoir.add(MapService.getCase(map, xActuel- i, yActuel +4));
                                    break;
                            }
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
                            drone.setCaseCible(cases);
                            drone.setOccupe(true);
                            Integer distanceX = cases.getX() - drone.getCaseActuelle().getX();
                            Integer distanceY = cases.getY() - drone.getCaseActuelle().getY();
                            if (abs(distanceX) <= abs(distanceY)) {
                                // On se déplace sur l'axe Y
                                if (distanceY > 0) {
                                    DroneService.deplacerDrone(map, drone, xActuel, yActuel++);
                                    drone.setDernierDeplacement(ConstantesDeplacement.HAUT);
                                } else {
                                    DroneService.deplacerDrone(map, drone, xActuel, yActuel--);
                                    drone.setDernierDeplacement(ConstantesDeplacement.BAS);
                                }
                            } else {
                                // On se déplace sur l'axe X
                                if (distanceX > 0) {
                                    DroneService.deplacerDrone(map, drone, xActuel++, yActuel);
                                    drone.setDernierDeplacement(ConstantesDeplacement.DROITE);
                                } else {
                                    DroneService.deplacerDrone(map, drone, xActuel--, yActuel);
                                    drone.setDernierDeplacement(ConstantesDeplacement.GAUCHE);
                                }

                            }
                        }
                    }
                }
                //S’il n’y a pas de phéromone continuer tout droit
                //Si la première case est null, on est en bout de map
                if (caseAVoir.get(0) == null) {
                    switch (drone.getDernierDeplacement()) {
                        case ConstantesDeplacement.AUCUN:
                        case ConstantesDeplacement.HAUT:
                            DroneService.deplacerDrone(map, drone, xActuel, yActuel + 1);
                            break;
                        case ConstantesDeplacement.BAS:
                            DroneService.deplacerDrone(map, drone, xActuel, yActuel - 1);
                            break;
                        case ConstantesDeplacement.GAUCHE:
                            DroneService.deplacerDrone(map, drone, xActuel - 1, yActuel);
                            break;
                        case ConstantesDeplacement.DROITE:
                            DroneService.deplacerDrone(map, drone, xActuel + 1, yActuel);
                            break;
                    }
                } else {
                    if (caseAVoir.get(0).getCoefPassage().equals(0.00)) {
                        switch (drone.getDernierDeplacement()) {
                            case ConstantesDeplacement.AUCUN:
                            case ConstantesDeplacement.HAUT:
                                DroneService.deplacerDrone(map, drone, xActuel, yActuel + 1);
                                drone.setDernierDeplacement(ConstantesDeplacement.HAUT);
                                break;
                            case ConstantesDeplacement.BAS:
                                DroneService.deplacerDrone(map, drone, xActuel, yActuel - 1);
                                drone.setDernierDeplacement(ConstantesDeplacement.BAS);
                                break;
                            case ConstantesDeplacement.GAUCHE:
                                DroneService.deplacerDrone(map, drone, xActuel - 1, yActuel);
                                drone.setDernierDeplacement(ConstantesDeplacement.GAUCHE);
                                break;
                            case ConstantesDeplacement.DROITE:
                                DroneService.deplacerDrone(map, drone, xActuel + 1, yActuel);
                                drone.setDernierDeplacement(ConstantesDeplacement.DROITE);
                                break;
                        }
                    } else {
                        // On regarde la premiere case autour de lui qui n'a pas de phéromone
                        Case case1 = MapService.getCase(map, drone.getCaseActuelle().getX(), drone.getCaseActuelle().getY() + 1);
                        Case case2 = MapService.getCase(map, drone.getCaseActuelle().getX(), drone.getCaseActuelle().getY() - 1);
                        Case case3 = MapService.getCase(map, drone.getCaseActuelle().getX() + 1, drone.getCaseActuelle().getY());
                        Case case4 = MapService.getCase(map, drone.getCaseActuelle().getX() - 1, drone.getCaseActuelle().getY());
                        if (case1 != null && case1.getCoefPassage().equals(0.00)) {
                            DroneService.deplacerDrone(map, drone, case1.getX(), case1.getY());
                        } else if (case2 != null && case2.getCoefPassage().equals(0.00)) {
                            DroneService.deplacerDrone(map, drone, case2.getX(), case2.getY());
                        } else if (case3 != null && case3.getCoefPassage().equals(0.00)) {
                            DroneService.deplacerDrone(map, drone, case3.getX(), case3.getY());
                        } else if (case4 != null && case4.getCoefPassage().equals(0.00)) {
                            DroneService.deplacerDrone(map, drone, case4.getX(), case4.getY());
                        } else {
                            // Si on est ici, c'est qu'on ne s'est toujours pas déplacé, on est obligé de bouger sur la case avec le moins de phéromone
                            List<Case> cases = new ArrayList<>();
                            if (case1 != null) {
                                cases.add(case1);
                            }
                            if (case2 != null) {
                                cases.add(case2);
                            }
                            if (case3 != null) {
                                cases.add(case3);
                            }
                            if (case4 != null) {
                                cases.add(case4);
                            }
                            Collections.sort(cases, new Comparator<Case>() {
                                @Override
                                public int compare(Case o1, Case o2) {
                                    return o1.getCoefPassage().compareTo(o2.getCoefPassage());
                                }
                            });
                            DroneService.deplacerDrone(map, drone, cases.get(0).getX(), cases.get(0).getY());
                            if (case1 != null && case1.equals(cases.get(0))) {
                                drone.setDernierDeplacement(ConstantesDeplacement.HAUT);
                            } else if (case2 != null && case2.equals(cases.get(0))) {
                                drone.setDernierDeplacement(ConstantesDeplacement.BAS);
                            } else if (case3 != null && case3.equals(cases.get(0))) {
                                drone.setDernierDeplacement(ConstantesDeplacement.DROITE);
                            } else if (case4 != null && case4.equals(cases.get(0))) {
                                drone.setDernierDeplacement(ConstantesDeplacement.GAUCHE);
                            }
                        }
                    }

                }
            } else {
                if (drone.getCaseCible() != null && drone.isOccupe()) {
                    // On se dirige sur la cible
                    //Tant que Lmax < ce que le drone à parcouru + ce qu’il doit parcourir pour rentrer (alignement abscisse et ordonnée)
                    Integer distanceX = drone.getCaseCible().getX() - drone.getCaseActuelle().getX();
                    Integer distanceY = drone.getCaseCible().getY() - drone.getCaseActuelle().getY();
                    if (abs(distanceX) <= abs(distanceY)) {
                        // On se déplace sur l'axe Y
                        if (distanceY > 0) {
                            DroneService.deplacerDrone(map, drone, xActuel, yActuel + 1);
                            drone.setDernierDeplacement(ConstantesDeplacement.HAUT);
                        } else {
                            DroneService.deplacerDrone(map, drone, xActuel, yActuel - 1);
                            drone.setDernierDeplacement(ConstantesDeplacement.BAS);
                        }
                    } else {
                        // On se déplace sur l'axe X
                        if (distanceX > 0) {
                            DroneService.deplacerDrone(map, drone, xActuel + 1, yActuel);
                            drone.setDernierDeplacement(ConstantesDeplacement.DROITE);
                        } else {
                            DroneService.deplacerDrone(map, drone, xActuel - 1, yActuel);
                            drone.setDernierDeplacement(ConstantesDeplacement.BAS);
                        }
                    }
                } else {
                    // On rentre
                    //Tant que Lmax < ce que le drone à parcouru + ce qu’il doit parcourir pour rentrer (alignement abscisse et ordonnée)
                    Integer distanceX = drone.getCaseBase().getX() - drone.getCaseActuelle().getX();
                    Integer distanceY = drone.getCaseBase().getY() - drone.getCaseActuelle().getY();
                    if (abs(distanceX) <= abs(distanceY)) {
                        // On se déplace sur l'axe Y
                        if (distanceY > 0) {
                            DroneService.deplacerDrone(map, drone, xActuel, yActuel + 1);
                            drone.setDernierDeplacement(ConstantesDeplacement.HAUT);

                        } else {
                            DroneService.deplacerDrone(map, drone, xActuel, yActuel - 1);
                            drone.setDernierDeplacement(ConstantesDeplacement.BAS);
                        }
                    } else {
                        // On se déplace sur l'axe X
                        if (distanceX > 0) {
                            DroneService.deplacerDrone(map, drone, xActuel + 1, yActuel);
                            drone.setDernierDeplacement(ConstantesDeplacement.DROITE);
                        } else {
                            DroneService.deplacerDrone(map, drone, xActuel - 1, yActuel);
                            drone.setDernierDeplacement(ConstantesDeplacement.GAUCHE);
                        }
                    }
                }
            }
            //Chaque tour, chaque phéromone perd 0.01
            MapService.reductionPheromone(map);
        }
    }
}

