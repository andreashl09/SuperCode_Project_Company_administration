package Unternehmen_Klassen;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

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

    public ArrayList<Kurs> getKursListe() {
        return kursListe;
    }

    public void addAufgabe(Aufgabe aufgabe) {
        this.aufgabenPool.add(aufgabe);
    }

    public void addMitarbeiter(Mitarbeiter mitarbeiter) {
        for (Mitarbeiter mitarbeiters : mitarbeiterListe) {
            if (mitarbeiters == mitarbeiter)
                throw new IllegalArgumentException("Mitarbeiter bereits vorhanden!");
        }
        this.mitarbeiterListe.add(mitarbeiter);
    }

    public void addTeilnehmer(Teilnehmer teilnehmer) {
        this.teilnehmerListe.add(teilnehmer);
    }

    public void addKurs(Kurs newKurs) {
        for (Kurs kurs : kursListe) {
            if (kurs == newKurs)
                throw new IllegalArgumentException("Kurs bereits vorhanden!");
        }
        this.kursListe.add(newKurs);
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

    public void isTeilnehmerInAnderenKurs(Teilnehmer teilnehmer) {
        for (Kurs kurs : kursListe) {
            for (Teilnehmer teilnehmend : kurs.getTeilnehmerListe()) {
                if (teilnehmend == teilnehmer)
                    throw new IllegalArgumentException("Der Teilnehmer ist schon einem Kurs schon zugeordnet!");
            }
        }
    }

    // ---
    public void zeigeMitarbeiterDiagramm() {
        ClearConsole();
        System.out.println("Mitarbeiter Auswertung gegebene Module: \n");
        mitarbeiterListe.sort(
                Comparator.comparingInt((Mitarbeiter mitarbeiter) -> mitarbeiter.getBuchungen().size()).reversed());
        for (Mitarbeiter mitarbeiter : mitarbeiterListe) {
            // System.out.println(mitarbeiter.getNachname() + " " +
            // mitarbeiter.getBuchungen().size());
            int gebuchteKurse = mitarbeiter.getBuchungen().size();
            if (gebuchteKurse == 0) {
                System.out.print("|");
            } else {
                for (int i = 0; i < gebuchteKurse * 3; i++) {

                    System.out.print(ANSI_WHITE_BACKGROUND + " " + ANSI_RESET);
                }
            }

            System.out.print(" " + mitarbeiter.getVorname() + " " + mitarbeiter.getNachname());
            System.out.print(" | Module: " + gebuchteKurse + "\n");
            System.out.println("");
        }
    }
    public static void ClearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void vergleichKursbewertung() {
        int[][] kursbewertung = new int[kursListe.size()][2];
        for (int i = 0; i < kursListe.size(); i++) {
            for (Kurs kurs : kursListe) {
                kursbewertung[i][0] = kurs.getId();
                kursbewertung[i][1] = kurs.ermittleKursbewertung();
            }
        }
        
    }
}
