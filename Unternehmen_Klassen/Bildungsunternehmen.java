package Unternehmen_Klassen;

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
    private ArrayList<Modul> modulListe;

    public Bildungsunternehmen(String name, String inhaber, LocalDate gruendungdatum, UnternehmensKategorie kategorie) {
        this.name = name;
        this.inhaber = inhaber;
        this.gruendungdatum = gruendungdatum;
        this.unternehmensKategorie = kategorie;
        teilnehmerListe = new ArrayList<>();
        mitarbeiterListe = new ArrayList<>();
        aufgabenPool = new ArrayList<>();
        kursListe = new ArrayList<>();
        modulListe = new ArrayList<>();

    }

    public ArrayList<Modul> getModulListe() {
        return modulListe;
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

    public void addModulZuListe(Modul modul) {
        this.modulListe.add(modul);
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

    public double[][] vergleichKursbewertungSterne() {
        int index = 0;
        double[][] kursbewertung = new double[kursListe.size()][2];

        for (Kurs kurs : kursListe) {
            kursbewertung[index][0] = index;
            kursbewertung[index][1] = kurs.ermittleKursbewertung();
            index++;

        }
        return sortiereArray(kursbewertung);

    }

    public double[][] vergleichKursbewertungTage() {
        int index = 0;
        double[][] kursbewertung = new double[kursListe.size()][2];
        for (Kurs kurs : kursListe) {
            kursbewertung[index][0] = index;
            kursbewertung[index][1] = kurs.ermittleDurchschnittTage();
            index++;
        }
        return sortiereArray(kursbewertung);
    }

    public double[][] sortiereArray(double[][] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i][1] < array[i + 1][1]) {
                double speicherZwischen = array[i][1];
                array[i][1] = array[i + 1][1];
                array[i + 1][1] = speicherZwischen;

                speicherZwischen = array[i][0];
                array[i][0] = array[i + 1][0];
                array[i + 1][0] = speicherZwischen;
            }
        }
        return array;
    }

    public void KursbewertungSterne() {
        double[][] array = vergleichKursbewertungSterne();

        int arrayMax = array.length - 1;
        System.out.println("Kursbewertung nach Sternen:");
        System.out.println("Bester Kurs: " + kursListe.get((int) array[0][0]).getId()
                + " mit einer durchschnittlicher Bewertung von: " + (Math.round(10 * array[0][1])) / 10.0);
        ;
        System.out.println("Schlechtester Kurs: " + kursListe.get((int) array[arrayMax][0]).getId()
                + " mit einer durchschnittlicher Bewertung von: " + (Math.round(10 * array[arrayMax][1])) / 10.0);
    }

    public void KursbewertungTage() {
        double[][] array = vergleichKursbewertungTage();
        int arrayMax = array.length - 1;
        System.out.println("Kursbewertung nach Vermittlungsdauer in Tagen:");
        System.out.println("Bester Kurs: " + kursListe.get((int) array[arrayMax][0]).getId()
                + " mit durchschnittlichen: " + (Math.round(10 * array[arrayMax][1])) / 10.0
                + " Tagen bis zur Vermittlung");
        System.out.println("Schlechtester Kurs: " + kursListe.get((int) array[0][0]).getId()
                + " mit durchschnittlichen: " + (Math.round(10 * array[0][1])) / 10.0 + " Tagen bis zur Vermittlung");
    }

    public void printBewertungen() {
        System.out.println("Bewertungen Kurse:");
        System.out.println("---------------------------------------------");
        KursbewertungSterne();
        System.out.println("---------------------------------------------");
        KursbewertungTage();
        System.out.println("---------------------------------------------");
    }

    public void printAlleKurse() {
        for (Kurs kurs : kursListe) {
            kurs.printKursPlusModule();
            System.out.println("");
        }
    }

    public void printAufgabenListe() {
        for (Aufgabe aufgabe : aufgabenPool) {
            System.out.println(aufgabe.toString());
        }
    }

    public void printModulListe() {
        for (Modul modul : modulListe) {
            System.out.println(modul.toString());
        }
    }
}
