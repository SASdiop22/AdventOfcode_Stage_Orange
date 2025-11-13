package adventofcode_stage_orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class AdventOfcodeStageOrangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventOfcodeStageOrangeApplication.class, args);

        System.out.println("Combien de rapport voulez vous saisir ?");
        Scanner saisi = new Scanner(System.in);
        int n = saisi.nextInt();
        List<Rapport> rapports = new ArrayList<>();
        System.out.println("Saiser le rapport (les niveaux seront séparé par des espaces): ");
        for(int i = 0; i < n; i++) {
            System.out.print("Rapport " + (i+1) + ": ");
            rapports.add(new Rapport());
        }

        for(Rapport rapport : rapports) {
            rapport.affiche();
            if(rapport.est_sans_danger()) {
                System.out.print(" -> Sans danger");
            }
            else {
                System.out.print(" -> En danger");
            }
            System.out.println();
        }

    }

}
