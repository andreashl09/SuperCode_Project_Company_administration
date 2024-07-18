package Person_Klassen;

import java.util.ArrayList;

import Enum.Kategorie;

public class Mitarbeiter extends Person {
    private static int idCounter;
    private int id;
    private ArrayList<Kategorie> lizenzliste;
    private ArrayList<Buchung> buchungen;

    public Mitarbeiter(String newVorname, String newNachname, Adresse newAdresse) {
        super(newVorname, newNachname, newAdresse);
        this.lizenzliste = new ArrayList<>();
        this.id = idCounter;
        idCounter++;
        buchungen = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Buchung> getBuchungen() {
        return buchungen;
    }

    public ArrayList<Kategorie> getLizenzliste() {
        return lizenzliste;
    }

    public void setLizenzliste(ArrayList<Kategorie> lizenzliste) {
        this.lizenzliste = lizenzliste;
    }

    public void addLizenz(Kategorie kategorie) {
        lizenzliste.add(kategorie);
    }

    public void addBuchung(Buchung buchung) {
        this.buchungen.add(buchung); 
    }

    public void mitarbeiterDaten() {
        System.out.println(this.printPerson());
        System.out.println("Folgende Lizenzen:");
        for (Kategorie kategorie : lizenzliste) {
            System.out.println(kategorie);
        }
    }

    public void printBuchungen() {
        for (Buchung buchung : buchungen) {
            System.out.println(buchung.printBuchung());
        }
    }

}
