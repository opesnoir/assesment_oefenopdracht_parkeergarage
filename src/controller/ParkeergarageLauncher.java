package controller;

//Applicatiedoel, naam en studentennummer:
/*Het doel van de applicatie is om parkeerkosten te berekenen per auto, evenals de totale parkeerkosten voor alle auto's samen, die zijn geparkeerd in de parkeergarage.

Naam: M. - volledige naam invoeren bij het assessment
Studentennummer: 500211293*/


import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class ParkeergarageLauncher {

    public static void main(String[] args) {
        //variabelen
        final int MAX_AANTAL_UREN = 24;

        //stap 0
        System.out.println("Dit programma is gemaakt door: M. C., studentennummer: 500211293.");
        System.out.println();

        //stap 1
        Scanner input = new Scanner(System.in);
        int aantalGeparkeerdeAutos;
        System.out.print("Hoeveel auto's hebben geparkeerd? "); // plaats input naast vraag [print]
        aantalGeparkeerdeAutos = input.nextInt();

        //stap 2
        //declareer
        String[] kentekens;
        int[] parkeerduur;
        double[] parkeerkosten;

        //initialiseer
        kentekens = new String[aantalGeparkeerdeAutos];
        parkeerduur = new int[aantalGeparkeerdeAutos];
        parkeerkosten = new double[aantalGeparkeerdeAutos];

        //stap 3
        for (int i = 0; i < aantalGeparkeerdeAutos; i++) {
            int geparkeerdeAutos = i + 1;

            System.out.println("Auto " + (geparkeerdeAutos));
            System.out.print("\t Kenteken: ");
            kentekens[i] = input.next();

            System.out.print("\tGeparkeerde uren (max. 24): ");
            parkeerduur[i] = input.nextInt();

            if (parkeerduur[i] > MAX_AANTAL_UREN) {
                System.out.println("De geparkeerduur kan maximaal 24 uur zijn. ");
            }


        }
    }
}
