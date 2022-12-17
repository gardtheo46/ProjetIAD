package main;

import models.Case;
import models.Drone;
import service.MapService;
import view.MapView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Case> map = MapService.initMap(50,50, 20);
        MapView.mapView(map,50,50);
    }
}