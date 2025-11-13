package adventofcode_stage_orange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rapport {
    private  List<List<Integer>> series;
    public Rapport(List<List<Integer>> series) {
        this.series = series;
    }
    public Rapport() {}
    private  boolean est_conforme(List<List<Integer>> tab) {
        //Un rapport est composé de 6 série de nombres
        //chaque serie a 5 chiffre
        if(tab.isEmpty()) {
            return false;
        }
        if (tab.size() != 6 ||  tab.get(0).size() != 5) {
            return false;
        }
        else
            return true;
    }

    public boolean est_sans_danger() {
        if(!this.est_conforme(series))
            return false;
        boolean evolution;
        int diff;

        for( int i = 0; i < this.series.size(); i++ ) {
            //Pour savoir l'évolution
            diff = this.series.get(i).get(1) - this.series.get(i).get(0);
            if(diff == 0 || Math.abs(diff) > 3)
                return false;
            evolution = diff > 0;
            //On connait l'évolution, on continu
            for( int j = 1; j < this.series.get(i).size() - 1; j++ ) {
                diff  = this.series.get(i).get(j+1) - this.series.get(i).get(j);
                if(diff == 0 || Math.abs(diff) > 3 || (diff>0) != evolution)
                    return false;
            }
        }
        return true;
    }

    public  void saisir() {
        List<List<Integer>> series = new ArrayList<>();
        System.out.println("Saiser le rapport");
        Scanner saisi = new Scanner(System.in);
        int n;

        for(int i = 0; i < 6; i++)
        {
            series.add(new ArrayList<>());
            for(int j = 0; j < 5; j++)
            {
                n = saisi.nextInt();
                series.get(i).add(n);
            }
            //System.out.println();
        }
        if(est_conforme(series))
            this.series = series;
    }

    public void affiche() {
        for (int i = 0; i < this.series.size(); i++) {
            for (int j = 0; j < this.series.get(i).size(); j++) {
                System.out.print(this.series.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
