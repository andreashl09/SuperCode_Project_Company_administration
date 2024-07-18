import java.time.LocalDate;

import Unternehmen_Klassen.*;
import Person_Klassen.*;
import Enum.*;
import Kurs_Klassen.*;

public class Main {

        public static void main(String[] args) {
                Bildungsunternehmen unternehmen1 = new Bildungsunternehmen("Supercode", "Andreas", LocalDate.now(),
                                UnternehmensKategorie.IT);
                // Mitarbeiter 1
                Adresse addresse1 = new Adresse("Bekannten Str. 12z", "Bielefeld", 45793);
                // Mitarbeiter mitarbeiter1 = new Mitarbeiter("Jochen", "Schlotzmann",
                // addresse1);
                unternehmen1.addMitarbeiter(new Mitarbeiter("Jochen", "Schlotzmann", addresse1));
                // mitarbeiter1.addLizenz(Kategorie.JAVA);

                // Mitarbeiter 2
                Adresse addresse2 = new Adresse("Musterweg 5", "Hamburg", 20095);
                // Mitarbeiter mitarbeiter2 = new Mitarbeiter("Maria", "Schmidt", addresse2);
                unternehmen1.addMitarbeiter(new Mitarbeiter("Maria", "Schmidt", addresse2));
                // mitarbeiter2.addLizenz(Kategorie.JAVA);

                // Mitarbeiter 3
                Adresse addresse3 = new Adresse("Hauptstr. 24", "Berlin", 10115);
                Mitarbeiter mitarbeiter3 = new Mitarbeiter("Max", "Mustermann", addresse3);
                mitarbeiter3.addLizenz(Kategorie.SCRUM);
                unternehmen1.addMitarbeiter(mitarbeiter3);

                // Mitarbeiter 4
                Adresse addresse4 = new Adresse("Nebenstr. 3", "München", 80331);
                Mitarbeiter mitarbeiter4 = new Mitarbeiter("Lisa", "Müller", addresse4);
                mitarbeiter4.addLizenz(Kategorie.CSS);
                unternehmen1.addMitarbeiter(mitarbeiter4);

                // Mitarbeiter 5
                Adresse addresse5 = new Adresse("Bahnhofstr. 8", "Frankfurt", 60311);
                Mitarbeiter mitarbeiter5 = new Mitarbeiter("Klaus", "Meier", addresse5);
                mitarbeiter5.addLizenz(Kategorie.JAVASCRIPT);
                unternehmen1.addMitarbeiter(mitarbeiter5);

                // Mitarbeiter 6
                Adresse addresse6 = new Adresse("Rathausplatz 1", "Stuttgart", 70173);
                Mitarbeiter mitarbeiter6 = new Mitarbeiter("Petra", "Hoffmann", addresse6);
                mitarbeiter6.addLizenz(Kategorie.JAVA);
                unternehmen1.addMitarbeiter(mitarbeiter6);

                // Mitarbeiter 7
                Adresse addresse7 = new Adresse("Marktplatz 7", "Düsseldorf", 40213);
                Mitarbeiter mitarbeiter7 = new Mitarbeiter("Lars", "Fischer", addresse7);
                mitarbeiter7.addLizenz(Kategorie.SCRUM);
                unternehmen1.addMitarbeiter(mitarbeiter7);

                // Mitarbeiter 8
                Adresse addresse8 = new Adresse("Schulstr. 9", "Leipzig", 41090);
                Mitarbeiter mitarbeiter8 = new Mitarbeiter("Anna", "Bauer", addresse8);
                mitarbeiter8.addLizenz(Kategorie.CSS);
                unternehmen1.addMitarbeiter(mitarbeiter8);

                // Mitarbeiter 9
                Adresse addresse9 = new Adresse("Ringstr. 10", "Dortmund", 44135);
                Mitarbeiter mitarbeiter9 = new Mitarbeiter("Robert", "Schneider", addresse9);
                mitarbeiter9.addLizenz(Kategorie.JAVASCRIPT);
                unternehmen1.addMitarbeiter(mitarbeiter9);

                // Mitarbeiter 10
                Adresse addresse10 = new Adresse("Waldweg 11", "Bremen", 28195);
                Mitarbeiter mitarbeiter10 = new Mitarbeiter("Julia", "Weber", addresse10);
                mitarbeiter10.addLizenz(Kategorie.JAVA);
                unternehmen1.addMitarbeiter(mitarbeiter10);

                Adresse adresse2 = new Adresse("Wunderstrasse", "Berlin", 13403);
                Teilnehmer teilnehmer1 = new Teilnehmer("Moritz", "Slomka", adresse2);
                Adresse adresse3 = new Adresse("Wunderstrasse", "Berlin", 13403);
                Teilnehmer teilnehmer2 = new Teilnehmer("Moritz", "Slomka", adresse2);

                unternehmen1.addAufgabe(new Aufgabe("Variablen und Datentypen", Kategorie.JAVA, 1));
                unternehmen1.addAufgabe(new Aufgabe("Operatoren und Ausdrücke", Kategorie.JAVA, 1));
                unternehmen1.addAufgabe(new Aufgabe("Kontrollstrukturen (if, switch)", Kategorie.JAVA, 2));
                unternehmen1.addAufgabe(new Aufgabe("Schleifen (for, while, do-while)",
                                Kategorie.JAVA, 2));

                Kurs kurs1 = new Kurs("Java lernen", LocalDate.now(), Kategorie.JAVA, unternehmen1);
                Kurs kurs2 = new Kurs("Java lernen", LocalDate.now(), Kategorie.JAVA, unternehmen1);
                Kurs kurs3 = new Kurs("Java lernen", LocalDate.now(), Kategorie.JAVA, unternehmen1);
                unternehmen1.addKurs(kurs1);
                unternehmen1.addKurs(kurs2);
                unternehmen1.addKurs(kurs3);
                Modul java1 = new Modul("Java Grundlagen", Kategorie.JAVA, 6);
                Modul java2 = new Modul("Java Grundlagen", Kategorie.JAVA, 5);
                Modul java3 = new Modul("Java Grundlagen", Kategorie.JAVA, 5);
                Modul java4 = new Modul("Java Grundlagen", Kategorie.JAVA, 5);

                // kurs1.addModul(java1);
                // kurs1.addModul(java2);
                // kurs2.addModul(java3);
                // kurs2.addModul(java4);

                // kurs1.addTeilnehmer(teilnehmer1);
                // kurs1.addTeilnehmer(teilnehmer2);

                // for (Mitarbeiter mitarbeiter : unternehmen1.mitarbeiter.getBuchungen()) {
                // mitarbeiter10.printBuchungen();
                // }

                // unternehmen1.zeigeMitarbeiterDiagramm();

                unternehmen1.printBewertungen();
        }
}