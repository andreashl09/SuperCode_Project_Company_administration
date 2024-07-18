package Kurs_Klassen;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import Enum.*;
import Person_Klassen.*;
import Unternehmen_Klassen.*;

public class Kurs {
    private static int kursIdCounter;
    private int id;
    private String name;
    private LocalDate startKurs;
    private LocalDate endeKurs;
    private int anzahlKurstage = 0;
    private ArrayList<Modul> module;
    private ArrayList<Teilnehmer> teilnehmerListe;
    private ArrayList<Mitarbeiter> mitarbeiterse;
    private final int MAX_TEILNEHMER = 8;
    private Bildungsunternehmen unternehmen;
    private Kategorie kategorie;

    public Kurs(String name, LocalDate startKurs, Kategorie kategorie, Bildungsunternehmen unternehmen) {
        this.kategorie = kategorie;
        this.id = kursIdCounter;
        kursIdCounter++;
        this.unternehmen = unternehmen;
        this.name = name;
        this.startKurs = startKurs;
        this.endeKurs = startKurs;
        module = new ArrayList<>();
        teilnehmerListe = new ArrayList<>();
        mitarbeiterse = new ArrayList<>();
    }

    public LocalDate getStartKurs() {
        return startKurs;
    }

    public LocalDate getEndeKurs() {
        return endeKurs;
    }

    public ArrayList<Modul> getModule() {
        return this.module;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Teilnehmer> getTeilnehmerListe() {
        return teilnehmerListe;
    }

    public void checkTeilnehmerListeEmpty() {
        if (!teilnehmerListe.isEmpty())
            throw new IllegalArgumentException(
                    "Modul kann nicht hinzugefügt werden, weil bereits Teilnehmer eingetragen sind!");
    }

    public void checkDoppeltesModul(Modul modul) {
        for (Modul moduls : module) {
            if (moduls == modul)
                throw new IllegalArgumentException("Modul ist bereits im Kurs vorhanden!");
        }
    }

    public void addModul(Modul modul) {
        // Prüfung, ob ausreichend Aufgaben für das Modul vorhanden sind,
        // Startdatum des Moduls wird festgelegt, Enddatum des Moduls wird berechnet,
        // Ermittlung eines verfügbaren Mitarbeiters + direkte Zuweisung zum Modul,
        // falls kein freier Mitarbeiter verfügbar ist, kann das Modul nicht zugewiesen
        // werden
        // Neues Enddatum für den Kurs wird berechnet und gesetzt,
        // neue Buchung wird erzeugt, Mitarbeiter bekommt diese Buchung in seine Liste
        // geschrieben
        checkDoppeltesModul(modul);
        checkTeilnehmerListeEmpty();
        if (aufgabenUmfangInTage() < modul.getModulTage())
            throw new IllegalArgumentException("Nicht genügend Aufgaben für das Modul!");

        LocalDate startModul = (anzahlKurstage == 0) // Wenn die Kurslänge noch 0 ist, dann ist startmodul = start Kurs
                ? this.endeKurs
                : this.endeKurs.plusDays(1); // sonst wird zu startKurs immer 1 tag zuaddiert
        LocalDate endeModul = berechneModulEnde(modul, startModul);
        Mitarbeiter zugeteilterMitarbeiter = ermittleMitarbeiter(modul, startModul, endeModul);
        modul.setZugeteilterMitarbeiter(zugeteilterMitarbeiter);
        this.endeKurs = endeModul;
        this.module.add(modul);
        modul.setStartModul(startModul);
        modul.setEndeModul(endeModul);

        Buchung buchung = new Buchung(startModul, endeModul, modul.getName());
        zugeteilterMitarbeiter.addBuchung(buchung);
        mitarbeiterse.add(zugeteilterMitarbeiter);
        anzahlKurstage += modul.getModulTage();
    }

    private int aufgabenUmfangInTage() {
        ArrayList<Aufgabe> aufgabenPool = unternehmen.getAufgabenPool();
        int summeTage = 0;
        for (Aufgabe aufgabe : aufgabenPool) {
            Kategorie kategorieAufgabe = aufgabe.getKategorie();
            if (kategorie.equals(kategorieAufgabe))
                summeTage += aufgabe.getAufgabeTage();
        }
        return summeTage;
    }

    public void addTeilnehmer(Teilnehmer teilnehmer) {
        unternehmen.isTeilnehmerInAnderenKurs(teilnehmer); // Prüft nur ob, Teilnehmer schon einen anderen Kurs besucht
        if (teilnehmerListe.size() >= MAX_TEILNEHMER)
            throw new IllegalArgumentException("Teilnehmeranzahl überschritten!");
        teilnehmerListe.add(teilnehmer);
    }

    public LocalDate berechneModulEnde(Modul modul, LocalDate startModul) {
        LocalDate endeModul = startModul;
        for (int i = 1; i < modul.getModulTage(); i++) {
            endeModul = endeModul.plusDays(endeModul.getDayOfWeek() == DayOfWeek.FRIDAY ? 3 : 1);
        }
        return endeModul;
    }

    public ArrayList<Mitarbeiter> ermittleLinzensiertenMitarbeiter(Modul modul) {
        ArrayList<Mitarbeiter> verfuegbareMitarbeiter = new ArrayList<>();
        for (Mitarbeiter mitarbeiter : unternehmen.getMitarbeiterListe()) {
            ArrayList<Kategorie> mitarbeiterLizenzen = mitarbeiter.getLizenzliste();
            for (Kategorie linzenz : mitarbeiterLizenzen) {
                if (linzenz == modul.getBrauchLizenz())
                    verfuegbareMitarbeiter.add(mitarbeiter);
            }
        }
        return verfuegbareMitarbeiter;
    }

    public Mitarbeiter ermittleMitarbeiter(Modul modul, LocalDate startModul, LocalDate endeModul) {
        Mitarbeiter zugeteilterMitarbeiter = null;
        int anzahlMinKurse = 0;
        for (Mitarbeiter mitarbeiter : ermittleLinzensiertenMitarbeiter(modul)) {
            if (mitarbeiter.getBuchungen().isEmpty())
                return mitarbeiter;

            for (Buchung buchung : mitarbeiter.getBuchungen()) {
                LocalDate buchungStart = buchung.getStartDatum();
                LocalDate buchungEnde = buchung.getEndeDatum();

                if (buchungStart.isBefore(endeModul) && startModul.isAfter(buchungEnde)) {
                    int anzahlKurse = mitarbeiter.getBuchungen().size();
                    if (anzahlKurse > anzahlMinKurse) {
                        anzahlMinKurse = anzahlKurse;
                        zugeteilterMitarbeiter = mitarbeiter;
                    }
                }
            }
        }
        if (zugeteilterMitarbeiter == null)
            throw new IllegalArgumentException("Kein Mitarbeiter verfügbar!");
        return zugeteilterMitarbeiter;
    }
}
