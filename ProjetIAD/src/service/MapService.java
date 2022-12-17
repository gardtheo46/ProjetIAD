package service;

import models.Case;

import java.util.ArrayList;
import java.util.List;

public class MapService {

    public static List<Case> initMap(Integer nbCasesX, Integer nbCasesY){
        List<Case> map = new ArrayList<>();
        //Création des cases
        for (int i=0;i<=50;i++){
            for (int j=0;j<=50;j++) {
                map.add(new Case(i,j));
            }
        }
        return map;
    }












    public static Case getCase(List<Case> map, Integer x, Integer y){
        for (Case cases : map){
            if(cases.getX()==x && cases.getY()==y){
                return cases;
            }

        }
    }
}
