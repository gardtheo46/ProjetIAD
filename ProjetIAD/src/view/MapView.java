package view;

import models.Case;

import java.util.List;

import static java.lang.Math.sqrt;

public class MapView {

    public static void mapView(List<Case> map) {
        Double limiteMap = sqrt(map.size()) - 1;
        Integer limiteMapInt = limiteMap.intValue();
        for (int i = limiteMapInt; 0 <= i; i--) {
            System.out.print(" _ ");
        }
        System.out.println();

        for (int y = limiteMapInt; y >= 0; y--) {
            System.out.print('|');
            for (int x = 0; x <= limiteMapInt; x++) {
                Case cases = getCase(map, x, y);
                if (cases.isCible()) {
                    System.out.print(" * ");
                } else if (cases.isDejaPasse()) {
                    System.out.print(" ° ");
                } else {
                    System.out.print("   ");
                }
//                System.out.print(getCase(map,x,y).toString());
            }
            System.out.print('|');
            System.out.println();
        }

        for (int i = limiteMapInt; 0 <= i; i--) {
            System.out.print(" _ ");
        }
    }

    public static Case getCase(List<Case> map, Integer x, Integer y) {
        for (Case cases : map) {
            if (cases.getX() == x && cases.getY() == y) {
                return cases;
            }
        }
        return null;
    }


}
