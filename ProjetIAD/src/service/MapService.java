package service;

import models.Case;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapService {

    public static List<Case> initMap(Integer nbCasesX, Integer nbCasesY, Integer nbCibles) {
        List<Case> map = new ArrayList<>();
        Random random = new Random();
        int xCibles, yCibles;

        //Création des cases
        for (int i = 0; i <= nbCasesX; i++) {
            for (int j = 0; j <= nbCasesY; j++) {
                map.add(new Case(i, j));
            }
        }

        while (nbCibles != 0) {
            xCibles = random.nextInt(nbCasesX + 1);
            yCibles = random.nextInt(nbCasesX + 1);
            if (!getCase(map, xCibles, yCibles).isCible()) {
                getCase(map, xCibles, yCibles).setCible(true);
                nbCibles--;
            }
        }

        return map;
    }

    public static Case getCase(List<Case> map, Integer x, Integer y) {
        for (Case cases : map) {
            if (cases.getX() == x && cases.getY() == y) {
                return cases;
            }
        }
        return null;
    }

    public static void reductionPheromone(List<Case> map) {
        for (Case cases : map) {
            if (!cases.getCoefPassage().equals(0.00)) {
                cases.setCoefPassage(cases.getCoefPassage() - 0.01);
            }
        }
    }

    public static Integer getNbCasesVisitees(List<Case> map) {
        Integer nbCasesVisitees = 0;
        for (Case cases : map) {
            if (cases.isDejaPasse()) {
                nbCasesVisitees++;
            }
        }
        return nbCasesVisitees;
    }
}
