public class Main {

    public static void main(String[] args) {
        Adresse addresse1 = new Adresse("Zobletitzstraße 89b", "Berlin", 13403);
        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Marcus", "Slomka", addresse1);

        Adresse adresse2 = new Adresse("Wunderstrasse", "Berlin", 13403);
        Teilnehmer teilnehmer1 = new Teilnehmer("Moritz", "Slomka", adresse2);

        System.out.println(mitarbeiter1.printPerson());
        System.out.println(teilnehmer1.printPerson());

        Modul java1 = new Modul("Java Grundlagen", "Java");

        Aufgabe aufgabeJava1 = new Aufgabe("Variablen und Datentypen", 1);
        Aufgabe aufgabeJava2 = new Aufgabe("Operatoren und Ausdrücke", 1);
        Aufgabe aufgabeJava3 = new Aufgabe("Kontrollstrukturen (if, switch)", 2);
        Aufgabe aufgabeJava4 = new Aufgabe("Schleifen (for, while, do-while)", 2);

        java1.addAufgabe(aufgabeJava1);
        java1.addAufgabe(aufgabeJava2);
        java1.addAufgabe(aufgabeJava3);
        java1.addAufgabe(aufgabeJava4);

        System.out.println(java1.getModulTage());

    }
}