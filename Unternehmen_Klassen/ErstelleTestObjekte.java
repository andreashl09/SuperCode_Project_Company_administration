package Unternehmen_Klassen;

import java.util.Random;

import Enum.Kategorie;
import Enum.UnternehmensKategorie;
import Kurs_Klassen.Aufgabe;
import Kurs_Klassen.Modul;
import Person_Klassen.Adresse;
import Person_Klassen.Mitarbeiter;
import Person_Klassen.Teilnehmer;

public class ErstelleTestObjekte {

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
        mitarbeiter2.addLizenz(Kategorie.SPRING);
        // Mitarbeiter 3
        Adresse addresse3 = new Adresse("Hauptstr. 24", "Berlin", 10115);
        Mitarbeiter mitarbeiter3 = new Mitarbeiter("Max", "Mustermann", addresse3);
        mitarbeiter3.addLizenz(Kategorie.SCRUM);
        mitarbeiter3.addLizenz(Kategorie.SPRING);
        unternehmen.addMitarbeiter(mitarbeiter3);

        // Mitarbeiter 4
        Adresse addresse4 = new Adresse("Nebenstr. 3", "München", 80331);
        Mitarbeiter mitarbeiter4 = new Mitarbeiter("Lisa", "Müller", addresse4);
        mitarbeiter4.addLizenz(Kategorie.CSS);
        mitarbeiter4.addLizenz(Kategorie.JAVASCRIPT);
        mitarbeiter4.addLizenz(Kategorie.WEBENTWICKLUNG);
        unternehmen.addMitarbeiter(mitarbeiter4);

        // Mitarbeiter 5
        Adresse addresse5 = new Adresse("Bahnhofstr. 8", "Frankfurt", 60311);
        Mitarbeiter mitarbeiter5 = new Mitarbeiter("Klaus", "Meier", addresse5);
        mitarbeiter5.addLizenz(Kategorie.JAVASCRIPT);
        mitarbeiter5.addLizenz(Kategorie.SPRING);
        unternehmen.addMitarbeiter(mitarbeiter5);

        // Mitarbeiter 6
        Adresse addresse6 = new Adresse("Rathausplatz 1", "Stuttgart", 70173);
        Mitarbeiter mitarbeiter6 = new Mitarbeiter("Petra", "Hoffmann", addresse6);
        mitarbeiter6.addLizenz(Kategorie.JAVA);
        mitarbeiter6.addLizenz(Kategorie.CSS);
        mitarbeiter6.addLizenz(Kategorie.WEBENTWICKLUNG);
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
        mitarbeiter9.addLizenz(Kategorie.WEBENTWICKLUNG);
        unternehmen.addMitarbeiter(mitarbeiter9);

        // Mitarbeiter 10
        Adresse addresse10 = new Adresse("Waldweg 11", "Bremen", 28195);
        Mitarbeiter mitarbeiter10 = new Mitarbeiter("Julia", "Weber", addresse10);
        mitarbeiter10.addLizenz(Kategorie.JAVA);
        mitarbeiter10.addLizenz(Kategorie.CSS);
        unternehmen.addMitarbeiter(mitarbeiter10);
    }

    public static void erstelleTeilnehmerUndFuegeHinzu(Bildungsunternehmen unternehmen, int anzahl) {
        Random rand = new Random();

        String[] strassen = { "Wunderstrasse", "Hauptstrasse", "Schillerstrasse", "Goethestrasse", "Bahnhofstrasse" };
        String[] staedte = { "Berlin", "Hamburg", "München", "Köln", "Frankfurt" };
        String[] vornamen = { "Moritz", "Max", "Lena", "Anna", "Tom" };
        String[] nachnamen = { "Slomka", "Meier", "Schmidt", "Fischer", "Becker" };

        for (int i = 1; i <= anzahl; i++) {
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

    public static void erstelleAufgabenUndFuegeHinzu(Bildungsunternehmen unternehmen, int anzahl) {
        UnternehmensKategorie unternehmensKategorie = unternehmen.getUnternehmensKategorie();
        Random rand = new Random();

        Kategorie[] IT = {
                Kategorie.CSS,
                Kategorie.JAVA,
                Kategorie.JAVASCRIPT,
                Kategorie.SCRUM,
                Kategorie.SPRING,
                Kategorie.WEBENTWICKLUNG };

        Kategorie[] WIRTSCHAFT = {
                Kategorie.FINANZEN,
                Kategorie.HANDEL,
                Kategorie.PRODUKTION,
                Kategorie.DIENSTLEISTUNGEN,
                Kategorie.TECHNOLOGIE,
                Kategorie.ARBEITSMARKT
        };

        Kategorie[] SOZIALES = {
                Kategorie.GESUNDHEIT,
                Kategorie.BILDUNG,
                Kategorie.WOHNUNG,
                Kategorie.SOZIALE_SICHERHEIT,
                Kategorie.INTEGRATION,
                Kategorie.FAMILIE
        };
        Kategorie[] ausgewählteKategorien;

        switch (unternehmensKategorie) {
            case IT:
                ausgewählteKategorien = IT;
                break;
            case WIRTSCHAFT:
                ausgewählteKategorien = WIRTSCHAFT;
                break;
            case SOZIALES:
                ausgewählteKategorien = SOZIALES;
                break;
            default:
                throw new IllegalArgumentException("Unbekannte UnternehmensKategorie: " + unternehmensKategorie);
        }

        for (int i = 1; i <= anzahl; i++) {
            Kategorie kategorie = ausgewählteKategorien[rand.nextInt(ausgewählteKategorien.length)];

            Aufgabe aufgabe = new Aufgabe(kategorie + "" + 1, kategorie, (rand.nextInt(2) + 1));
            unternehmen.addAufgabe(aufgabe);
        }

    }

    public static void erstelleModuleundFuegeHinzu(Bildungsunternehmen unternehmen, int anzahl) {
        UnternehmensKategorie unternehmensKategorie = unternehmen.getUnternehmensKategorie();
        Random rand = new Random();

        Kategorie[] IT = {
                Kategorie.CSS,
                Kategorie.JAVA,
                Kategorie.JAVASCRIPT,
                Kategorie.SCRUM,
                Kategorie.SPRING,
                Kategorie.WEBENTWICKLUNG };

        Kategorie[] WIRTSCHAFT = {
                Kategorie.FINANZEN,
                Kategorie.HANDEL,
                Kategorie.PRODUKTION,
                Kategorie.DIENSTLEISTUNGEN,
                Kategorie.TECHNOLOGIE,
                Kategorie.ARBEITSMARKT
        };

        Kategorie[] SOZIALES = {
                Kategorie.GESUNDHEIT,
                Kategorie.BILDUNG,
                Kategorie.WOHNUNG,
                Kategorie.SOZIALE_SICHERHEIT,
                Kategorie.INTEGRATION,
                Kategorie.FAMILIE
        };
        Kategorie[] ausgewählteKategorien;
        String[] ausgewählteModulThema;

        String[] modulNamenIT = {
                "Java Grundlagen", "Spring Framework", "Web Entwicklung", "Agile Methoden mit Scrum",
                "CSS für Anfänger",
                "JavaScript Grundlagen", "Java Fortgeschritten", "Spring Boot", "HTML und CSS", "Scrum Master Training",
                "Java Enterprise Edition", "Spring Security", "Web Design", "Scrum Praktiken", "CSS Layouts",
                "JavaScript Fortgeschritten", "RESTful Web Services", "Spring Cloud", "Moderne Webentwicklung",
                "JavaScript Frameworks"
        };

        String[] modulNamenWirtschaft = {
                "Buchführung Grundlagen", "Marketing Strategien", "Projektmanagement", "Finanzmanagement",
                "Unternehmensführung",
                "Personalwesen", "Wirtschaftsrecht", "Steuerlehre", "Investition und Finanzierung", "Controlling",
                "E-Commerce", "Internationales Management", "Supply Chain Management", "Kostenrechnung",
                "Entrepreneurship",
                "Change Management", "Vertrieb und Verkauf", "Wirtschaftsinformatik", "Marktanalyse",
                "Verhandlungsführung"
        };

        String[] modulNamenSoziales = {
                "Soziale Arbeit Grundlagen", "Psychologie für Sozialarbeiter", "Pädagogik",
                "Interkulturelle Kommunikation", "Sozialrecht",
                "Case Management", "Soziologie", "Familientherapie", "Jugendhilfe", "Beratung und Coaching",
                "Gesundheitsförderung", "Migration und Integration", "Soziale Dienste", "Krisenintervention",
                "Inklusion und Teilhabe",
                "Medienpädagogik", "Seniorenarbeit", "Gemeinwesenarbeit", "Kinder- und Jugendarbeit", "Suchtberatung"
        };

        switch (unternehmensKategorie) {
            case IT:
                ausgewählteKategorien = IT;
                ausgewählteModulThema = modulNamenIT;
                break;
            case WIRTSCHAFT:
                ausgewählteKategorien = WIRTSCHAFT;
                ausgewählteModulThema = modulNamenWirtschaft;
                break;
            case SOZIALES:
                ausgewählteKategorien = SOZIALES;
                ausgewählteModulThema = modulNamenSoziales;
                break;
            default:
                throw new IllegalArgumentException("Unbekannte UnternehmensKategorie: " + unternehmensKategorie);
        }

        for (int i = 1; i <= anzahl; i++) {
            String name = ausgewählteModulThema[i - 1];
            Kategorie kategorie = ausgewählteKategorien[rand.nextInt(ausgewählteKategorien.length)];
            int tage = 1 + rand.nextInt(10);

            Modul modul = new Modul(name, kategorie, tage);
            unternehmen.addModulZuListe(modul);
        }
    }
}
