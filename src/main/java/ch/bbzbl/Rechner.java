package ch.bbzbl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rechner {

    /**
     * Diese Methode filtert Sterberaten nach einem bestimmten Wochentag und zeigt die Summe der Todesfälle pro Jahr an.
     *
     * @param sterberateListe   Die Liste der Sterberaten, die analysiert werden sollen.
     * @param targetWochentag   Der Wochentag, nach dem gefiltert werden soll (z.B. "Mo" für Montag).
     */
    public void filterByWochentag(List<Sterberate> sterberateListe, String targetWochentag) {
        Map<String, Integer> yearToDeathCount = sterberateListe.stream()
                .filter(sterberate -> sterberate.getWochentag().equals(targetWochentag))
                .collect(Collectors.groupingBy(Sterberate::getJahr,
                        Collectors.summingInt(Sterberate::getAnz_total)));

        yearToDeathCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    String year = entry.getKey();
                    int deathCount = entry.getValue();
                    System.out.println(targetWochentag + " (" + year + ") : " + deathCount);
                });
    }

    /**
     * Diese Methode findet die Woche in einem bestimmten Jahr mit den meisten Todesfällen.
     *
     * @param sterberateListe   Die Liste der Sterberaten, die analysiert werden sollen.
     * @param year              Das Jahr, für das die höchste Todesfallwoche gefunden werden soll.
     */
    public void findMaxWeekValueForYear(List<Sterberate> sterberateListe, int year) {
        Map<Integer, Integer> weekToDeathCount = sterberateListe.stream()
                .filter(sterberate -> Integer.parseInt(sterberate.getJahr()) == year)
                .collect(Collectors.groupingBy(Sterberate::getWoche_in_jahr,
                        Collectors.summingInt(Sterberate::getAnz_total)));

        weekToDeathCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    int week = entry.getKey();
                    int deathCount = entry.getValue();
                    System.out.println("Woche " + week + " = " + deathCount + " (Anzahl Tode)");
                });

        int maxDeathCount = weekToDeathCount.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        int maxWeek = weekToDeathCount.entrySet().stream()
                .filter(entry -> entry.getValue() == maxDeathCount)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);

        System.out.println("Die Woche mit dem Höchsten Wert war: Woche " + maxWeek + " = " + maxDeathCount);
    }

    /**
     * Diese Methode berechnet die Gesamtzahl der Todesfälle in einem bestimmten Jahr.
     *
     * @param sterberateListe   Die Liste der Sterberaten, die analysiert werden sollen.
     * @param targetYear        Das Jahr, für das die Gesamtzahl der Todesfälle ermittelt werden soll.
     */
    public static void calculateTotalDeathsForYear(List<Sterberate> sterberateListe, int targetYear) {
        int totalDeaths = sterberateListe.stream()
                .filter(sterberate -> Integer.parseInt(sterberate.getJahr()) == 2022 )
                .mapToInt(Sterberate::getAnz_total)
                .sum();

        System.out.println("Gesamtzahl der Todesfälle im Jahr " + targetYear + ": " + totalDeaths);
    }
}
