package Person_Klassen;

import java.util.ArrayList;

public class Person {
    private String vorname;
    private String nachname;
    private Adresse adresse;
   

    public Person(String newVorname, String newNachname, Adresse newAdresse) {
        this.vorname = newVorname;
        this.nachname = newNachname;
        this.adresse = newAdresse;
 
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





}
