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
    /*@Test
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
        rechner.calculateTotalDeathsForYear(sterberateListe, 2020);

        // Überprüfe, ob die Ausgabe den Erwartungen entspricht
        assertEquals("Ungültiges Jahr angegeben", outContent.toString().trim());

        // Setze System.out zurück
        System.setOut(System.out);
    }*/
}