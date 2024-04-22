package controller;


import java.util.Scanner;

//stap 0 doel, naam, studentennummer
/*Applicatiedoel: De parkeerkosten berekenen in een parkeergarage, voor zowel een auto als alle auto's, die geparkeerd zijn*/
public class ParkeergarageLauncher3 {

    final static int MAXIMUM_UREN_START_TARIEF = 3;
    final static int MAXIMUM_PARKEER_UREN = 24;
    final static double START_TARIEF = 3.75;
    final static double REGULIER_TARIEF = 2.75;
    final static double DAG_KAART_TARIEF = 25.00;

    public static void main(String[] args) {
        //stap 0 vervolg
        System.out.println("Dit programma is gemaakt door M.C., studentennummer: 500241293.");
        System.out.println();

        // initialiseer en declareer scanner
        Scanner input = new Scanner(System.in);

        //stap 1 - vraag benodigde opslag grootte
        System.out.print("Hoeveel auto's hebben geparkeerd? ");
        int aantalAutos = input.nextInt();

        //stap 2 - maak gegevens opslag
        String[] kentekens = new String[aantalAutos];
        int[] parkeerduur = new int[aantalAutos];
        double[] parkeerkosten = new double[aantalAutos];

        //stap 3 - vraag gegevens op voor elke auto, sla op in desbetreffende array
        for (int i = 0; i < aantalAutos; i++) {
            System.out.println("Auto " + (i + 1));
            System.out.print("\tKenteken: ");
            kentekens[i] = input.next();

            do {
                System.out.printf("\tGeparkeerde uren (max. %d): ", MAXIMUM_PARKEER_UREN);
                parkeerduur[i] = input.nextInt();
                //toets gegevensinvoer parkeerduur
                if (parkeerduur[i] > MAXIMUM_PARKEER_UREN) {
                    System.out.printf("\tDe parkeerduur kan maximaal %d zijn.\n", MAXIMUM_PARKEER_UREN);
                }
            } while (parkeerduur[i] > MAXIMUM_PARKEER_UREN);
        }

        //stap 4 sla parkeerkosten die worden berekend met de methode
        for (int i = 0; i < aantalAutos; i++) {
            parkeerkosten[i] = berekenParkeergeld(parkeerduur[i]);
        }

        //stap 5
        System.out.println("Parkeeroverzicht ");
        System.out.printf("%8s%10s%12s\n", "kenteken", "uren", "bedrag");
        for (int i = 0; i < aantalAutos; i++) {
            System.out.printf("%8s%10d%12.2f\n", kentekens[i], parkeerduur[i], parkeerkosten[i]);
        }
        //stap 6
        System.out.printf("Totaal van alle parkeergelden: %.2f euro.", berekenTotaleParkeerKosten(parkeerkosten));
    }

    //stap 4 methode - bereken de totale parkeerkosten op basis van parkeerduur
    public static double berekenParkeergeld(int parkeerduur) {
        double parkeerkosten = 0.0;

        if (parkeerduur <= MAXIMUM_UREN_START_TARIEF) {
            parkeerkosten = parkeerduur * START_TARIEF;
        } else {
            //bereken kosten voor het maximale uren tegen starttarief
            double parkeerkostenStarttarief = MAXIMUM_UREN_START_TARIEF * START_TARIEF;
            //bereken kosten voor de overige uren tegen het reguliere tarief
            double parkeerkostenReguliertarief = (parkeerduur - MAXIMUM_UREN_START_TARIEF) * REGULIER_TARIEF;
            //totaal van beide kosteposten
            parkeerkosten = parkeerkostenStarttarief + parkeerkostenReguliertarief;
        }
        return parkeerkosten;
    }

    //stap 6 som parkeerkosten van alle auto's
    public static double berekenTotaleParkeerKosten(double[] parkeerkosten) {
        double som = 0.0;

        for (int i = 0; i < parkeerkosten.length; i++) {
            som += parkeerkosten[i];
        }
        return som;
    }

}
