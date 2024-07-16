import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Bildungsunternehmen unternehmen1 = new Bildungsunternehmen("Supercode", "Andreas", LocalDate.now(), "IT");

        Adresse addresse1 = new Adresse("Zobletitzstraße 89b", "Berlin", 13403);
        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Marcus", "Slomka", addresse1);

        Adresse adresse2 = new Adresse("Wunderstrasse", "Berlin", 13403);
        Teilnehmer teilnehmer1 = new Teilnehmer("Moritz", "Slomka", adresse2);

        System.out.println(mitarbeiter1.printPerson());
        System.out.println(teilnehmer1.printPerson());
        
        unternehmen1.addAufgabe(new Aufgabe("Variablen und Datentypen", "Java Grundlagen", 1));
        unternehmen1.addAufgabe(new Aufgabe("Operatoren und Ausdrücke","Java Grundlagen", 1));
        unternehmen1.addAufgabe(new Aufgabe("Kontrollstrukturen (if, switch)", "Java Grundlagen", 2));
        unternehmen1.addAufgabe(new Aufgabe("Schleifen (for, while, do-while)", "Java Grundlagen", 2));

        Kurs kurs1 = new Kurs("Java lernen", LocalDate.now(), unternehmen1);
        Modul java1 = new Modul("Java Grundlagen", "Java", 6);

        kurs1.addModul(java1);
        // System.out.println(java1.getModulTage());

    }
}