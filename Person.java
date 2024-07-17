

import java.util.ArrayList;

public class Person {
    private static int idCounter;
    private int id;
    private String vorname;
    private String nachname;
    private Adresse adresse;
    private ArrayList<Buchung> buchungen;

    public Person(String newVorname, String newNachname, Adresse newAdresse) {
        this.vorname = newVorname;
        this.nachname = newNachname;
        this.adresse = newAdresse;
        this.id = idCounter;
        idCounter++;
        buchungen = new ArrayList<>();
    }

    public String getVorname() {
        return this.vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public int getId() {
        return this.id;
    }

    public String printPerson() {
        return "Vorname: " + this.vorname + " Nachname: " + this.nachname + " Adresse: " + this.adresse.printAdresse();
    }

    public ArrayList<Buchung> getBuchungen() {
        return this.buchungen;
    }

    public void addBuchung(Buchung buchung) {
        this.buchungen.add(buchung);
    }
}
