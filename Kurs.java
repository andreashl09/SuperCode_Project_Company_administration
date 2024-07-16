import java.time.LocalDate;
import java.util.ArrayList;

public class Kurs {
    private static int kursIdCounter;
    private int id;
    private String name;
    private LocalDate startKurs;
    private LocalDate endeKurs;
    private int anzahlKurstage = 0;
    private ArrayList<Modul> module;
    private ArrayList<Teilnehmer> teilnehmers;
    // private ArrayList<Mitarbeiter> trainers;
    private final int MAX_TEILNEHMER = 8;
    private Bildungsunternehmen unternehmen;
    private Kategorie kategorie;

    public Kurs(String name, LocalDate startKurs, Kategorie kategorie, Bildungsunternehmen unternehmen) {
        this.kategorie = kategorie;
        this.id = kursIdCounter;
        kursIdCounter++;
        this.unternehmen = unternehmen;
        this.name = name;
        this.startKurs = startKurs;
        module = new ArrayList<>();
        teilnehmers = new ArrayList<>();
        // trainers = new ArrayList<>();
    }

    public void addModul(Modul modul) {
        int tageCounter = 0;
        Kategorie suchKategorie = kategorie;
        tageCounter = getAufgabenPool(tageCounter, suchKategorie);
        if (tageCounter < modul.getModulTage())
            throw new IllegalArgumentException("Nicht genügend Aufgaben für das Modul!");
        this.module.add(modul);
        ermittleTrainer(startKurs, endeKurs, modul);

    }

    private int getAufgabenPool(int tageCounter, Kategorie suchKategorie) {
        ArrayList<Aufgabe> aufgabenPool = unternehmen.getAufgabenPool();
        for (Aufgabe aufgabe : aufgabenPool) {
            Kategorie kategorie = aufgabe.getKategorie();
            if (suchKategorie.equals(kategorie))
                tageCounter += aufgabe.getAufgabeTage();
        }
        return tageCounter;
    }

    public void addTeilnehmer(Teilnehmer teilnehmer) {
        if (teilnehmers.size() >= MAX_TEILNEHMER)
            throw new IllegalArgumentException("Teilnehmeranzahl überschritten!");
        teilnehmers.add(teilnehmer);
    }

    public void berechneEndDatum() {
        this.endeKurs = startKurs.plusDays(anzahlKurstage);
    }

    public void ermittleTrainer(LocalDate start, LocalDate end, Modul modul) {
        ArrayList<Mitarbeiter> verfuegbareMitarbeiter = new ArrayList<>();
        for (Mitarbeiter mitarbeiter : unternehmen.getMitarbeiterListe()) {
            ArrayList<Kategorie> mitarbeiterLizenzen = mitarbeiter.getLizenzliste();
            for (Kategorie linzenz : mitarbeiterLizenzen) {
                if (linzenz != modul.getBrauchLizenz())
                    return;
                else
                    verfuegbareMitarbeiter.add(mitarbeiter);
            }
        }
    }
}
