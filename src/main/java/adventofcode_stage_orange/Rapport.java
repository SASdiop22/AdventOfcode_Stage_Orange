package adventofcode_stage_orange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rapport {
    private  List<Integer> niveaux = new ArrayList<>();
    public Rapport() {
        do{
            this.niveaux.clear(); //Pour enlever les anciens niveaux (mauvais format)
            this.saisir();
        }
        while(!est_conforme());
    }

    private  boolean est_conforme() {
        //On verifie si on a  au moins 2 niveaux
        if (niveaux.isEmpty() || niveaux.size() <2) {
            System.out.println("Format invalide");
            return false;
        }
        return true;
    }
    public boolean est_sans_danger() {
        boolean evolution;
        int diff;
        diff = this.niveaux.get(1) - this.niveaux.get(0);
        if(diff == 0 || Math.abs(diff) > 3)
            return false;
        evolution = diff > 0;
        //On connait l'évolution, on continu
        for( int j = 1; j < this.niveaux.size() - 1; j++ ) {
            diff  = this.niveaux.get(j+1) - this.niveaux.get(j);
            if(diff == 0 || Math.abs(diff) > 3 || (diff>0) != evolution)
                return false;
        }
        return true;
    }

    public  void saisir() {
        Scanner saisi = new Scanner(System.in);
        int n;
        String ligne = saisi.nextLine();
        String[] nombres = ligne.trim().split("\\s+");

        for(String nombre : nombres) {
            try {
                this.niveaux.add(Integer.parseInt(nombre));
            } catch (NumberFormatException e) {
                return;
            }
        }

    }

    public void affiche() {
        for (int i = 0; i < niveaux.size(); i++) {
            System.out.print(this.niveaux.get(i) + " ");
        }
    }
}
