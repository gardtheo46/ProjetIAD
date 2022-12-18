package main;

import models.Case;
import models.Drone;
import service.MapService;
import service.RechercheService;
import view.MapView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Initialisation des variables
        Random random = new Random();
        Double tauxCouvertureTotal = 0.00;
        Integer nbCiblesTueesTotal = 0;
//        drones.add(drone3);
        for (int i = 0; i < 100;i++) {
            List<Case> map = MapService.initMap(49,49, 20);
            Drone drone1 = new Drone(500,2,map.get(0));
            Drone drone2 = new Drone(500,2,map.get(490));
            Drone drone3 = new Drone(500,2,map.get(980));
            Drone drone4 = new Drone(500,2,map.get(1470));
            Drone drone5 = new Drone(500,2,map.get(1960));
            Drone drone6 = new Drone(500,2,map.get(2450));
            List<Drone> drones = new ArrayList<>();
            drones.add(drone1);
            drones.add(drone2);
            drones.add(drone3);
            drones.add(drone4);
            drones.add(drone5);
            drones.add(drone6);
            do {
                RechercheService.algoISOA(map, drones);
            } while (!(drone1.getCaseActuelle().equals(drone1.getCaseBase())) && !(drone2.getCaseActuelle().equals(drone2.getCaseBase())) && !(drone3.getCaseActuelle().equals(drone3.getCaseBase())) && !(drone4.getCaseActuelle().equals(drone4.getCaseBase())) && !(drone5.getCaseActuelle().equals(drone5.getCaseBase())) && !(drone6.getCaseActuelle().equals(drone6.getCaseBase())));
//            MapView.mapView(map);
            Double tauxCouverture = (Double.valueOf(MapService.getNbCasesVisitees(map)) / Double.valueOf(map.size()))*100;
            tauxCouvertureTotal+= tauxCouverture;
            nbCiblesTueesTotal += drone1.getNbCiblesTuees()+drone2.getNbCiblesTuees()+drone3.getNbCiblesTuees()+drone4.getNbCiblesTuees()+drone5.getNbCiblesTuees();
            System.out.println(i+" passage(s)");
        }
//        do {
//            RechercheService.algoISOA(map, drones);
//        } while (!drone1.getCaseActuelle().equals(drone1.getCaseBase()) && !(drone2.getCaseActuelle().equals(drone2.getCaseBase())));
//       MapView.mapView(map);

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("");
        System.out.println("***** CALCUL DE STATS *****");
        System.out.println("Taux de couverture moyen : "+df.format(tauxCouvertureTotal/100)+"%");
        System.out.println("Nombre de cibles neutralisées moyen : "+nbCiblesTueesTotal/100);
//        Double tauxCouverture = (Double.valueOf(MapService.getNbCasesVisitees(map)) / Double.valueOf(map.size()))*100;

//        System.out.println("Taux de couverture : "+df.format(tauxCouverture)+"%");
//        System.out.println("Nombre de cibles tuées par le drone 1 : "+drone1.getNbCiblesTuees());
//        System.out.println("Nombre de cibles tuées par le drone 1 : "+drone2.getNbCiblesTuees());
//        System.out.println("Drone 3 : " +drone3.getNbCiblesTuees());
    }
}