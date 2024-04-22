package controller;

//stap 0 plaats doel programma, naam en studentennummer
//Applicatiedoel, naam en studentennummer:
/*Het doel van de applicatie is om parkeerkosten te berekenen per auto, evenals de totale parkeerkosten voor alle auto's samen, die zijn geparkeerd in de parkeergarage.

Naam: M. - volledige naam invoeren bij het assessment
Studentennummer: 500211293*/


import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class ParkeergarageLauncher {

    //variabelen
    final static int MAX_AANTAL_UREN = 24;
    final static int UREN_TEGEN_START_TARIEF = 3;
    final static double START_TARIEF = 3.75;
    final static double REGULIER_TARIEF = 2.75;
    final static double DAGKAART_TARIEF = 25.00;

    public static void main(String[] args) {

        //stap 0 vervolg plaats naam en studentennummer
        System.out.println("Dit programma is gemaakt door: M. C., studentennummer: 500211293.");
        System.out.println();

        //stap 1 vraag: aantal geparkeerde auto's
        Scanner input = new Scanner(System.in);
        int aantalGeparkeerdeAutos;
        System.out.print("Hoeveel auto's hebben geparkeerd? "); //notitie voor mezelf: plaats input naast vraag [print]
        aantalGeparkeerdeAutos = input.nextInt();

        //stap 2 declareer en initialiseer arrays voor: kentekens, parkeerduur en parkeerkosten
        //declareer
        String[] kentekens;
        int[] parkeerduur;
        double[] parkeerkosten;

        //initialiseer
        kentekens = new String[aantalGeparkeerdeAutos];
        parkeerduur = new int[aantalGeparkeerdeAutos];
        parkeerkosten = new double[aantalGeparkeerdeAutos];

        //stap 3 vraag per auto: kenteken en parkeerduur
        for (int teller = 0; teller < aantalGeparkeerdeAutos; teller++) {
            int geparkeerdeAutos = teller + 1;

            System.out.println("Auto " + (geparkeerdeAutos));
            System.out.print("\tKenteken: ");
            kentekens[teller] = input.next();

            do {
                System.out.print("\tGeparkeerde uren (max. 24): ");
                parkeerduur[teller] = input.nextInt();
                if (parkeerduur[teller] > MAX_AANTAL_UREN) {
                    System.out.printf("\tDe parkeerduur kan maximaal %d uur zijn.\n", MAX_AANTAL_UREN); //notitie voor mezelf: opmaak printf
                    System.out.printf("\tGeparkeerde uren (max. %d): ", MAX_AANTAL_UREN);
                    parkeerduur[teller] = input.nextInt();
                }
            } while (parkeerduur[teller] > MAX_AANTAL_UREN);
        }

        //stap 4 sla parkeerkosten op in array: parkeerkosten[], calculatie methode: berekenParkeergeld()
        for (int teller = 0; teller < aantalGeparkeerdeAutos; teller++) {
            parkeerkosten[teller] = berekenParkeergeld(parkeerduur[teller]);
        }

        //stap 5 print parkeeroverzicht per auto met parkeerduur, kosten en totaalbedrag
        System.out.println("Parkeeroverzicht");
        System.out.printf("%8s%9s%12s\n", "kenteken", "uren", "bedrag"); //notitie voor mezelf: opmaak %s en cijfer is afstand
        for (int teller = 0; teller < aantalGeparkeerdeAutos; teller++) {
            System.out.printf("%8s%9d%12.2f\n", kentekens[teller], parkeerduur[teller], parkeerkosten[teller]);//ook hier printf
        }

        //stap 6 sla op de som van alle parkeerkosten, bereken methode: berekenTotaleParkeerKosten()
        double somParkeerkosten = berekenTotaleParkeerKosten(parkeerkosten);

        //stap 7 print de som van alle parkeerkosten
        System.out.println("Totaal van alle parkeergelden: " + somParkeerkosten + " euro.");
    }


    //maak methoden voor stap 4 en stap 6
    //stap 4 methode - bereken het parkeergeld
    public static double berekenParkeergeld(int geparkeerdeUren) {
        double totaleParkeerkosten;
        double totaleStartTariefKosten;

        if (geparkeerdeUren <= UREN_TEGEN_START_TARIEF) {
            totaleParkeerkosten = geparkeerdeUren * START_TARIEF;
        } else {
            totaleStartTariefKosten = (UREN_TEGEN_START_TARIEF * START_TARIEF);
            totaleParkeerkosten = totaleStartTariefKosten + ((geparkeerdeUren - UREN_TEGEN_START_TARIEF) * REGULIER_TARIEF);
        }
        if (geparkeerdeUren > MAX_AANTAL_UREN) {
            totaleParkeerkosten = DAGKAART_TARIEF;
        }
        return totaleParkeerkosten;
    }

    //stap 6 methode - som totale parkeerkosten berekenen (p. 228 boek)
    public static double berekenTotaleParkeerKosten(double[] parkeerkosten) {
        double som = 0.0;

        for (int teller = 0; teller < parkeerkosten.length; teller++) {
            som += parkeerkosten[teller];
        }
        return som;
    }

}
