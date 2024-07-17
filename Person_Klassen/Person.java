package Person_Klassen;

import java.util.ArrayList;

public class Person {
    private String vorname;
    private String nachname;
    private Adresse adresse;
    private ArrayList<Buchung> buchungen;

    public Person(String newVorname, String newNachname, Adresse newAdresse) {
        this.vorname = newVorname;
        this.nachname = newNachname;
        this.adresse = newAdresse;
        buchungen = new ArrayList<>();
    }

    public String getVorname() {
        return this.vorname;
    }

    public String getNachname() {
        return this.nachname;
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

    public void printBuchungen() {
        for (Buchung buchung : buchungen) {
            System.out.println(buchung.printBuchung());
        }
    }
}
