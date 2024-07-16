public class Main {

    public static void main(String[] args) {
        Adresse addresse1 = new Adresse("Zobletitzstraße 89b", "Berlin", 13403);
        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Marcus", "Slomka",addresse1);

        Adresse adresse2 = new Adresse("Wunderstrasse", "Berlin", 13403);
        Teilnehmer teilnehmer1 = new Teilnehmer("Moritz", "Slomka", adresse2);

        System.out.println(mitarbeiter1.printPerson());
        System.out.println(teilnehmer1.printPerson());
    }
}