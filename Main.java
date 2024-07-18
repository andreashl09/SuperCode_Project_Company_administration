import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Unternehmen_Klassen.*;
import Person_Klassen.*;
import Enum.*;
import Kurs_Klassen.*;

public class Main {

        public static void main(String[] args) {
                Bildungsunternehmen unternehmen1 = new Bildungsunternehmen("Supercode", "Andreas", LocalDate.now(),
                                UnternehmensKategorie.IT);

                ErstellePerson.erstelleMitarbeiterUndFuegeHinzu(unternehmen1);
                ErstellePerson.erstelleTeilnehmerUndFuegeHinzu(unternehmen1);

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

                kurs1.addModul(java1);
                kurs1.addModul(java2);
                kurs2.addModul(java3);
                kurs2.addModul(java4);

                kurs1.addTeilnehmer(unternehmen1.getTeilnehmerListe().get(0));
                kurs1.addTeilnehmer(unternehmen1.getTeilnehmerListe().get(1));

                // unternehmen1.getMitarbeiterListe().get(0).printBuchungen();
                unternehmen1.getTeilnehmerListe().get(0).bewertungAbgeben(5, "Alles knorke oder wat!!");

                // unternehmen1.getTeilnehmerListe().get(0).printFeedback();
                kurs1.printTeilnehmerBewertungen();
                // for (Mitarbeiter mitarbeiter : unternehmen1.mitarbeiter.getBuchungen()) {
                // mitarbeiter10.printBuchungen();
                // }

                // unternehmen1.printAlleKurse();
                // unternehmen1.zeigeMitarbeiterDiagramm();

                // unternehmen1.printBewertungen();
        }

}