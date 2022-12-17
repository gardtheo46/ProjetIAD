package service;

import models.Case;
import models.Drone;

import java.util.List;

public class RechercheService {

    public void algoISOA(List<Case> map  ) {
        if (Drone.isExplorer()) {
            //Examiner tout autour du robot grâce à la porté P

            //S’il y a une cible -> se rendre à la cible en s'alignant verticalement puis horizontalement, sauf s’il y a des phéromones sur la cible
            //S’il y a des phéromones , tout droit, on va à droit ou à gauche
            //S’il n’y a pas de phéromone continuer tout droit
            //Si on arrive à une extrémité de la MAP, (donc x=0 ou x=50 ou y=0 ou y=50), on repart de l’opposé d’où on vient ( on repart en diagonale du point d'extrémité)
            //        S’il est sur la cible, alors il l’a détruit (mettre à jour la valeur de la cible)

            //Une fois déplacé (un seul déplacement par coup, on augmente la phéromone de la case de + 1)

            //Chaque tour, chaque phéromone perd 0.01
        } else {
        //Tant que Lmax < ce que le drone à parcouru + ce qu’il doit parcourir pour rentrer (alignement abscisse et ordonnée)
    }

    private void distanceToBase() {
        //Tant que Lmax < ce que le drone à parcouru + ce qu’il doit parcourir pour rentrer (alignement abscisse et ordonnée)

        //Si la distance à la base est égale à distance la porté max - distance parcourut
        // porté max - (distance retour + distance parcouru)
    }
}

