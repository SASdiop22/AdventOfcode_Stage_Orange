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

        Rapport rapport = new Rapport();
        rapport.saisir();
        rapport.affiche();
    }

}
