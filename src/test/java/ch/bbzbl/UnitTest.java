package ch.bbzbl;
import ch.bbzbl.Rechner;
import ch.bbzbl.Sterberate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

class UnitTest {

    @Test
    void testCalculateTotalDeathsForYear() {
        // Erstelle eine Beispiel-Liste von Sterberaten
        Sterberate sterberate1 = new Sterberate("2021", 1, 5, "Montag", "01.01.2021", 10);
        Sterberate sterberate2 = new Sterberate("2021", 1, 6, "Dienstag", "02.01.2021", 15);
        Sterberate sterberate3 = new Sterberate("2022", 1, 1, "Montag", "01.01.2022", 20);
        Sterberate sterberate4 = new Sterberate("2022", 1, 2, "Dienstag", "02.01.2022", 25);

        List<Sterberate> sterberateListe = Arrays.asList(sterberate1, sterberate2, sterberate3, sterberate4);

        // Erstelle eine Instanz der Klasse Rechner
        Rechner rechner = new Rechner();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Rufe die Funktion auf
        rechner.calculateTotalDeathsForYear(sterberateListe, 2021);

        // Überprüfe, ob die Ausgabe den Erwartungen entspricht
        assertEquals("Gesamtzahl der Todesfälle im Jahr 2021: 25", outContent.toString().trim());

        // Setze System.out zurück
        System.setOut(System.out);
    }

    @Test
    void testCalculateTotalDeathsForYear_InvalidYear() {
        // Erstelle eine Beispiel-Liste von Sterberaten
        Sterberate sterberate1 = new Sterberate("2021", 1, 5, "Montag", "01.01.2021", 10);
        Sterberate sterberate2 = new Sterberate("2021", 1, 6, "Dienstag", "02.01.2021", 15);
        Sterberate sterberate3 = new Sterberate("2022", 1, 1, "Montag", "01.01.2022", 20);
        Sterberate sterberate4 = new Sterberate("2022", 1, 2, "Dienstag", "02.01.2022", 25);

        List<Sterberate> sterberateListe = Arrays.asList(sterberate1, sterberate2, sterberate3, sterberate4);

        // Erstelle eine Instanz der Klasse Rechner
        Rechner rechner = new Rechner();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Rufe die Funktion mit einem ungültigen Jahr auf
        rechner.calculateTotalDeathsForYear(sterberateListe, 2003);

        // Überprüfe, ob die Ausgabe den Erwartungen entspricht
        assertEquals("Ungültiges Jahr angegeben", outContent.toString().trim());

        // Setze System.out zurück
        System.setOut(System.out);
    }

    @Test
    void testFilterByWochentag() {
        // Erstelle eine Beispiel-Liste von Sterberaten
        Sterberate sterberate1 = new Sterberate("2021", 1, 5, "Montag", "01.01.2021", 10);
        Sterberate sterberate2 = new Sterberate("2021", 1, 6, "Dienstag", "02.01.2021", 15);


        List<Sterberate> sterberateListe = Arrays.asList(sterberate1, sterberate2);

        // Erstelle eine Instanz der Klasse Rechner
        Rechner rechner = new Rechner();

        // Setze den Standardausgabestrom um, um die Konsolenausgabe zu erfassen
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Rufe die Funktion auf
        rechner.filterByWochentag(sterberateListe, "Montag");

        // Überprüfe, ob die Ausgabe den Erwartungen entspricht
        assertEquals("Montag (2021) : 10", outContent.toString().trim());

        // Setze System.out zurück
        System.setOut(System.out);


    }

    @Test
    void testFilterByWochentag_InvalidWochentag() {
        // Erstelle eine Beispiel-Liste von Sterberaten
        Sterberate sterberate1 = new Sterberate("2021", 1, 5, "Montag", "01.01.2021", 10);
        Sterberate sterberate2 = new Sterberate("2021", 1, 6, "Dienstag", "02.01.2021", 15);


        List<Sterberate> sterberateListe = Arrays.asList(sterberate1, sterberate2);

        // Erstelle eine Instanz der Klasse Rechner
        Rechner rechner = new Rechner();

        // Setze den Standardausgabestrom um, um die Konsolenausgabe zu erfassen
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));



        // Rufe die Funktion mit einem nicht vorhandenen Wochentag auf
        rechner.filterByWochentag(sterberateListe, "Mentige");

        // Überprüfe, ob eine Fehlermeldung ausgegeben wird
        assertTrue(outContent.toString().contains("Dieser Wochentag existiert nicht"));

        // Setze System.out zurück
        System.setOut(System.out);
    }


    @Test
    void testFindMaxWeekValueForYear() {
        Sterberate sterberate1 = new Sterberate("2021", 1, 5, "Montag", "01.01.2021", 10);
        Sterberate sterberate2 = new Sterberate("2021", 2, 6, "Dienstag", "02.01.2021", 15);
        Sterberate sterberate3 = new Sterberate("2021", 3, 7, "Montag", "01.02.2021", 10);

        List<Sterberate> sterberateListe = Arrays.asList(sterberate1, sterberate2, sterberate3);

        Rechner rechner = new Rechner();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        rechner.findMaxWeekValueForYear(sterberateListe, 2021);

        String[] expectedLines = {
                "Woche 5 = 10 (Anzahl Tode)",
                "Woche 6 = 15 (Anzahl Tode)",
                "Woche 7 = 10 (Anzahl Tode)",
                "Die Woche mit dem Höchsten Wert war: Woche 6 = 15"
        };

        String[] actualLines = outContent.toString().trim().split("\n");

        // Überprüfe jede Zeile separat
        for (int i = 0; i < Math.min(expectedLines.length, actualLines.length); i++) {
            assertEquals(expectedLines[i], actualLines[i].trim());
        }

        // Überprüfe, ob die Anzahl der Zeilen übereinstimmt
        assertEquals(expectedLines.length, actualLines.length);

        System.setOut(System.out);
    }

    @Test
    void testFindMaxWeekValueForYear_InvalidYear() {
        Sterberate sterberate1 = new Sterberate("2020", 1, 5, "Montag", "01.01.2020", 10);
        Sterberate sterberate2 = new Sterberate("2020", 2, 6, "Dienstag", "02.01.2020", 15);

        List<Sterberate> sterberateListe = Arrays.asList(sterberate1, sterberate2);

        Rechner rechner = new Rechner();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        rechner.findMaxWeekValueForYear(sterberateListe, 2003);

        assertEquals("Jahr ist ungültig", outContent.toString().trim());

        System.setOut(System.out);
    }
}












