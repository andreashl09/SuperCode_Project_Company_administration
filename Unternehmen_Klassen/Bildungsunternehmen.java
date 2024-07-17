package Unternehmen_Klassen;

import java.time.LocalDate;
import java.util.ArrayList;

import Enum.*;
import Kurs_Klassen.*;
import Person_Klassen.*;

public class Bildungsunternehmen {
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";

    private String name;
    private String inhaber;
    private LocalDate gruendungdatum;
    private UnternehmensKategorie unternehmensKategorie;
    private ArrayList<Teilnehmer> teilnehmerListe;
    private ArrayList<Mitarbeiter> mitarbeiterListe;
    private ArrayList<Aufgabe> aufgabenPool;
    private ArrayList<Kurs> kursListe;

    public Bildungsunternehmen(String name, String inhaber, LocalDate gruendungdatum, UnternehmensKategorie kategorie) {
        this.name = name;
        this.inhaber = inhaber;
        this.gruendungdatum = gruendungdatum;
        this.unternehmensKategorie = kategorie;
        teilnehmerListe = new ArrayList<>();
        mitarbeiterListe = new ArrayList<>();
        aufgabenPool = new ArrayList<>();
        kursListe = new ArrayList<>();
    }

    public ArrayList<Teilnehmer> getTeilnehmerListe() {
        return teilnehmerListe;
    }

    public ArrayList<Mitarbeiter> getMitarbeiterListe() {
        return mitarbeiterListe;
    }

    public ArrayList<Aufgabe> getAufgabenPool() {
        return aufgabenPool;
    }

    public void addAufgabe(Aufgabe aufgabe) {
        this.aufgabenPool.add(aufgabe);
    }

    public void addMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiterListe.add(mitarbeiter);
    }

    public void addTeilnehmer(Teilnehmer teilnehmer) {
        this.teilnehmerListe.add(teilnehmer);
    }

    public ArrayList<Kurs> getKursListe() {
        return kursListe;
    }

    public String getName() {
        return name;
    }

    public String getInhaber() {
        return inhaber;
    }

    public LocalDate getGruendungdatum() {
        return gruendungdatum;
    }

    public UnternehmensKategorie getUnternehmensKategorie() {
        return unternehmensKategorie;
    }

    public void printTeilnehmerListe() {
        for (Teilnehmer teilnehmer : teilnehmerListe) {
            System.out.println(teilnehmer.teilnehmerDaten());
        }
    }

    // ---
    public void zeigeMitarbeiterDiagramm() {
        for (Mitarbeiter mitarbeiter : mitarbeiterListe) {

            int gebuchteKurse = mitarbeiter.getBuchungen().size();
            for (int i = 0; i < gebuchteKurse * 3; i++) {

                System.out.print(ANSI_WHITE_BACKGROUND + " " + ANSI_RESET);
                System.out.print(mitarbeiter.getNachname() + "\n");
                System.out.println("");
            }
        }
    }

}
