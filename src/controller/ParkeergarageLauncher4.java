package controller;

//stap 0 doel, naam, studentennummer
/*Applicatie: berekent parkeerkosten in een parkeergarage, na het invoeren van het aantal auto's.
 Dit doet hij voor elke auto en voor alle auto's bij elkaar. */

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ParkeergarageLauncher4 {
    //declareer en initieer constante
    final static int MAXIMUM_UREN_TEGEN_START_TARIEF = 3;
    final static int MAXIMUM_UREN_TOTAAL = 24;
    final static double START_TARIEF = 3.75;
    final static double REGULIER_TARIEF = 2.75;
    final static double DAGKAART_TARIEF = 25.00;

    public static void main(String[] args) {
        //stap 0 vervolg
        System.out.println("Dit programma is gemaakt door M.C., studentennummer 500241293");
        System.out.println();

        //stap 1 vraag aantal geparkeerde auto's en sla aantal op
        Scanner input = new Scanner(System.in);
        System.out.print("Hoeveel auto's hebben geparkeerd? ");
        int aantalAutos = input.nextInt();

        //stap 2 maak opslagplaats voor inkomende data, gebruik het aantal geparkeerde auto's om de grootte van de arrays te bepalen
        String[] kentekens = new String[aantalAutos];
        int[] parkeerduur = new int[aantalAutos];
        double[] parkeerkosten = new double[aantalAutos];

        //stap 3 verzamel gegevens voor elke geparkeerde auto
        for (int i = 0; i < aantalAutos; i++) {
            System.out.println("Auto " + (i + 1));
            System.out.print("\tKenteken: ");
            kentekens[i] = input.next();
            //blijf parkeerduur vragen tot gebruiker geldige waarde invoert
            do {
                System.out.printf("\tGeparkeerde uren (max. %d): ", MAXIMUM_UREN_TOTAAL);
                parkeerduur[i] = input.nextInt();
                //bekijk of de ingevoerde parkeerduur het toegestane maximum niet overschrijdt
                if (parkeerduur[i] > MAXIMUM_UREN_TOTAAL) {
                    System.out.printf("\tDe parkeerduur kan maximaal %d uur zijn.\n", MAXIMUM_UREN_TOTAAL);
                }
            }
            //herhaal de vraag zolang de ingevoerde tijd te hoog is (en dus de while conditie waar is)
            while (parkeerduur[i] > MAXIMUM_UREN_TOTAAL);
        }

        //stap 4 sla individuele parkeerkosten op, berekend met berekenParkeergeld methode
        for (int i = 0; i < aantalAutos; i++) {
            parkeerkosten[i] = berekenParkeergeld(parkeerduur[i]);
        }

        //stap 5 print parkeeroverzicht
        System.out.println("\nParkeeroverzicht");
        System.out.printf("%8s%10s%12s\n", "kenteken", "uren", "bedrag");
        for (int i = 0; i < aantalAutos; i++) {
            //print kolom-titels met uitlijning
            System.out.printf("%8s%10d%12.2f\n", kentekens[i], parkeerduur[i], parkeerkosten[i]);
        }

        //stap 6 print de totale parkeerkosten voor alle auto's, aan de hand van de methode aan die de totale kosten uit de parkeerkosten array optelt
        double totaleKosten = berekenTotaleParkeerKosten(parkeerkosten);

        //stap 7 print de totale parkeerkosten in euro's, print bedrag met 1 cijfer achter de komma
        System.out.printf("Totaal van alle parkeergelden: %.1f euro.", totaleKosten);

    }

    //stap 4 bereken parkeerkosten op basis van parkeerduur
    public static double berekenParkeergeld(int parkeerduur) {
        double parkeerkosten = 0.0;
        if (parkeerduur <= MAXIMUM_UREN_TEGEN_START_TARIEF) {
            parkeerkosten = parkeerduur * START_TARIEF;
        } else {
            //bereken kosten voor de maximale uren tegen starttarief
            double startTariefKosten = MAXIMUM_UREN_TEGEN_START_TARIEF * START_TARIEF;
            //bereken kosten voor de overige uren tegen het reguliere tarief
            double reguliereTariefKosten = (parkeerduur - MAXIMUM_UREN_TEGEN_START_TARIEF) * REGULIER_TARIEF;
            // neem beide kostenposten bijeen tot totale parkeerkosten
            parkeerkosten = startTariefKosten + reguliereTariefKosten;
        }
        return parkeerkosten;
    }

    //stap 6 methode bereken som parkeerkosten alle auto's
    public static double berekenTotaleParkeerKosten(double[] parkeerkosten) {
        double som = 0.0;

        for (int i = 0; i < parkeerkosten.length; i++) {
            som += parkeerkosten[i];
        }
        return som;
    }
}
