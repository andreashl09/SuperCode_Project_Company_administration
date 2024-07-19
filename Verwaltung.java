import java.time.LocalDate;

import Unternehmen_Klassen.*;
import Person_Klassen.*;
import Enum.*;
import Kurs_Klassen.*;

public class Verwaltung {

        public static void main(String[] args) {
                Bildungsunternehmen unternehmen1 = new Bildungsunternehmen("Supercode", "Andreas", LocalDate.now(),
                                UnternehmensKategorie.IT);

                // Erstellung der Testobjekte
                erstelleMitarbeiter(unternehmen1);
                erstelleTeilnehmer(unternehmen1, 30);
                erstelleAufgabe(unternehmen1, 100); // - erfordliche Menge an Aufgaben für die Erstellung der Module,
                                                    // Aufgaben 1 bis 3 Tage
                erstelleModule(unternehmen1, 20);

                // Kurse erstellen und adden
                Kurs kurs1 = new Kurs("Java", LocalDate.now(), Kategorie.JAVA, unternehmen1);
                Kurs kurs2 = new Kurs("HTML / CSS ", LocalDate.now(), Kategorie.JAVA, unternehmen1);
                Kurs kurs3 = new Kurs("Javascript", LocalDate.now(), Kategorie.JAVA, unternehmen1);
                Kurs kurs4 = new Kurs("Spring", LocalDate.now(), Kategorie.SPRING, unternehmen1);
                Kurs kurs5 = new Kurs("Webentwicklung", LocalDate.now(), Kategorie.WEBENTWICKLUNG, unternehmen1);
                unternehmen1.addKurs(kurs1);
                unternehmen1.addKurs(kurs2);
                unternehmen1.addKurs(kurs3);

                // Module zu Kursen hinzufügen
                addModulZumKurs(unternehmen1, 0, 0);
                addModulZumKurs(unternehmen1, 1, 0);
                addModulZumKurs(unternehmen1, 3, 0);
                addModulZumKurs(unternehmen1, 4, 0);
                addModulZumKurs(unternehmen1, 5, 0);
                addModulZumKurs(unternehmen1, 3, 1);
                addModulZumKurs(unternehmen1, 4, 1);
                addModulZumKurs(unternehmen1, 5, 1);
                // addModulZumKurs(unternehmen1, 5, 0); //- Fehler: doppeltes Modul kann nicht
                // hinzgefügt werden
                // - wenn nicht genügend Trainer für die Menge der Module vorhanden sind, kann
                // Modul nicht zum Kurs hinzugefügt werden
                // - wenn Trainer nicht die passende Lizenz hat, kann dieser nicht hinzugfügt
                // werden

                // Teilnehmer zu Kurse hinzufügen
                addTeilnehmerZuKurs(unternehmen1, 0, 0);
                addTeilnehmerZuKurs(unternehmen1, 1, 0);
                addTeilnehmerZuKurs(unternehmen1, 2, 0);
                addTeilnehmerZuKurs(unternehmen1, 3, 1);
                addTeilnehmerZuKurs(unternehmen1, 4, 1);
                addTeilnehmerZuKurs(unternehmen1, 5, 1);
                addTeilnehmerZuKurs(unternehmen1, 6, 1);
                addTeilnehmerZuKurs(unternehmen1, 7, 1);
                addTeilnehmerZuKurs(unternehmen1, 8, 1);
                // addTeilnehmerZuKurs(unternehmen1, 8, 1); //- Teilnehmer kann nicht doppelt
                // hizugefügt werden

                teilnehmerGibtBewertungAb(unternehmen1, 1, 5, "Alles KNORKE!");
                teilnehmerGibtBewertungAb(unternehmen1, 0, 5, "STABILER KURS");
                teilnehmerGibtBewertungAb(unternehmen1, 8, 5, "Java ist auch eine Insel");
                // teilnehmerGibtBewertungAb(unternehmen1, 20, 5, "STABILER KURS"); //-
                // Teilnehmer kann nur eine Bewertung abgeben für seinen gebuchte Kurs
                // teilnehmerGibtBewertungAb(unternehmen1, 0, 5, "STABILER KURS"); //- Bewertung
                // kann nach abgeben nicht mehr geändertt werden
                teilnehmerHatNeuenJob(unternehmen1, 0, LocalDate.of(2024, 9, 13));
                teilnehmerHatNeuenJob(unternehmen1, 8, LocalDate.of(2024, 12, 13));

                // * Diverse Ausgaben
                // unternehmen1.printAlleKurse();
                // unternehmen1.printAufgabenListe();
                // unternehmen1.printModulListe();
                // unternehmen1.getTeilnehmerListe().get(0).printFeedback();
                // kurs1.printTeilnehmerBewertungen();
                // unternehmen1.zeigeMitarbeiterDiagramm();
                unternehmen1.printBewertungen();
        }

        public static void erstelleMitarbeiter(Bildungsunternehmen unternehmen) {
                ErstelleTestObjekte.erstelleMitarbeiterUndFuegeHinzu(unternehmen);

        }

        public static void erstelleTeilnehmer(Bildungsunternehmen unternehmen, int anzahl) {
                ErstelleTestObjekte.erstelleTeilnehmerUndFuegeHinzu(unternehmen, anzahl);

        }

        public static void erstelleAufgabe(Bildungsunternehmen unternehmen, int anzahl) {
                ErstelleTestObjekte.erstelleAufgabenUndFuegeHinzu(unternehmen, anzahl);

        }

        public static void erstelleModule(Bildungsunternehmen unternehmen, int anzahl) {
                ErstelleTestObjekte.erstelleModuleundFuegeHinzu(unternehmen, anzahl);
        }

        public static void addModulZumKurs(Bildungsunternehmen unternehmen, int modulId, int kursId) {
                unternehmen.getKursListe().get(kursId).addModul(unternehmen.getModulListe().get(modulId));
        }

        public static void addTeilnehmerZuKurs(Bildungsunternehmen unternehmen, int teilnehmerId, int kursId) {
                unternehmen.getKursListe().get(kursId)
                                .addTeilnehmer(unternehmen.getTeilnehmerListe().get(teilnehmerId));
        }

        public static void teilnehmerGibtBewertungAb(Bildungsunternehmen unternehmen, int teilnehmerId,
                        int bewertungKurs,
                        String feedback) {

                for (Kurs kurs : unternehmen.getKursListe()) {
                        for (Teilnehmer teilnehmer1 : kurs.getTeilnehmerListe()) {
                                if (teilnehmer1.getId() == teilnehmerId) {
                                        teilnehmer1.bewertungAbgeben(bewertungKurs, feedback);
                                        return;
                                }
                        }
                }
                System.out.println("Teilnehmer hat an keinen Kurs teilgenommen");
        }

        public static void teilnehmerHatNeuenJob(Bildungsunternehmen unternehmen, int teilnehmerid, LocalDate datum) {
                unternehmen.getTeilnehmerListe().get(teilnehmerid).erfolgreichVermittelt(datum);
        }
}