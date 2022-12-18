package main;

import models.Case;
import models.Drone;
import service.MapService;
import service.RechercheService;
import view.MapView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialisation des variables
        List<Case> map = MapService.initMap(49, 49, 20);
        Drone drone1 = new Drone(500, 2, map.get(0));
        Drone drone2 = new Drone(500, 2, map.get(2450));
        List<Drone> drones = new ArrayList<>();
        drones.add(drone1);
        drones.add(drone2);
        // Execution de l'algorithme
        do {
            RechercheService.algoISOA(map, drones);
        } while (!(drone1.getCaseActuelle().equals(drone1.getCaseBase())) && !(drone2.getCaseActuelle().equals(drone2.getCaseBase())));
        // Affichage de la map
        MapView.mapView(map);
        // Calcul des stats
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("");
        System.out.println("***** CALCUL DES STATS *****");
        Double tauxCouverture = (Double.valueOf(MapService.getNbCasesVisitees(map)) / Double.valueOf(map.size())) * 100;
        System.out.println("Taux de couverture : " + df.format(tauxCouverture) + "%");
        System.out.println("Nombre de cibles tuées par le drone 1 : " + drone1.getNbCiblesTuees());
        System.out.println("Nombre de cibles tuées par le drone 2 : " + drone2.getNbCiblesTuees());
    }
}