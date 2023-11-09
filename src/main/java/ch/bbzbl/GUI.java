package ch.bbzbl;

import java.util.List;
import java.util.Scanner;

public class GUI {

    /**
     * Diese Methode zeigt ein Menü zur Analyse von Sterbedaten in der Konsole an und ruft entsprechende
     * Methoden des `Rechner`-Objekts auf, um die gewählte Analyse durchzuführen.
     *
     * @param sterberateListe   Die Liste der Sterberaten, die analysiert werden sollen.
     */
    public static void KonsoleAnzeige(List<Sterberate> sterberateListe) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n∏=== Sterbedaten-Analyse-Menü ===");
        System.out.println("\n=== Sterbedaten-Analyse-Menü ===");
        System.out.println("1. Filtern nach Wochentag");
        System.out.println("2. Höchster Wert der Wochen eines Jahres");
        System.out.println("3. Gesamtzahl der Todesfälle in einem Jahr");
        System.out.println("4. Beenden");
        System.out.print("Bitte wählen Sie eine Option (1/2/3/4): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Verbrauche das Zeilenende nach der Eingabe.

        Rechner rechner = new Rechner();

        switch (choice) {
            case 1:
                System.out.print("Geben Sie den gewünschten Wochentag ein (z.B. 'Mi'): ");
                String targetWochentag = scanner.nextLine();
                rechner.filterByWochentag(sterberateListe, targetWochentag);
                break;
            case 2:
                System.out.print("Geben Sie das Jahr ein, für das Sie den höchsten Wochenwert ermitteln möchten: ");
                int year = scanner.nextInt();
                rechner.findMaxWeekValueForYear(sterberateListe, year);
                break;
            case 3:
                System.out.print("Geben Sie das Jahr ein, für das Sie die Gesamtzahl der Todesfälle ermitteln möchten: ");
                int targetYear = scanner.nextInt();
                rechner.calculateTotalDeathsForYear(sterberateListe, targetYear);
                break;
            case 4:
                System.out.println("Das Programm wird beendet.");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Ungültige Auswahl. Bitte wählen Sie eine der verfügbaren Optionen (1/2/3/4).");
        }
    }
}
