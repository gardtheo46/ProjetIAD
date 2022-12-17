package main;

import models.Case;
import models.Drone;
import service.MapService;
import service.RechercheService;
import view.MapView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Initialisation des variables
        Random random = new Random();
        List<Case> map = MapService.initMap(49,49, 20);
        Drone drone1 = new Drone(500,2,map.get(0));
        Drone drone2 = new Drone(500,2,map.get(2450));
//        Drone drone3 = new Drone(500,2,map.get(1225));
        List<Drone> drones = new ArrayList<>();
        drones.add(drone1);
        drones.add(drone2);
//        drones.add(drone3);
        do {
            RechercheService.algoISOA(map, drones);
        } while (!drone1.getCaseActuelle().equals(drone1.getCaseBase()) && !(drone2.getCaseActuelle().equals(drone2.getCaseBase())));
        MapView.mapView(map);
        System.out.println("");
        System.out.println("Drone 1 : " + drone1.getNbCiblesTuees());
        System.out.println("Drone 2 : " +drone2.getNbCiblesTuees());
//        System.out.println("Drone 3 : " +drone3.getNbCiblesTuees());
    }
}