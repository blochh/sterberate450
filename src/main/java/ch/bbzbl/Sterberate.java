package ch.bbzbl;

public class Sterberate {
    private String jahr;
    private int monat;
    private int woche_in_jahr;

    private String wochentag;
    private String sterbedatum;

    private int anz_total;

    public Sterberate() {
        // Standardkonstruktor
    }

    public Sterberate(String jahr, int monat, int woche_in_jahr, String wochentag, String sterbedatum, int anz_total) {
        this.jahr = jahr;
        this.monat = monat;
        this.woche_in_jahr = woche_in_jahr;

        this.wochentag = wochentag;
        this.sterbedatum = sterbedatum;

        this.anz_total = anz_total;
    }

    public String getJahr() {
        return jahr;
    }

    public void setJahr(String jahr) {
        this.jahr = jahr;
    }

    public int getMonat() {
        return monat;
    }

    public void setMonat(int monat) {
        this.monat = monat;
    }

    public int getWoche_in_jahr() {
        return woche_in_jahr;
    }

    public void setWoche_in_jahr(int woche_in_jahr) {
        this.woche_in_jahr = woche_in_jahr;
    }







    public String getWochentag() {
        return wochentag;
    }

    public void setWochentag(String wochentag) {
        this.wochentag = wochentag;
    }

    public String getSterbedatum() {
        return sterbedatum;
    }

    public void setSterbedatum(String sterbedatum) {
        this.sterbedatum = sterbedatum;
    }





    public int getAnz_total() {
        return anz_total;
    }

    public void setAnz_total(int anz_total) {
        this.anz_total = anz_total;
    }
}