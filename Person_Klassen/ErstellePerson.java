package Person_Klassen;

import java.util.Random;

import Enum.Kategorie;
import Unternehmen_Klassen.Bildungsunternehmen;

public class ErstellePerson {

    public static void erstelleMitarbeiterUndFuegeHinzu(Bildungsunternehmen unternehmen) {
        // Mitarbeiter 1
        Adresse addresse1 = new Adresse("Bekannten Str. 12z", "Bielefeld", 45793);
        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Jochen", "Schlotzmann",
                addresse1);
        unternehmen.addMitarbeiter(mitarbeiter1);
        mitarbeiter1.addLizenz(Kategorie.JAVASCRIPT);
        mitarbeiter1.addLizenz(Kategorie.JAVA);
        mitarbeiter1.addLizenz(Kategorie.SCRUM);

        // Mitarbeiter 2
        Adresse addresse2 = new Adresse("Musterweg 5", "Hamburg", 20095);
        Mitarbeiter mitarbeiter2 = new Mitarbeiter("Maria", "Schmidt", addresse2);
        unternehmen.addMitarbeiter(mitarbeiter2);
        mitarbeiter2.addLizenz(Kategorie.JAVA);

        // Mitarbeiter 3
        Adresse addresse3 = new Adresse("Hauptstr. 24", "Berlin", 10115);
        Mitarbeiter mitarbeiter3 = new Mitarbeiter("Max", "Mustermann", addresse3);
        mitarbeiter3.addLizenz(Kategorie.SCRUM);
        unternehmen.addMitarbeiter(mitarbeiter3);

        // Mitarbeiter 4
        Adresse addresse4 = new Adresse("Nebenstr. 3", "München", 80331);
        Mitarbeiter mitarbeiter4 = new Mitarbeiter("Lisa", "Müller", addresse4);
        mitarbeiter4.addLizenz(Kategorie.CSS);
        mitarbeiter4.addLizenz(Kategorie.JAVASCRIPT);
        unternehmen.addMitarbeiter(mitarbeiter4);

        // Mitarbeiter 5
        Adresse addresse5 = new Adresse("Bahnhofstr. 8", "Frankfurt", 60311);
        Mitarbeiter mitarbeiter5 = new Mitarbeiter("Klaus", "Meier", addresse5);
        mitarbeiter5.addLizenz(Kategorie.JAVASCRIPT);
        unternehmen.addMitarbeiter(mitarbeiter5);

        // Mitarbeiter 6
        Adresse addresse6 = new Adresse("Rathausplatz 1", "Stuttgart", 70173);
        Mitarbeiter mitarbeiter6 = new Mitarbeiter("Petra", "Hoffmann", addresse6);
        mitarbeiter6.addLizenz(Kategorie.JAVA);
        mitarbeiter6.addLizenz(Kategorie.CSS);
        unternehmen.addMitarbeiter(mitarbeiter6);

        // Mitarbeiter 7
        Adresse addresse7 = new Adresse("Marktplatz 7", "Düsseldorf", 40213);
        Mitarbeiter mitarbeiter7 = new Mitarbeiter("Lars", "Fischer", addresse7);
        mitarbeiter7.addLizenz(Kategorie.SCRUM);
        unternehmen.addMitarbeiter(mitarbeiter7);

        // Mitarbeiter 8
        Adresse addresse8 = new Adresse("Schulstr. 9", "Leipzig", 41090);
        Mitarbeiter mitarbeiter8 = new Mitarbeiter("Anna", "Bauer", addresse8);
        mitarbeiter8.addLizenz(Kategorie.CSS);
        mitarbeiter8.addLizenz(Kategorie.JAVASCRIPT);
        unternehmen.addMitarbeiter(mitarbeiter8);

        // Mitarbeiter 9
        Adresse addresse9 = new Adresse("Ringstr. 10", "Dortmund", 44135);
        Mitarbeiter mitarbeiter9 = new Mitarbeiter("Robert", "Schneider", addresse9);
        mitarbeiter9.addLizenz(Kategorie.JAVASCRIPT);
        unternehmen.addMitarbeiter(mitarbeiter9);

        // Mitarbeiter 10
        Adresse addresse10 = new Adresse("Waldweg 11", "Bremen", 28195);
        Mitarbeiter mitarbeiter10 = new Mitarbeiter("Julia", "Weber", addresse10);
        mitarbeiter10.addLizenz(Kategorie.JAVA);
        mitarbeiter10.addLizenz(Kategorie.CSS);
        unternehmen.addMitarbeiter(mitarbeiter10);
    }

    public static void erstelleTeilnehmerUndFuegeHinzu(Bildungsunternehmen unternehmen) {
        Random rand = new Random();

        String[] strassen = { "Wunderstrasse", "Hauptstrasse", "Schillerstrasse", "Goethestrasse", "Bahnhofstrasse" };
        String[] staedte = { "Berlin", "Hamburg", "München", "Köln", "Frankfurt" };
        String[] vornamen = { "Moritz", "Max", "Lena", "Anna", "Tom" };
        String[] nachnamen = { "Slomka", "Meier", "Schmidt", "Fischer", "Becker" };

        for (int i = 1; i <= 20; i++) {
            String strasse = strassen[rand.nextInt(strassen.length)];
            String stadt = staedte[rand.nextInt(staedte.length)];
            int plz = 10000 + rand.nextInt(90000);
            Adresse adresse = new Adresse(strasse, stadt, plz);

            String vorname = vornamen[rand.nextInt(vornamen.length)];
            String nachname = nachnamen[rand.nextInt(nachnamen.length)];
            Teilnehmer teilnehmer = new Teilnehmer(vorname, nachname, adresse);
            unternehmen.addTeilnehmer(teilnehmer);

        }
    }
}
