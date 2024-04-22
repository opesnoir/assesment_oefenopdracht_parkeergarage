package controller;

//Stap 0: Doel, naam en studentennummer
/*
Doel: Applicatie berekent de parkeerkosten per auto in en garage en de som van alle auto's.
Naam: M. C.
Studentennummer: 500211293*/

import java.util.Scanner;

public class ParkeergarageLauncher2 {
    final static int MAXIMAAL_AANTAL_UREN = 24;
    final static int MAXIMAAL_AANTAL_UREN_STARTTARIEF = 3;
    final static double START_TARIEF = 3.75;
    final static double STANDAARD_TARIEF = 2.75;
    final static double DAG_KAART_TARIEF = 25.00;


    public static void main(String[] args) {
        //stap 0: vervolg
        System.out.println("Dit programma is gemaakt door: M. C, studentennummer: 500211293");

        //stap 1: vraag de gebruiker aantal auto's
        Scanner input = new Scanner(System.in);
        System.out.print("Hoeveel auto's hebben geparkeerd: ");
        int aantalAutos = input.nextInt();

        //stap 2: maak 3 arrays: kentekens, parkeerduur en parkeerkosten
        String[] kentekens = new String[aantalAutos];
        int[] parkeerduur = new int[aantalAutos];
        double[] parkeerkosten = new double[aantalAutos];

        //stap 3: vraag kenteken en parkeerduur
        for (int i = 0; i < aantalAutos; i++) {
            System.out.println("Auto " + (i + 1));
            System.out.print("\tKenteken: ");
            kentekens[i] = input.next();

            do {
                System.out.printf("\tGeparkeerde uren (max. %d). ", MAXIMAAL_AANTAL_UREN); //printf + final variable
                parkeerduur[i] = input.nextInt(); // array met[i]
                if (parkeerduur[i] > MAXIMAAL_AANTAL_UREN) {
                    System.out.printf("\tDe parkeerduur kan maximaal %d zijn.\n ", MAXIMAAL_AANTAL_UREN);
                }
            } while (parkeerduur[i] > MAXIMAAL_AANTAL_UREN);
        }

        //stap 4: bereken parkeerkosten dmv ingevoerde parkeerduur, sla uitkomst op in parkeerkosten[].
        for (int i = 0; i < aantalAutos; i++) {
            parkeerkosten[i] = berekenParkeergeld(parkeerduur[i]);
        }

        //stap 5: print overzicht: auto, kenteken en kosten
        System.out.println("Parkeeroverzicht");
        System.out.printf("%8s%10s%12s\n", "kenteken", "uren", "bedrag"); //eerst format, daarna hetgeen je wil formatten, in dit geval 3 woorden
        for (int i = 0; i < aantalAutos; i++) {
            System.out.printf("%8s%10d%12.0f\n", kentekens[i], parkeerduur[i], parkeerkosten[i]);
        }

        //stap 6: print som parkeerkosten van alle auto's
        double totaleParkeerKosten = berekenTotaleParkeerKosten(parkeerkosten);
        System.out.printf("Totaal van alle parkeergelden: %.2f euro." , totaleParkeerKosten);
    }

    //stap 4: bereken parkeerkosten op basis van ingevoerde parkeerduur.
    private static double berekenParkeergeld(int parkeerduur) {
        double parkeerkostenTotaal;
        //totale parkeerkosten onder 3 uur
        if (parkeerduur <= MAXIMAAL_AANTAL_UREN_STARTTARIEF) {
            parkeerkostenTotaal = parkeerduur * START_TARIEF;
        } else {
            //totale parkeerkosten eerste 3 uur
            double parkeerkostenStarttarief = MAXIMAAL_AANTAL_UREN_STARTTARIEF * START_TARIEF;
            //parkeerkosten > eerste 3 uur + overige uren
            parkeerkostenTotaal = parkeerkostenStarttarief + (parkeerduur * STANDAARD_TARIEF);
        }
        if (parkeerduur > MAXIMAAL_AANTAL_UREN) {
            parkeerkostenTotaal = DAG_KAART_TARIEF;
        }
        return parkeerkostenTotaal;
    }

    //stap 6: bereken som parkeerkosten voor alle auto's
    public static double berekenTotaleParkeerKosten(double[] parkeerkosten) {
        double som = 0.0;
        for (int i = 0; i < parkeerkosten.length; i++) {
            som += parkeerkosten[i];
        }
        return som;
    }

}
