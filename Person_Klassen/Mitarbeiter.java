package Person_Klassen;

import java.util.ArrayList;

import Enum.Kategorie;

public class Mitarbeiter extends Person {
    private static int idCounter;
    private int id;
    private ArrayList<Kategorie> lizenzliste;

    public Mitarbeiter(String newVorname, String newNachname, Adresse newAdresse) {
        super(newVorname, newNachname, newAdresse);
        this.lizenzliste = new ArrayList<>();
        this.id = idCounter;
        idCounter++;
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

    public int getId() {
        return id;
    }

    public void mitarbeiterDaten() {
        System.out.println(this.printPerson());
        System.out.println("Folgende Lizenzen:");
        for (Kategorie kategorie : lizenzliste) {
            System.out.println(kategorie);
        }
    }

}
