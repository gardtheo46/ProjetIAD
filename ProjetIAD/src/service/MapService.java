package service;

import models.Case;

import java.util.ArrayList;
import java.util.List;

public class MapService {

    public List<Case> initMap(Integer nbCasesX, Integer nbCasesY){
        List<Case> map = new ArrayList<>();
        //Création des cases
        for (int i=0;i<=50;i++){
            for (int j=0;j<=50;j++) {
                map.add(new Case(i,j));
            }
        }
        return map;
    }

    public Case getCase()
}
