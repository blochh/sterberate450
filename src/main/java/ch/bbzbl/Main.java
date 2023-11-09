package ch.bbzbl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Pfad zur JSON-Datei
            String jsonDateipfad = "src/main/resources/sterberateliste.json";

            // Gson-Objekt erstellen
            Gson gson = new Gson();

            // JSON-Datei einlesen und in eine Liste von Sterberate-Objekten umwandeln
            Type sterberateListeType = new TypeToken<List<Sterberate>>() {}.getType();
            Reader reader = new FileReader(jsonDateipfad);
            List<Sterberate> sterberateListe = gson.fromJson(reader, sterberateListeType);

            // Hier rufen Sie die Gui-Methode auf und übergeben die Sterberate-Liste
            GUI.KonsoleAnzeige(sterberateListe);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
