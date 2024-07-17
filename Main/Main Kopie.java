import java.time.LocalDate;

import Enum.*;
import Kurs_Klassen.*;
import Person_Klassen.*;
import Unternehmen_Klassen.*;

public class Main {

    public static void main(String[] args) {
        Bildungsunternehmen unternehmen1 = new Bildungsunternehmen("TheSuper", "Andreas", LocalDate.now(),
                UnternehmensKategorie.IT);

        erstelleRandomAufgaben(unternehmen1, 30);
        erstelleRandomTeilnehmer(unternehmen1, 40);
        erstelleRandomMitarbeiter(unternehmen1, 10);

        // unternehmen1.printTeilnehmerListe();
        // unternehmen1.getMitarbeiterListe().get(0).mitarbeiterDaten();

        Kurs kurs1 = new Kurs("Java lernen", LocalDate.now(), Kategorie.JAVA, unternehmen1);
        Kurs kurs2 = new Kurs("Java lernen", LocalDate.now(), Kategorie.JAVA,
                unternehmen1);
        Modul java1 = new Modul("Java Grundlagen", Kategorie.JAVA, 6);
        Modul java2 = new Modul("Java Grundlagen", Kategorie.JAVA, 5);
        Modul java3 = new Modul("Java Grundlagen", Kategorie.JAVA, 5);
        Modul java4 = new Modul("Java Grundlagen", Kategorie.JAVA, 5);

        kurs1.addModul(java1);
        kurs1.addModul(java2);
        kurs2.addModul(java3);
        kurs2.addModul(java4);
        //

        System.out.println(kurs1.getStartKurs());
        System.out.println(kurs1.getEndeKurs());

    }

    public static void erstelleRandomAufgaben(Bildungsunternehmen unternehmen, int anzahl) {
        Kategorie[] kategories = {
                Kategorie.JAVA,
                Kategorie.SPRING,
                Kategorie.WEBENTWICKLUNG,
                Kategorie.SCRUM,
                Kategorie.CSS,
                Kategorie.JAVASCRIPT
        };

        for (int i = 0; i <= anzahl; i++) {
            int aufgabeTage = (int) (Math.random() * 3) + 1;
            Kategorie randomKategorie = kategories[(int) (Math.random() * kategories.length)];
            unternehmen.addAufgabe(new Aufgabe("Aufgabe" + i, randomKategorie, aufgabeTage));
        }

    }

    public static void erstelleRandomTeilnehmer(Bildungsunternehmen unternehmen, int anzahl) {
        for (int i = 1; i <= anzahl; i++) {
            Adresse adresse = new Adresse("Wunderstrasse " + i, "Stadt" + i, 10000 + i);
            unternehmen.addTeilnehmer(new Teilnehmer("Vorname" + i, "Nachname" + i, adresse));
        }
    }

    public static void erstelleRandomMitarbeiter(Bildungsunternehmen unternehmen, int anzahl) {
        Kategorie[] kategories = {
                Kategorie.JAVA,
                Kategorie.SPRING,
                Kategorie.WEBENTWICKLUNG,
                Kategorie.SCRUM,
                Kategorie.CSS,
                Kategorie.JAVASCRIPT
        };

        for (int i = 0; i <= anzahl; i++) {
            Kategorie randomKategorie = kategories[(int) (Math.random() * kategories.length)];
            Adresse addresse = new Adresse("Straße" + 1, "Ort" + 1, 10000 + 1);
            unternehmen.addMitarbeiter(new Mitarbeiter("Vorname" + 1, "Nachname" + i, addresse));
            unternehmen.getMitarbeiterListe().get(i).addLizenz(randomKategorie);
        }
    }
}